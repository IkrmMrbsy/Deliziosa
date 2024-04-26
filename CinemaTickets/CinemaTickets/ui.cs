using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Windows.Forms;

namespace CinemaTickets
{
    internal class ui
    {
        public class PanelHelper
        {
            public static void SetForm(Form form, double widthRatio, double heightRatio)
            {
                int screenWidth = Screen.PrimaryScreen.Bounds.Width;
                int screenHeight = Screen.PrimaryScreen.Bounds.Height;
                int newWidth = (int)(screenWidth * widthRatio);
                int newHeight = (int)(screenHeight * heightRatio);
                form.Size = new Size(newWidth, newHeight);
            }

            public static void BorderRadius(Control control, int radius)
            {
                GraphicsPath path = new GraphicsPath();
                Rectangle bounds = new Rectangle(0, 0, control.Width, control.Height);
                int diameter = radius * 2;

                path.AddArc(bounds.X, bounds.Y, diameter, diameter, 180, 90);
                path.AddArc(bounds.Right - diameter, bounds.Y, diameter, diameter, 270, 90);
                path.AddArc(bounds.Right - diameter, bounds.Bottom - diameter, diameter, diameter, 0, 90);
                path.AddArc(bounds.X, bounds.Bottom - diameter, diameter, diameter, 90, 90);
                path.CloseFigure();

                control.Region = new Region(path);
            }



            // center berdasarkan layar
            public static void CenterScreen(Control control)
            {
                int screenWidth = Screen.PrimaryScreen.Bounds.Width;
                int posX = (screenWidth - control.Width) / 2;
                int posY = (screenWidth - control.Width) / 2;
                control.Location = new Point(posX, posY);
            }
            public static void CenterScreenX(Control control)
            {
                int screenWidth = Screen.PrimaryScreen.Bounds.Width;
                int posX = (screenWidth - control.Width) / 2;
                control.Location = new Point(posX, control.Location.Y);
            }
            public static void CenterScreenY(Control control)
            {
                int screenWidth = Screen.PrimaryScreen.Bounds.Width;
                int posY = (screenWidth - control.Width) / 2;
                control.Location = new Point(control.Location.X, posY);
            }

            //center berdasarkan panel
            public static void CenterPanel(Control control)
            {
                Control container = control.Parent;

                int containerWidth = container.ClientSize.Width;
                int containerHeight = container.ClientSize.Height;

                int posX = (containerHeight - control.Height) / 2;
                int posY = (containerHeight - control.Height) / 2;

                control.Location = new Point(posX, posY);
            }
            public static void CenterPanelX(Control control)
            {
                Control container = control.Parent;

                int containerWidth = container.ClientSize.Width;
                int containerHeight = container.ClientSize.Height;

                int posX = (containerHeight - control.Height) / 2;

                control.Location = new Point(posX, control.Location.Y);
            }
            public static void CenterPanelY(Control control)
            {
                Control container = control.Parent;

                int containerWidth = container.ClientSize.Width;
                int containerHeight = container.ClientSize.Height;

                int posY = (containerHeight - control.Height) / 2;

                control.Location = new Point(control.Location.X, posY);
            }
        }
    }
}
