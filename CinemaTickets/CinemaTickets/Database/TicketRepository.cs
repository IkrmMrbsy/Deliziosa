using System.Collections.Generic;
using System.Data.SqlClient;
using System.Windows.Forms;
using System;
using CinemaTickets;
using static CinemaTickets.Entities.Entities;

public class TicketRepository
{
    private Koneksi connect;

    public TicketRepository()
    {
        connect = new Koneksi();
    }

    public void SaveTicket(int filmId, string scheduleTime, List<string> seatNumbers, decimal hargaPerKursi)
    {
        try
        {
            connect.BukaKoneksi();

            foreach (string seatNumber in seatNumbers)
            {
                string insertQuery = $"INSERT INTO Ticket (IDFilm, Tanggal, Jam, NomorKursi, Harga) " +
                    $"VALUES (@filmId, GETDATE(), @scheduleTime, @seatNumber, @hargaPerKursi)";

                using (SqlCommand command = new SqlCommand(insertQuery, connect.con))
                {
                    command.Parameters.AddWithValue("@filmId", filmId);
                    command.Parameters.AddWithValue("@scheduleTime", scheduleTime);
                    command.Parameters.AddWithValue("@seatNumber", seatNumber);
                    command.Parameters.AddWithValue("@hargaPerKursi", hargaPerKursi);

                    command.ExecuteNonQuery();
                }
            }
        }
        catch (Exception ex)
        {
            MessageBox.Show("Error: " + ex.Message);
        }
        finally
        {
            connect.TutupKoneksi(); // Tutup koneksi ke database setelah selesai
        }
    }


    public int GetFilmIdByFilmName(string filmName)
    {
        int filmId = 0;
        try
        {
            connect.BukaKoneksi();
            string query = $"SELECT FilmId FROM Films WHERE FilmName = @FilmName";
            using (SqlCommand command = new SqlCommand(query, connect.con))
            {
                command.Parameters.AddWithValue("@FilmName", filmName);
                object result = command.ExecuteScalar();
                if (result != null)
                {
                    filmId = Convert.ToInt32(result);
                }
            }
        }
        catch (Exception ex)
        {
            MessageBox.Show("Error: " + ex.Message);
        }
        finally
        {
            connect.TutupKoneksi();
        }
        return filmId;
    }

}
