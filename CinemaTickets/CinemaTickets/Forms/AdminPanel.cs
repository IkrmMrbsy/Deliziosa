using System.Data.SqlClient;
using System.Windows.Forms;
using System;
using CinemaTickets.Database;
using static CinemaTickets.Entities.Entities;
using System.IO;
using System.Drawing;
using System.Collections.Generic;

namespace CinemaTickets
{
    public partial class AdminPanel : Form
    {
        Koneksi connect;

        public AdminPanel()
        {
            InitializeComponent();
            connect = new Koneksi();
        }

        private void btsearch_Click(object sender, EventArgs e)
        {
            try
            {
                int filmId = int.Parse(txtidfilm.Text);
                FilmRepository repository = new FilmRepository();
                Film film = repository.GetFilmById(filmId);
                if (film != null)
                {
                    txtnamefilm.Text = film.Judul;

                    // Ambil jadwal dari FilmRepository berdasarkan filmId
                    List<string> schedules = repository.GetSchedulesByFilmId(filmId);

                    if (schedules.Count >= 1)
                    {
                        // Tampilkan jadwal pertama pada dtdate dan dttime
                        string[] scheduleParts = schedules[0].Split('-');
                        dtdate.Value = DateTime.Parse(scheduleParts[0].Trim());
                        dttime.Value = DateTime.Today.Add(TimeSpan.Parse(scheduleParts[1].Trim()));

                        if (schedules.Count >= 2)
                        {
                            // Tampilkan jadwal kedua pada dtdate2 dan dttime2
                            scheduleParts = schedules[1].Split('-');
                            dtdate2.Value = DateTime.Parse(scheduleParts[0].Trim());
                            dttime2.Value = DateTime.Today.Add(TimeSpan.Parse(scheduleParts[1].Trim()));
                        }

                        if (schedules.Count >= 3)
                        {
                            // Tampilkan jadwal ketiga pada dtdate3 dan dttime3
                            scheduleParts = schedules[2].Split('-');
                            dtdate3.Value = DateTime.Parse(scheduleParts[0].Trim());
                            dttime3.Value = DateTime.Today.Add(TimeSpan.Parse(scheduleParts[1].Trim()));
                        }
                    }

                    // Convert byte[] to Image and display in PictureBox
                    using (MemoryStream ms = new MemoryStream(film.Gambar))
                    {
                        pictbox.Image = Image.FromStream(ms);
                    }

                    txtduration.Text = film.Durasi.ToString();
                }
                else
                {
                    MessageBox.Show("Film dengan ID tersebut tidak ditemukan.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Terjadi Kesalahan " + ex.Message);
            }
        }


        public void btupdate_Click(object sender, EventArgs e)
        {
            try
            {
                int filmId = int.Parse(txtidfilm.Text);
                string judulFilm = txtnamefilm.Text;
                DateTime tanggalTayang = dtdate.Value;
                TimeSpan jam = dttime.Value.TimeOfDay;
                byte[] gambar = null;
                int durasi = int.Parse(txtduration.Text);

                // Convert Image to byte[]
                if (pictbox.Image != null)
                {
                    using (MemoryStream ms = new MemoryStream())
                    {
                        pictbox.Image.Save(ms, System.Drawing.Imaging.ImageFormat.Png);
                        gambar = ms.ToArray();
                    }
                }

                Film film = new Film
                {
                    ID = filmId,
                    Judul = judulFilm,
                    Tanggal = tanggalTayang,
                    Jam = jam,
                    Gambar = gambar,
                    Durasi = durasi
                };

                FilmRepository repository = new FilmRepository();
                bool resultFilm = repository.UpdateFilm(film);
                bool resultSchedule = repository.UpdateSchedule(filmId, tanggalTayang, jam);

                if (resultFilm && resultSchedule)
                {
                    MessageBox.Show("Film dan jadwal berhasil diupdate!");

                    // Update DateTimePicker values
                    dtdate.Value = tanggalTayang;
                    dttime.Value = DateTime.Today.Add(jam);
                    dtdate2.Value = dtdate2.Value.Date; // Tetapkan tanggal yang sama seperti sebelumnya
                    dttime2.Value = dtdate2.Value.Date.Add(dttime2.Value.TimeOfDay); // Tetapkan jam yang sama seperti sebelumnya
                    dtdate3.Value = dtdate3.Value.Date; // Tetapkan tanggal yang sama seperti sebelumnya
                    dttime3.Value = dtdate3.Value.Date.Add(dttime3.Value.TimeOfDay); // Tetapkan jam yang sama seperti sebelumnya

                    pictbox.Image = null;
                    txtnamefilm.Text = "";
                    dtdate.Value = DateTime.Now;
                    dttime.Value = DateTime.Now.Date;
                    txtidfilm.Text = "";
                    txtduration.Text = "";
                }
                else
                {
                    MessageBox.Show("Gagal mengupdate film dan jadwal.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Terjadi Kesalahan " + ex.Message);
            }
        }




        private void btimage_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.Filter = "Image Files (*.jpg, *.jpeg, *.png, *.gif)|*.jpg;*.jpeg;*.png;*.gif";
            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                pictbox.ImageLocation = openFileDialog.FileName;
            }
        }

