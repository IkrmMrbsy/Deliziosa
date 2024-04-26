using CinemaTickets.Database;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static CinemaTickets.Entities.Entities;
using static System.Net.Mime.MediaTypeNames;

namespace CinemaTickets
{
    public partial class Home : Form
    {
        private Ticket ticket;
        List<(Panel, PictureBox)> panels = new List<(Panel, PictureBox)>();
        private FilmRepository filmRepository = new FilmRepository();
        private Timer timerUpdate = new Timer();
        private int currentImageId = 1;


        public Home()
        {
            InitializeComponent();
            timerUpdate.Interval = 3000;
            timerUpdate.Tick += TimerUpdate_Tick;
            timerUpdate.Start();

            ticket = new Ticket();
            filmRepository = new FilmRepository();
            ui.PanelHelper.SetForm(this, 1, 1);

            panels.Add((panel7, pictbox0));
            panels.Add((panel6, pictbox1));
            panels.Add((panel8, pictbox2));
            panels.Add((panel9, pictbox3));
            panels.Add((panel10, pictbox4));
            panels.Add((panel11, pictbox5));
            panels.Add((panel12, pictbox6));

            InitializeClickHandlers();

            ui.PanelHelper.BorderRadius(panel5, 10);
            ui.PanelHelper.BorderRadius(panel6, 10);
            ui.PanelHelper.BorderRadius(panel7, 10);
            ui.PanelHelper.BorderRadius(pictbox0, 10);
            ui.PanelHelper.BorderRadius(pictbox1, 10);
            ui.PanelHelper.BorderRadius(panel8, 10);
            ui.PanelHelper.BorderRadius(pictbox2, 10);
            ui.PanelHelper.BorderRadius(panel9, 10);
            ui.PanelHelper.BorderRadius(pictbox3, 10);
            ui.PanelHelper.BorderRadius(panel10, 10);
            ui.PanelHelper.BorderRadius(pictbox4, 10);
            ui.PanelHelper.BorderRadius(panel11, 10);
            ui.PanelHelper.BorderRadius(pictbox5, 10);
            ui.PanelHelper.CenterScreenX(panel5);
            ui.PanelHelper.BorderRadius(panel12, 10);
            ui.PanelHelper.BorderRadius(pictbox6, 10);
        }

        private void LoadImage(int imageId, PictureBox pictureBox, Label labelName, Label labelDuration)
        {
            filmRepository.DisplayImage(imageId.ToString(), pictureBox, labelName, labelDuration);
            pictureBox.Tag = imageId;
        }

        private void Home_Load(object sender, EventArgs e)
        {
            try
            {
                LoadImage(1, pictbox1, lbname1, lbduration1);
                LoadImage(2, pictbox2, lbname2, lbduration2);
                LoadImage(3, pictbox3, lbname3, lbduration3);
                LoadImage(4, pictbox4, lbname4, lbduration4);
                LoadImage(5, pictbox5, lbname5, lbduration5);
                LoadImage(6, pictbox6, lbname6, lbduration6);
            }
            catch (Exception ex)
            {
                MessageBox.Show("Error: " + ex.Message);
            }
        }

        private void InitializeClickHandlers()
        {
            foreach (var (panel, pictureBox) in panels)
            {
                pictureBox.Click += Panel_Click;
            }
        }

        private void Panel_Click(object sender, EventArgs e)
        {
            if (sender is PictureBox clickedPictureBox) // Periksa apakah sender adalah objek PictureBox
            {
                if (clickedPictureBox.Tag != null)
                {
                    int filmId;
                    if (int.TryParse(clickedPictureBox.Tag.ToString(), out filmId))
                    {
                        ticket.SetFilmId(filmId); // Teruskan ID film ke form tiket
                        ticket.Show();
                        this.Hide();
                    }
                    else
                    {
                        MessageBox.Show("Film ID is not valid.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
                else
                {
                    MessageBox.Show("Film ID is not set for the clicked PictureBox.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            else
            {
                MessageBox.Show("Clicked object is not a PictureBox.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
        }




        private async void TimerUpdate_Tick(object sender, EventArgs e)
        {
            LoadImage(currentImageId, pictbox0, lbname0, lbduration0);

            currentImageId++;
            if (currentImageId > 6)
            {
                currentImageId = 1;
            }
        }
        private async void panel5_Paint(object sender, PaintEventArgs e)//Ga Kepake
        {

        }

        private void btback_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
