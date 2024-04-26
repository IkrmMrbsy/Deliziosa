/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ticketconcert;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author LENOVO
 */
public class Koneksi {
    private static String url = "jdbc:mysql://localhost/ticket_concert",
                   usernameXampp = "root",
                   passwXampp = "";
    private static Connection con;
    
    public static void connect() {
        try {
            con = (Connection) DriverManager.getConnection(url, usernameXampp, 
             passwXampp);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static Connection getCon() {
        return con;
    }
}
