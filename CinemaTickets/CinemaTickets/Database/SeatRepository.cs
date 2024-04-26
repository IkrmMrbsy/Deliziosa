using CinemaTickets;
using static CinemaTickets.Entities.Entities;
using System.Collections.Generic;
using System.Data.SqlClient;
using System;

public class SeatRepository
{
    private Koneksi connect;

    public SeatRepository()
    {
        connect = new Koneksi();
    }

    public Seat GetSeatBySeatNumber(string seatNumber)
    {
        Seat seat = null;
        string query = "SELECT * FROM Seats WHERE SeatNumber = @SeatNumber";

        try
        {
            connect.BukaKoneksi();

            using (SqlCommand command = new SqlCommand(query, connect.con))
            {
                command.Parameters.AddWithValue("@SeatNumber", seatNumber);
                SqlDataReader reader = command.ExecuteReader();

                if (reader.Read())
                {
                    seat = new Seat
                    {
                        ID = (int)reader["ID"],
                        StudioID = (int)reader["StudioID"],
                        SeatNumber = reader["SeatNumber"].ToString(),
                        Status = reader["Status"].ToString(),
                        Price = (decimal)reader["Price"]
                    };
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error: " + ex.Message);
        }
        finally
        {
            connect.TutupKoneksi();
        }

        return seat;
    }

    public bool UpdateSeatStatus(string seatNumber, string newStatus)
    {
        string query = "UPDATE Seats SET Status = @NewStatus WHERE SeatNumber = @SeatNumber";

        try
        {
            connect.BukaKoneksi();

            using (SqlCommand command = new SqlCommand(query, connect.con))
            {
                command.Parameters.AddWithValue("@NewStatus", newStatus);
                command.Parameters.AddWithValue("@SeatNumber", seatNumber);

                int rowsAffected = command.ExecuteNonQuery();

                return rowsAffected > 0;
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error: " + ex.Message);
            return false;
        }
        finally
        {
            connect.TutupKoneksi();
        }
    }

    public List<Seat> GetAvailableSeatsByStudioId(int studioId)
    {
        List<Seat> availableSeats = new List<Seat>();
        string query = "SELECT * FROM Seats WHERE StudioID = @StudioID AND Status = 'Available'";

        try
        {
            connect.BukaKoneksi();

            using (SqlCommand command = new SqlCommand(query, connect.con))
            {
                command.Parameters.AddWithValue("@StudioID", studioId);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Seat seat = new Seat
                    {
                        ID = (int)reader["ID"],
                        StudioID = (int)reader["StudioID"],
                        SeatNumber = reader["SeatNumber"].ToString(),
                        Status = reader["Status"].ToString(),
                        Price = (decimal)reader["Price"]
                    };

                    availableSeats.Add(seat);
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error: " + ex.Message);
        }
        finally
        {
            connect.TutupKoneksi();
        }

        return availableSeats;
    }

    public List<Seat> GetBookedSeatsByStudioId(int studioId)
    {
        List<Seat> bookedSeats = new List<Seat>();
        string query = "SELECT * FROM Seats WHERE StudioID = @StudioID AND Status = 'Booked'";

        try
        {
            connect.BukaKoneksi();

            using (SqlCommand command = new SqlCommand(query, connect.con))
            {
                command.Parameters.AddWithValue("@StudioID", studioId);
                SqlDataReader reader = command.ExecuteReader();

                while (reader.Read())
                {
                    Seat seat = new Seat
                    {
                        ID = (int)reader["ID"],
                        StudioID = (int)reader["StudioID"],
                        SeatNumber = reader["SeatNumber"].ToString(),
                        Status = reader["Status"].ToString(),
                        Price = (decimal)reader["Price"]
                    };

                    bookedSeats.Add(seat);
                }
            }
        }
        catch (Exception ex)
        {
            Console.WriteLine("Error: " + ex.Message);
        }
        finally
        {
            connect.TutupKoneksi();
        }

        return bookedSeats;
    }


}
