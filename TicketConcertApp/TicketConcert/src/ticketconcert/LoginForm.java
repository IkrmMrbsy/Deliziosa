package ticketconcert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;

public class LoginForm extends javax.swing.JFrame {
    Koneksi k = new Koneksi();
    private PreparedStatement stat;
    private ResultSet rs;
    
    public LoginForm() {
        initComponents();
        
        k.connect();
        
        regLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    class User {
    String nickname="", phoneNumbers, password;
    int balance;
        
        public User() {
            phoneNumbers = numbersField.getText();
            password = passwField.getText();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        loginLabel = new javax.swing.JLabel();
        numbersField = new javax.swing.JTextField();
        numbersLabel = new javax.swing.JLabel();
        passwLabel = new javax.swing.JLabel();
        loginBtn = new javax.swing.JButton();
        regLink = new javax.swing.JLabel();
        appLogo = new javax.swing.JLabel();
        passwField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        loginLabel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        loginLabel.setForeground(new java.awt.Color(0, 102, 153));
        loginLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loginLabel.setText("LOGIN");
        loginLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        numbersField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        numbersField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numbersFieldActionPerformed(evt);
            }
        });

        numbersLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        numbersLabel.setForeground(new java.awt.Color(0, 102, 153));
        numbersLabel.setText("Phone numbers:");

        passwLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        passwLabel.setForeground(new java.awt.Color(0, 102, 153));
        passwLabel.setText("Password:");

        loginBtn.setBackground(new java.awt.Color(0, 102, 153));
        loginBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginBtnMouseExited(evt);
            }
        });

        regLink.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        regLink.setForeground(new java.awt.Color(0, 102, 153));
        regLink.setText("Doesn't have any account?");
        regLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                regLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                regLinkMouseExited(evt);
            }
        });

        appLogo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        appLogo.setForeground(new java.awt.Color(0, 102, 153));
        appLogo.setText(" Ticket Concert App");

        passwField.setMinimumSize(new java.awt.Dimension(64, 20));
        passwField.setPreferredSize(new java.awt.Dimension(90, 20));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(numbersLabel)
                            .addComponent(numbersField, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(passwLabel)
                            .addComponent(loginBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(passwField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(loginLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appLogo)))
                .addGap(0, 52, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(regLink)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appLogo)
                .addGap(47, 47, 47)
                .addComponent(loginLabel)
                .addGap(40, 40, 40)
                .addComponent(numbersLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(numbersField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(regLink)
                .addContainerGap(273, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 410, 620);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numbersFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numbersFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_numbersFieldActionPerformed

    private void regLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regLinkMouseClicked
        // TODO add your handling code here:
        RegisterForm reg = new RegisterForm();
        reg.setVisible(true);
        reg.setLocationRelativeTo(null);
        
        this.setVisible(false);
    }//GEN-LAST:event_regLinkMouseClicked

    private void regLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regLinkMouseEntered
        // TODO add your handling code here:
        regLink.setForeground(new Color(105, 105, 105));
    }//GEN-LAST:event_regLinkMouseEntered

    private void regLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regLinkMouseExited
        // TODO add your handling code here:
        regLink.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_regLinkMouseExited

    private void loginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseClicked
        // TODO add your handling code here:
        User u = new User();
        
        try {
            this.stat = k.getCon().prepareStatement("SELECT * FROM users WHERE "
                        + "phone_numbers='" + u.phoneNumbers + "' AND password='" 
                        + u.password + "';");
            this.rs = this.stat.executeQuery();
            while(rs.next()) {
                u.nickname = rs.getString("nickname");
            }
            
            this.stat = k.getCon().prepareStatement("SELECT balance FROM wallet "
                    + "WHERE numbers_phone = '" + u.phoneNumbers + "';");
            this.rs = this.stat.executeQuery();
            while(rs.next()) {
                u.balance = rs.getInt("balance");
            }
            
            if(numbersField.getText().equals("") && 
                passwField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "There's still empty field.");
            } else if(numbersField.getText().equals("081573135056") &&
                      passwField.getText().equals("admin666")){
                TransactionHistory history = new TransactionHistory();
                
                history.setVisible(true);
                history.setLocationRelativeTo(null);
                
                this.setVisible(false);
            } else if(u.nickname.equals("")) {
                JOptionPane.showMessageDialog(null, "Wrong phone numbers or password.");
            } else  {
                ChooseTicket choose = new ChooseTicket();
                
                choose.setNickname(u.nickname);
                choose.setBalance(u.balance);
                UpdateProfile.phoneNumbers = u.phoneNumbers;
                choose.setVisible(true);
                choose.setLocationRelativeTo(null);
        
                this.setVisible(false);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_loginBtnMouseClicked

    private void loginBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseExited
        // TODO add your handling code here:
        loginBtn.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_loginBtnMouseExited

    private void loginBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginBtnMouseEntered
        // TODO add your handling code here:
        loginBtn.setBackground(new Color(0, 76, 114));
    }//GEN-LAST:event_loginBtnMouseEntered

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appLogo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton loginBtn;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField numbersField;
    private javax.swing.JLabel numbersLabel;
    private javax.swing.JPasswordField passwField;
    private javax.swing.JLabel passwLabel;
    private javax.swing.JLabel regLink;
    // End of variables declaration//GEN-END:variables
}