        public void btdelete_Click(object sender, EventArgs e)
        {
            try
            {
                if (MessageBox.Show("Apakah Anda yakin ingin menghapus film ini?", "Konfirmasi", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes)
                {
                    int filmId = int.Parse(txtidfilm.Text);
                    FilmRepository repository = new FilmRepository();
                    bool result = repository.DeleteFilm(filmId);

                    if (result)
                    {
                        MessageBox.Show("Film berhasil dihapus!");
                        pictbox.Image = null;
                        txtnamefilm.Text = "";
                        dtdate.Value = DateTime.Now;
                        txtidfilm.Text = "";
                        txtduration.Text = "";
                    }
                    else
                    {
                        MessageBox.Show("Gagal menghapus film!");
                    }
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Terjadi Kesalahan " + ex.Message);
            }

        }

        private void addfilm_Click(object sender, EventArgs e)
        {
            try
            {
                string judulFilm = txtnamefilm2.Text;
                byte[] gambar;

                Image image = pictbox2.Image;
                using (MemoryStream ms = new MemoryStream())
                {
                    image.Save(ms, image.RawFormat);
                    gambar = ms.ToArray();
                }

                int durasi = int.Parse(txtduration2.Text);

                Film film = new Film
                {
                    Judul = judulFilm,
                    Gambar = gambar,
                    Durasi = durasi
                };

                FilmRepository repository = new FilmRepository();
                bool result = repository.AddFilm(film);
                if (result)
                {
                    MessageBox.Show("Film berhasil ditambahkan!");
                    pictbox2.Image = null;
                    txtnamefilm2.Text = "";
                    txtduration2.Text = "";
                }
                else
                {
                    MessageBox.Show("Gagal menambahkan film.");
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show("Terjadi Kesalahan " + ex.Message);
            }
        }

        private void btaddimage_Click(object sender, EventArgs e)
        {
            OpenFileDialog openFileDialog = new OpenFileDialog();
            openFileDialog.Filter = "Image Files (*.jpg, *.jpeg, *.png, *.gif)|*.jpg;*.jpeg;*.png;*.gif";
            if (openFileDialog.ShowDialog() == DialogResult.OK)
            {
                pictbox2.ImageLocation = openFileDialog.FileName;
            }
        }

        private void btback_Click_1(object sender, EventArgs e)
        {
            Landing landingForm = new Landing();
            landingForm.Show();

            this.Close();
        }

        private void dateTimePicker4_ValueChanged(object sender, EventArgs e)
        {

        }
    }
}