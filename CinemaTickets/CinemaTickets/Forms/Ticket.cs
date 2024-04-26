using CinemaTickets.Database;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Runtime.Remoting.Contexts;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static CinemaTickets.Entities.Entities;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace CinemaTickets
{
    public partial class Ticket : Form
    {
        private Koneksi connect;
        private List<Panel> seatPanels = new List<Panel>();
        private List<Panel> panels = new List<Panel>();
        private List<string> clickedCodes = new List<string>();
        private int selectedFilmId;
        private const decimal HargaPerKursi = 10.00m; // Harga per kursi
        private decimal totalHarga = 0.00m; // Total harga awal
        public Ticket()
        {
            connect = new Koneksi();
            InitializeComponent();
            ui.PanelHelper.SetForm(this, 1, 1);
            ui.PanelHelper.BorderRadius(panel3, 10);
            ui.PanelHelper.BorderRadius(panel4, 10);
            ui.PanelHelper.BorderRadius(panel5, 10);
            ui.PanelHelper.BorderRadius(panel51, 10);
            ui.PanelHelper.BorderRadius(panel52, 10);
            ui.PanelHelper.BorderRadius(panel53, 10);
            ui.PanelHelper.BorderRadius(panel, 10);
            ui.PanelHelper.BorderRadius(panel55, 10);

            AddSeatList();
            LoadSeatDataFromDatabase();

            for (char row = 'A'; row <= 'E'; row++)
            {
                for (int col = 1; col <= 9; col++)
                {
                    // Cari panel berdasarkan nama yang dihasilkan
                    Panel panel = Controls.Find($"{row}{col}", true)[0] as Panel;
                    if (panel != null)
                    {
                        // Tambahkan panel ke dalam list dan tambahkan event handler
                        panels.Add(panel);
                        panel.Click += Panel_Click;
                    }
                }
            }
        }

        private void AddSeatList()
        {
            for (char row = 'A'; row <= 'E'; row++)
            {
                for (int col = 1; col <= 9; col++)
                {
                    // Cari panel berdasarkan nama yang dihasilkan
                    Panel panel = Controls.Find($"{row}{col}", true)[0] as Panel;
                    if (panel != null)
                    {
                        // Tambahkan panel ke dalam list
                        seatPanels.Add(panel);
                        // Setel properti Tag dengan nomor kursi
                        panel.Tag = $"{row}{col}";
                    }
                }
            }
        }


        private void LoadSeatDataFromDatabase()
        {
            string query = "SELECT SeatNumber, Status FROM Seats";

            try
            {
                connect.BukaKoneksi();

                using (SqlCommand command = new SqlCommand(query, connect.con))
                {
                    SqlDataReader reader = command.ExecuteReader();

                    while (reader.Read())
                    {
                        string seatNumber = reader["SeatNumber"].ToString();
                        string status = reader["Status"].ToString();

                        // Temukan panel yang sesuai dengan nomor kursi dari database
                        Panel panel = seatPanels.Find(p => p.Name.EndsWith(seatNumber));

                        // Sesuaikan properti panel berdasarkan status kursi dari database
                        if (panel != null)
                        {
                            if (status == "Booked")
                            {
                                panel.BackColor = System.Drawing.Color.Red; // Misalnya, jika kursi sudah dipesan, atur warna panel menjadi merah
                            }
                            else
                            {
                                panel.BackColor = System.Drawing.Color.DarkGray; // Jika kursi tersedia, atur warna panel menjadi hijau
                            }
                        }
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


        public void SetFilmId(int filmId)
        {
            // Mengambil data film dari database berdasarkan ID
            FilmRepository filmRepository = new FilmRepository();
            Film film = filmRepository.GetFilmById(filmId);

            // Memeriksa apakah film ditemukan
            if (film != null)
            {
                // Jika film ditemukan, setel teks label dengan judul film
                lblFilm.Text = film.Judul;

                // Mengambil daftar jadwal berdasarkan ID film
                List<string> schedules = filmRepository.GetSchedulesByFilmId(filmId);

                // Menambahkan daftar jam jadwal ke dalam ComboBox
                cmboxschedule.Items.Clear();
                foreach (string schedule in schedules)
                {
                    // Misalnya, jika format jadwal adalah "Tanggal - Jam", kita hanya ingin menampilkan jam
                    string[] parts = schedule.Split('-');
                    if (parts.Length >= 2)
                    {
                        cmboxschedule.Items.Add(parts[1].Trim());
                    }
                }
            }
            else
            {
                // Jika film tidak ditemukan, tampilkan pesan kesalahan
                lblFilm.Text = "Film not found";
            }
        }


        private const int MaxSelectedPanels = 5;
        private void Panel_Click(object sender, EventArgs e)
        {
            Panel clickedPanel = (Panel)sender;
            string seatNumber = clickedPanel.Tag as string;

            SeatRepository seatRepository = new SeatRepository();
            Seat seat = seatRepository.GetSeatBySeatNumber(seatNumber);

            if (seat != null)
            {
                if (seat.Status == "Booked")
                {
                    MessageBox.Show("Bangku sudah dipesan", "Peringatan", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                    return;
                }

                if (!clickedCodes.Contains(seatNumber))
                {
                    if (clickedCodes.Count < MaxSelectedPanels)
                    {
                        clickedPanel.BackColor = Color.DarkOrange;
                        clickedCodes.Add(seatNumber);
                        totalHarga += seat.Price; // Menambahkan harga kursi yang dipilih ke total harga
                    }
                    else
                    {
                        MessageBox.Show("Maaf, Anda hanya dapat memilih maksimal 5 kursi setiap satu tiket.", "Peringatan",
                                        MessageBoxButtons.OK, MessageBoxIcon.Warning);
                        return;
                    }
                }
                else
                {
                    clickedPanel.BackColor = Color.DarkGray;
                    clickedCodes.Remove(seatNumber);
                    totalHarga -= seat.Price; // Mengurangi harga kursi yang tidak dipilih dari total harga
                }

                // Menampilkan total harga tiket ke dalam label
                lbprice.Text = totalHarga.ToString("N2");
                UpdateLabel();

            }
        }

        private void UpdateLabel()
        {
            // Jika tidak ada panel yang diklik, atur teks label menjadi kosong
            if (clickedCodes.Count == 0)
            {
                label21.Text = "";
                return;
            }

            // Tampilkan kode di label
            label21.Text = string.Join(", ", clickedCodes);
        }

        private void btback_Click(object sender, EventArgs e)
        {
            Home homeForm = new Home();
            homeForm.Show();

            this.Close();
        }

        private void btproccess_Click(object sender, EventArgs e)
        {
            // Cek apakah semua field sudah terisi
            if (string.IsNullOrEmpty(lblFilm.Text) ||
                string.IsNullOrEmpty(cmboxschedule.Text) ||
                clickedCodes.Count == 0 ||
                string.IsNullOrEmpty(comboboxpayment.Text))
            {
                MessageBox.Show("Mohon lengkapi semua data terlebih dahulu.", "Peringatan", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            // Cek apakah combobox2 sudah terisi
            if (comboboxpayment.SelectedIndex == -1)
            {
                MessageBox.Show("Mohon pilih metode pembayaran.", "Peringatan", MessageBoxButtons.OK, MessageBoxIcon.Warning);
                return;
            }

            // Dapatkan nomor kursi yang dibeli
            List<string> seatNumbers = clickedCodes;

            // Mendapatkan informasi tiket dari form
            string filmName = lblFilm.Text; // Ubah ini sesuai dengan cara Anda mendapatkan nama film

            // Instantiate TicketRepository
            TicketRepository ticketRepository = new TicketRepository();

            int filmId = ticketRepository.GetFilmIdByFilmName(filmName);
            string scheduleTime = cmboxschedule.Text; // Jam penayangan

            decimal hargaPerKursi;
            if (!decimal.TryParse(lbprice.Text, out hargaPerKursi))
            {
                MessageBox.Show("Format harga tidak valid.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }

            // Menyimpan informasi tiket ke dalam database
            ticketRepository.SaveTicket(filmId, scheduleTime, seatNumbers, hargaPerKursi);

            // Update status kursi menjadi "Booked"
            SeatRepository seatRepository = new SeatRepository();
            foreach (string seatNumber in seatNumbers)
            {
                seatRepository.UpdateSeatStatus(seatNumber, "Booked");
            }

            // Tampilkan detail pembelian dalam message box
            string message = $"Detail Pembelian:\n\nNama Film: {filmName}\nJam: {scheduleTime}\nHarga: {hargaPerKursi.ToString("N2")}\nNomor Kursi: {string.Join(", ", seatNumbers)}";
            DialogResult result = MessageBox.Show(message, "Detail Pembelian", MessageBoxButtons.OK, MessageBoxIcon.Information);

            if (result == DialogResult.OK)
            {
                // Redirect ke form Print
                Print printForm = new Print();
                printForm.Show();

                this.Close();
            }



        }
    }
}
