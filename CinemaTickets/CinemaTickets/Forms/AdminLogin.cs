using CinemaTickets.Database;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static CinemaTickets.Entities.Entities;

namespace CinemaTickets.Forms
{
    public partial class AdminLogin : Form
    {
        private AdminRepository adminRepository = new AdminRepository();
        public AdminLogin()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void textBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string username = textBox1.Text;
            string password = textBox2.Text;

            Admin admin = adminRepository.GetAdminByUsernameAndPassword(username, password);
            if (admin != null)
            {
                MessageBox.Show("Login berhasil");
                // Lakukan tindakan yang sesuai setelah login berhasil
                AdminPanel adminPanel = new AdminPanel();
                adminPanel.Show();
                this.Hide();
            }
            else
            {
                MessageBox.Show("Login gagal. Username atau password salah.");
            }
        }


    }
}
