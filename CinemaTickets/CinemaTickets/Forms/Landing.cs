using CinemaTickets.Forms;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace CinemaTickets
{
    public partial class Landing : Form
    {
        private Home home;
        private AdminLogin adminLogin;

        public Landing()
        {
            InitializeComponent();

            home = new Home();
            adminLogin = new AdminLogin();
            ui.PanelHelper.CenterScreenX(panel3);
            ui.PanelHelper.BorderRadius(btnAdmin, 100);
            ui.PanelHelper.BorderRadius(btnTicket, 100);
        }

        private void ticket_click(object sender, EventArgs e)
        {
            if (home != null)
            {
                home.Show();
                this.Hide();
            }
        }

        private void admin_click(object sender, EventArgs e)
        {
            if (adminLogin != null)
            {
                adminLogin.Show();
                this.Hide();
            }
        }
    }
}
