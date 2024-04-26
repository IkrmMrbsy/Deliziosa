using System;

namespace CinemaTickets.Entities
{
    public class Entities
    {
        public class Film
        {
            public int ID { get; set; }
            public string Judul { get; set; }
            public int Durasi { get; set; }
            public DateTime Tanggal { get; set; }
            public TimeSpan Jam {  get; set; }
            public byte[] Gambar { get; set; }
        }

        public class Studio
        {
            public int ID { get; set; }
            public string NamaStudio { get; set; }
            public int Kapasitas { get; set; }
        }

        public class Seat
        {
            public int ID { get; set; }
            public int StudioID { get; set; }
            public string SeatNumber { get; set; }
            public string Status { get; set; }
            public decimal Price { get; set; }
        }


        public class Jadwal
        {
            public int ID { get; set; }
            public int IDFilm { get; set; }
            public int IDStudio { get; set; }
            public DateTime Tanggal { get; set; }
            public TimeSpan Jam { get; set; }
        }

        public class Tiket
        {
            public int ID { get; set; }
            public int IDFilm { get; set; }
            public DateTime Tanggal { get; set; }
            public TimeSpan Jam { get; set; }
            public string NomorKursi { get; set; }
            public decimal Harga { get; set; }
        }


        public class Admin
        {
            public int ID { get; set; }
            public string Username { get; set; }
            public string Password { get; set; }
        }
    }

}
