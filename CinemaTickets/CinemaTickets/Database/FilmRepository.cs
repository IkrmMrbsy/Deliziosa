using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Drawing;
using static CinemaTickets.Entities.Entities;

namespace CinemaTickets.Database
{
    public class FilmRepository
    {
        private Koneksi connect;

        public FilmRepository()
        {
            connect = new Koneksi();
        }

        public Film GetFilmById(int filmId)
        {
            connect.BukaKoneksi();
            string query = "SELECT f.FilmId, f.FilmName, f.ImagePath, f.Duration, s.Tanggal, s.Jam " +
                           "FROM Films f " +
                           "INNER JOIN Schedule s ON f.FilmId = s.IDFilm " +
                           "WHERE f.FilmId = @FilmId";
            SqlCommand command = new SqlCommand(query, connect.con);
            command.Parameters.AddWithValue("@FilmId", filmId);

            SqlDataReader reader = command.ExecuteReader();
            Film film = null;
            if (reader.Read())
            {
                film = new Film
                {
                    ID = (int)reader["FilmId"],
                    Judul = reader["FilmName"].ToString(),
                    Gambar = (byte[])reader["ImagePath"],
                    Durasi = (int)reader["Duration"],
                    Tanggal = (DateTime)reader["Tanggal"],
                    Jam = (TimeSpan)reader["Jam"]
                };
            }
            connect.TutupKoneksi();

            return film;
        }

        public bool UpdateFilm(Film film)
        {
            connect.BukaKoneksi();
            string query = "UPDATE Films SET FilmName = @filmName, ImagePath = @imagePath, Duration = @duration WHERE FilmId = @filmId";
            SqlCommand command = new SqlCommand(query, connect.con);
            command.Parameters.AddWithValue("@filmName", film.Judul);
            command.Parameters.AddWithValue("@filmId", film.ID);
            command.Parameters.AddWithValue("@imagePath", film.Gambar);
            command.Parameters.AddWithValue("@duration", film.Durasi);

            int rowsAffected = command.ExecuteNonQuery();
            connect.TutupKoneksi();

            return rowsAffected > 0;
        }

        public bool UpdateSchedule(int filmId, DateTime tanggal, TimeSpan jam)
        {
            connect.BukaKoneksi();
            string query = "UPDATE Schedule SET Tanggal = @tanggal, Jam = @jam WHERE IDFilm = @filmId";
            SqlCommand command = new SqlCommand(query, connect.con);
            command.Parameters.AddWithValue("@tanggal", tanggal);
            command.Parameters.AddWithValue("@jam", jam);
            command.Parameters.AddWithValue("@filmId", filmId);

            int rowsAffected = command.ExecuteNonQuery();
            connect.TutupKoneksi();

            return rowsAffected > 0;
        }


        public bool AddFilm(Film film)
        {
            connect.BukaKoneksi();

            // Mendapatkan nilai minimum FilmId yang ada dalam tabel
            string query = "SELECT ISNULL(MIN(FilmId), 0) FROM Films";
            SqlCommand minIdCommand = new SqlCommand(query, connect.con);
            int minId = (int)minIdCommand.ExecuteScalar();

            // Mendapatkan nilai maksimum FilmId yang ada dalam tabel
            query = "SELECT ISNULL(MAX(FilmId), 0) FROM Films";
            SqlCommand maxIdCommand = new SqlCommand(query, connect.con);
            int maxId = (int)maxIdCommand.ExecuteScalar();

            // Mencari ID yang hilang di antara 1 hingga 6
            int newFilmId = 0;
            for (int i = 1; i <= 6; i++)
            {
                if (i < minId || i > maxId)
                {
                    newFilmId = i;
                    break;
                }
            }

            // Jika tidak ada ID yang tersedia, kembalikan false
            if (newFilmId == 0)
            {
                connect.TutupKoneksi();
                return false;
            }

            // Menambahkan data film baru ke dalam tabel
            query = "INSERT INTO Films (FilmId, FilmName, ImagePath, Duration) VALUES (@filmId, @filmName, @imagePath, @duration)";
            SqlCommand command = new SqlCommand(query, connect.con);
            command.Parameters.AddWithValue("@filmId", newFilmId);
            command.Parameters.AddWithValue("@filmName", film.Judul);
            command.Parameters.AddWithValue("@imagePath", film.Gambar);
            command.Parameters.AddWithValue("@duration", film.Durasi);

            int rowsAffected = command.ExecuteNonQuery();
            connect.TutupKoneksi();

            return rowsAffected > 0;
        }

