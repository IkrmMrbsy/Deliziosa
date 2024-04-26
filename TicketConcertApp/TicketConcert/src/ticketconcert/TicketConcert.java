/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ticketconcert;

/**
 *
 * @author LENOVO
 */
public class TicketConcert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Koneksi k = new Koneksi();
        k.connect();
        
        LoginForm login = new LoginForm();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
    
}
