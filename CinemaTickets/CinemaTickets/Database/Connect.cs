using System;
using System.Data;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace CinemaTickets
{
    internal class Koneksi
    {
        String Source;
        public SqlConnection con;

        public Koneksi()
        {
            try
            {
                Source = "Integrated Security=true;Initial Catalog=CinemaTicketsDB;Data Source=.";
                con = new SqlConnection(Source);
            }
            catch (Exception Sqle)
            {
                MessageBox.Show("Error : " + Sqle.Message);
            }
        }

        public void BukaKoneksi()
        {
            if (con.State == ConnectionState.Closed)
            {
                try
                {
                    con.Open();
                }
                catch (SqlException Sqle)
                {
                    MessageBox.Show("Error : " + Sqle.Message);
                }
            }
        }

        public void TutupKoneksi()
        {
            if (con.State == ConnectionState.Open)
            {
                try
                {
                    con.Close();
                }
                catch (SqlException Sqle)
                {
                    MessageBox.Show("Error : " + Sqle.Message);
                }
            }
        }

    }
}