        public bool DeleteFilm(int filmId)
        {
            connect.BukaKoneksi();
            string query = "DELETE FROM Films WHERE FilmId = @FilmId";
            SqlCommand command = new SqlCommand(query, connect.con);
            command.Parameters.AddWithValue("@FilmId", filmId);

            int rowsAffected = command.ExecuteNonQuery();
            connect.TutupKoneksi();

            return rowsAffected > 0;
        }

        /* public List<Film> GetAllFilms()
         {
             List<Film> films = new List<Film>();
             connect.BukaKoneksi();
             string query = "SELECT * FROM Films";
             SqlCommand command = new SqlCommand(query, connect.con);
             SqlDataReader reader = command.ExecuteReader();
             while (reader.Read())
             {
                 Film film = new Film
                 {
                     ID = (int)reader["FilmId"],
                     Judul = reader["FilmName"].ToString(),
                     Durasi = (int)reader["Duration"],
                     TanggalTayang = (DateTime)reader["ShowDateTime"],
                     Gambar = reader["ImagePath"].ToString()
                 };
                 films.Add(film);
             }
             connect.TutupKoneksi();
             return films;
         }*/

        public void DisplayImage(string filmId, PictureBox pictureBox, Label labelFilmName, Label labelDuration)
        {
            try
            {
                connect.BukaKoneksi();
                string query = "SELECT ImagePath, FilmName, Duration FROM Films WHERE FilmId = @id";
                SqlCommand com = new SqlCommand(query, connect.con);
                com.Parameters.AddWithValue("@id", filmId);
                SqlDataReader dr = com.ExecuteReader();
                if (dr.Read())
                {
                    byte[] imageData = (byte[])dr["ImagePath"];
                    using (MemoryStream ms = new MemoryStream(imageData))
                    {
                        Image image = Image.FromStream(ms);
                        pictureBox.Image = image;
                    }

                    labelFilmName.Text = dr["FilmName"].ToString();
                    labelDuration.Text = $"{(int)dr["Duration"]} MIN";
                }
                else
                {
                    //MessageBox.Show("Gambar tidak ditemukan.");
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                connect.TutupKoneksi();
            }
        }

        public List<string> GetSchedulesByFilmId(int filmId)
        {
            List<string> schedules = new List<string>();

            try
            {
                connect.BukaKoneksi();
                string query = "SELECT Tanggal, Jam FROM Schedule WHERE IDFilm = @filmId";
                SqlCommand com = new SqlCommand(query, connect.con);
                com.Parameters.AddWithValue("@filmId", filmId);
                SqlDataReader dr = com.ExecuteReader();
                while (dr.Read())
                {
                    DateTime tanggal = (DateTime)dr["Tanggal"];
                    TimeSpan jam = (TimeSpan)dr["Jam"];
                    string schedule = $"{tanggal.ToShortDateString()} - {jam.ToString()}";
                    schedules.Add(schedule);
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                connect.TutupKoneksi();
            }

            return schedules;
        }

        public List<string> GetSeatsBySchedule(int scheduleId)
        {
            List<string> seats = new List<string>();

            try
            {
                connect.BukaKoneksi();
                string query = "SELECT SeatNumber FROM Seats WHERE ScheduleID = @scheduleId";
                SqlCommand com = new SqlCommand(query, connect.con);
                com.Parameters.AddWithValue("@scheduleId", scheduleId);
                SqlDataReader dr = com.ExecuteReader();
                while (dr.Read())
                {
                    string seatNumber = dr["SeatNumber"].ToString();
                    seats.Add(seatNumber);
                }
                dr.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
            finally
            {
                connect.TutupKoneksi();
            }

            return seats;
        }


        /* public List<Seat> GetSeatsByFilmId(int filmId)
         {
             List<Seat> seats = new List<Seat>();
             connect.BukaKoneksi();
             string query = "SELECT * FROM Seats WHERE FilmId = @FilmId";
             SqlCommand command = new SqlCommand(query, connect.con);
             command.Parameters.AddWithValue("@FilmId", filmId);
             SqlDataReader reader = command.ExecuteReader();
             while (reader.Read())
             {
                 Seat seat = new Seat
                 {
                     ID = (int)reader["ID"],
                     StudioID = (int)reader["StudioID"],
                     SeatNumber = reader["SeatNumber"].ToString(),
                     Status = reader["Status"].ToString(),
                     Price = (decimal)reader["Price"]
                 };
                 seats.Add(seat);
             }
             connect.TutupKoneksi();
             return seats;
         }*/
    }

}
