using System;
using System.Data.SqlClient;
using static CinemaTickets.Entities.Entities;

namespace CinemaTickets.Database
{
    internal class AdminRepository
    {
        private Koneksi connect;

        public AdminRepository()
        {
            connect = new Koneksi();
        }

        public Admin GetAdminByUsernameAndPassword(string username, string password)
        {
            connect.BukaKoneksi();
            string query = "SELECT * FROM Admin WHERE Username = @Username AND Password = @Password";
            SqlCommand command = new SqlCommand(query, connect.con);
            command.Parameters.AddWithValue("@Username", username);
            command.Parameters.AddWithValue("@Password", password);

            SqlDataReader reader = command.ExecuteReader();
            Admin admin = null;
            if (reader.Read())
            {
                admin = new Admin
                {
                    ID = (int)reader["ID"],
                    Username = reader["Username"].ToString(),
                    Password = reader["Password"].ToString()
                };
            }
            connect.TutupKoneksi();

            return admin;
        }
    }
}
