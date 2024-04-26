package ticketconcert;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UpdateProfile extends javax.swing.JFrame {
    Koneksi k = new Koneksi();
    
    public static String phoneNumbers;
    
    private PreparedStatement stat;
    private ResultSet rs;
    
    public UpdateProfile() {
        initComponents();
        
        k.connect();
        
        delAccLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    
    class Users extends UpdateProfile {
        String fullname, nickname, password;
        
        public Users() {
            fullname = nameField.getText();
            nickname = nicknameField.getText();
            password = passwField.getText();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        updateProfileLabel = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        nameLabel = new javax.swing.JLabel();
        usrnameLabel = new javax.swing.JLabel();
        nicknameField = new javax.swing.JTextField();
        updateBtn = new javax.swing.JButton();
        delAccLink = new javax.swing.JLabel();
        appLogo = new javax.swing.JLabel();
        passwLabel = new javax.swing.JLabel();
        passwField = new javax.swing.JPasswordField();
        repeatPasswLabel = new javax.swing.JLabel();
        repeatPasswField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        updateProfileLabel.setFont(new java.awt.Font("Arial", 3, 24)); // NOI18N
        updateProfileLabel.setForeground(new java.awt.Color(0, 102, 153));
        updateProfileLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateProfileLabel.setText("YOUR PROFILE");

        nameField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        nameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(0, 102, 153));
        nameLabel.setText("Full name:");

        usrnameLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        usrnameLabel.setForeground(new java.awt.Color(0, 102, 153));
        usrnameLabel.setText("Nickname:");

        nicknameField.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nicknameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nicknameFieldActionPerformed(evt);
            }
        });

        updateBtn.setBackground(new java.awt.Color(0, 102, 153));
        updateBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                updateBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                updateBtnMouseExited(evt);
            }
        });
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        delAccLink.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        delAccLink.setForeground(new java.awt.Color(0, 102, 153));
        delAccLink.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delAccLink.setText("Delete account");
        delAccLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                delAccLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                delAccLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                delAccLinkMouseExited(evt);
            }
        });

        appLogo.setFont(new java.awt.Font("Arial", 0, 8)); // NOI18N
        appLogo.setForeground(new java.awt.Color(0, 102, 153));
        appLogo.setText("Ticket Concert App");

        passwLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        passwLabel.setForeground(new java.awt.Color(0, 102, 153));
        passwLabel.setText("Password:");

        repeatPasswLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        repeatPasswLabel.setForeground(new java.awt.Color(0, 102, 153));
        repeatPasswLabel.setText("Repeat password:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(appLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(passwField)
                                    .addComponent(repeatPasswField)
                                    .addComponent(updateBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(repeatPasswLabel)
                                    .addComponent(passwLabel))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(80, 80, 80)
                                    .addComponent(delAccLink)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nameField)
                                .addComponent(nicknameField)
                                .addComponent(nameLabel)
                                .addComponent(usrnameLabel)
                                .addComponent(updateProfileLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)))))
                .addGap(0, 111, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(appLogo)
                .addGap(47, 47, 47)
                .addComponent(updateProfileLabel)
                .addGap(40, 40, 40)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(usrnameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nicknameField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(passwLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(repeatPasswLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repeatPasswField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(delAccLink)
                .addContainerGap(261, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 410, 740);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void nicknameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nicknameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nicknameFieldActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        if(nameField.getText().equals("") || 
           nicknameField.getText().equals("") ||
           passwField.getText().equals("") ||
           repeatPasswField.getText().equals("")) {
            JOptionPane.showMessageDialog( null, "There's still empty field.");
        } else if(!repeatPasswField.getText().equals(passwField.getText())) {
            JOptionPane.showMessageDialog(null, "The password doesn't match each other.");
        } else if(nameField.getText().matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Wrong fullname format.");
        } else if(nicknameField.getText().contains(" ") ||
                  nicknameField.getText().matches(".*\\d.*")) {
            JOptionPane.showMessageDialog(null, "Wrong nickname format.");
        } else {
            Users usr = new Users();
            
            try {
                this.stat = k.getCon().prepareStatement("UPDATE users "
                        + "SET fullname='" + usr.fullname + "', nickname= '"
                        + usr.nickname + "', password='" + usr.password + 
                        "' WHERE phone_numbers='" + usr.phoneNumbers + "';");
                stat.executeUpdate();
                
                LoginForm login = new LoginForm();
                login.setVisible(true);
                login.setLocationRelativeTo(null);
                
                this.setVisible(false);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void delAccLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delAccLinkMouseClicked
        // TODO add your handling code here:
        Users usr = new Users();
            
        try {
            this.stat = k.getCon().prepareStatement("DELETE FROM users "
                        + " WHERE phone_numbers='" + usr.phoneNumbers + "';");
            stat.executeUpdate();
                
            LoginForm login = new LoginForm();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
                
            this.setVisible(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_delAccLinkMouseClicked

    private void delAccLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delAccLinkMouseEntered
        // TODO add your handling code here:
        delAccLink.setForeground(new Color(105, 105, 105));
    }//GEN-LAST:event_delAccLinkMouseEntered

    private void delAccLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_delAccLinkMouseExited
        // TODO add your handling code here:
        delAccLink.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_delAccLinkMouseExited

    private void updateBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseExited
        // TODO add your handling code here:
        updateBtn.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_updateBtnMouseExited

    private void updateBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBtnMouseEntered
        // TODO add your handling code here:
        updateBtn.setBackground(new Color(0, 76, 114));
    }//GEN-LAST:event_updateBtnMouseEntered

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appLogo;
    private javax.swing.JLabel delAccLink;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JPasswordField passwField;
    private javax.swing.JLabel passwLabel;
    private javax.swing.JPasswordField repeatPasswField;
    private javax.swing.JLabel repeatPasswLabel;
    private javax.swing.JButton updateBtn;
    private javax.swing.JLabel updateProfileLabel;
    private javax.swing.JLabel usrnameLabel;
    // End of variables declaration//GEN-END:variables
}
