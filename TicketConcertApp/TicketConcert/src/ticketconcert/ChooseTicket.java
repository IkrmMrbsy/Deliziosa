package ticketconcert;

import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

public class ChooseTicket extends javax.swing.JFrame {
    Koneksi k = new Koneksi();
    
    private PreparedStatement stat;
    private ResultSet rs;
    
    public static String total;
    private String selectedClass;
    
    public ChooseTicket() {
        initComponents();
        k.connect();
        payBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        schedLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        checkTicketLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        balanceLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        profileName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
    }

    public void setNickname(String nickname) {
        profileName.setText(nickname);
    }
    
    public void setBalance(int balance) {
        balanceLink.setText("Balance (rupiah): " + Integer.toString(balance));
    }
    
    public void setSelectedClass(String selectedClass) {
        this.selectedClass = selectedClass;
    }
    
    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ticketClasses = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        regLabel = new javax.swing.JLabel();
        chooseClassLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        payBtn = new javax.swing.JButton();
        vvip = new javax.swing.JRadioButton();
        vip = new javax.swing.JRadioButton();
        reg = new javax.swing.JRadioButton();
        checkTicketLink = new javax.swing.JLabel();
        schedLink = new javax.swing.JLabel();
        profileName = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        balanceLink = new javax.swing.JLabel();
        price = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        regLabel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        regLabel.setForeground(new java.awt.Color(0, 102, 153));
        regLabel.setText("BUY TICKET");

        chooseClassLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chooseClassLabel.setForeground(new java.awt.Color(0, 102, 153));
        chooseClassLabel.setText("Choose the class:");

        priceLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(0, 102, 153));
        priceLabel.setText("Price:");

        payBtn.setBackground(new java.awt.Color(0, 102, 153));
        payBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        payBtn.setForeground(new java.awt.Color(255, 255, 255));
        payBtn.setText("Pay");
        payBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                payBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                payBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                payBtnMouseExited(evt);
            }
        });

        vvip.setBackground(new java.awt.Color(255, 255, 255));
        ticketClasses.add(vvip);
        vvip.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        vvip.setForeground(new java.awt.Color(0, 102, 153));
        vvip.setText("VVIP");
        vvip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vvipMouseClicked(evt);
            }
        });

        vip.setBackground(new java.awt.Color(255, 255, 255));
        ticketClasses.add(vip);
        vip.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        vip.setForeground(new java.awt.Color(0, 102, 153));
        vip.setText("VIP");
        vip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                vipMouseClicked(evt);
            }
        });
        vip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vipActionPerformed(evt);
            }
        });

        reg.setBackground(new java.awt.Color(255, 255, 255));
        ticketClasses.add(reg);
        reg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        reg.setForeground(new java.awt.Color(0, 102, 153));
        reg.setText("Reguler");
        reg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                regMouseClicked(evt);
            }
        });
        reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regActionPerformed(evt);
            }
        });

        checkTicketLink.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        checkTicketLink.setForeground(new java.awt.Color(0, 102, 153));
        checkTicketLink.setText("<< Check ticket");
        checkTicketLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkTicketLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                checkTicketLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                checkTicketLinkMouseExited(evt);
            }
        });

        schedLink.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        schedLink.setForeground(new java.awt.Color(0, 102, 153));
        schedLink.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schedLink.setText("View schedule");
        schedLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                schedLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                schedLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                schedLinkMouseExited(evt);
            }
        });

        profileName.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        profileName.setForeground(new java.awt.Color(0, 102, 153));
        profileName.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        profileName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profileNameMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profileNameMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profileNameMouseExited(evt);
            }
        });

        line.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        line.setForeground(new java.awt.Color(0, 102, 153));
        line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line.setText("|");

        balanceLink.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        balanceLink.setForeground(new java.awt.Color(0, 102, 153));
        balanceLink.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        balanceLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                balanceLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                balanceLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                balanceLinkMouseExited(evt);
            }
        });

        price.setEditable(false);
        price.setBackground(new java.awt.Color(255, 255, 255));
        price.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(84, Short.MAX_VALUE)
                .addComponent(regLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(checkTicketLink, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceLink, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(profileName, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(payBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(vvip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vip)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reg))
                    .addComponent(chooseClassLabel)
                    .addComponent(priceLabel)
                    .addComponent(schedLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(price))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(checkTicketLink)
                    .addComponent(profileName)
                    .addComponent(line)
                    .addComponent(balanceLink))
                .addGap(34, 34, 34)
                .addComponent(regLabel)
                .addGap(40, 40, 40)
                .addComponent(chooseClassLabel)
                .addGap(9, 9, 9)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vvip)
                    .addComponent(vip)
                    .addComponent(reg))
                .addGap(18, 18, 18)
                .addComponent(priceLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(payBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(schedLink)
                .addContainerGap(396, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 410, 740);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vipActionPerformed

    private void regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regActionPerformed

    private void vvipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vvipMouseClicked
        // TODO add your handling code here:
        price.setText("300000");
        setSelectedClass(vvip.getText());
    }//GEN-LAST:event_vvipMouseClicked

    private void vipMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_vipMouseClicked
        // TODO add your handling code here:
        price.setText("225000");
        setSelectedClass(vip.getText());
    }//GEN-LAST:event_vipMouseClicked

    private void regMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_regMouseClicked
        // TODO add your handling code here:
        price.setText("150000");
        setSelectedClass(reg.getText());
    }//GEN-LAST:event_regMouseClicked

    private void payBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payBtnMouseClicked
        // TODO add your handling code here:
        String getBalance[] = balanceLink.getText().split(" ");
        int convertedBalance = Integer.parseInt(getBalance[2]),
            convertedPrice = Integer.parseInt(price.getText());
        
        if(convertedPrice > convertedBalance) {
            JOptionPane.showMessageDialog(null, "Insufficient "
                    + "wallet");
        } else {
            try {
                int newBalance =  convertedBalance - convertedPrice;
            
                this.stat = k.getCon().prepareStatement("UPDATE wallet SET balance='"
                            +  newBalance + "' WHERE numbers_phone='" 
                            + UpdateProfile.phoneNumbers + "';");
                stat.executeUpdate();
            
                setBalance(newBalance);
                
                this.stat = k.getCon().prepareStatement("INSERT INTO transaction "
                            + "(numbers_phone, class, passcode, stat) "
                            + "VALUES(?,?,?,?);");
                
                stat.setString(1, UpdateProfile.phoneNumbers);
                stat.setString(2, selectedClass);
                stat.setString(3, getSaltString());
                stat.setString(4, "Out");
                
                stat.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_payBtnMouseClicked

    private void payBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payBtnMouseEntered
        // TODO add your handling code here:
        payBtn.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_payBtnMouseEntered

    private void payBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_payBtnMouseExited
        // TODO add your handling code here:
        payBtn.setBackground(new Color(0, 76, 114));
    }//GEN-LAST:event_payBtnMouseExited

    private void schedLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedLinkMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Star: Tulus\n"
                + "Date: 20 May, 2023 \nTime: 16.00-18.00 \n"
                + "Place: Lap. Pussenif, Bandung");
    }//GEN-LAST:event_schedLinkMouseClicked

    private void schedLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedLinkMouseEntered
        // TODO add your handling code here:
        schedLink.setForeground(new Color(105, 105, 105));
    }//GEN-LAST:event_schedLinkMouseEntered

    private void schedLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedLinkMouseExited
        // TODO add your handling code here:
        schedLink.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_schedLinkMouseExited

    private void checkTicketLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkTicketLinkMouseClicked
        // TODO add your handling code here:
        String getBalance[] = balanceLink.getText().split(" ");
        
        Ticket ticket = new Ticket();
        
        Ticket.nickname = profileName.getText();
        Ticket.balance = getBalance[2];
        ticket.setVisible(true);
        ticket.setLocationRelativeTo(null);
        
        this.setVisible(false);
    }//GEN-LAST:event_checkTicketLinkMouseClicked

    private void checkTicketLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkTicketLinkMouseEntered
        // TODO add your handling code here:
        checkTicketLink.setForeground(new Color(105, 105, 105));
    }//GEN-LAST:event_checkTicketLinkMouseEntered

    private void checkTicketLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkTicketLinkMouseExited
        // TODO add your handling code here:
        checkTicketLink.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_checkTicketLinkMouseExited

    private void balanceLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balanceLinkMouseClicked
        // TODO add your handling code here:
        Wallet wallet = new Wallet();

        wallet.setBalance(balanceLink.getText());
        wallet.nickname = profileName.getText();
        
        wallet.setVisible(true);
        wallet.setLocationRelativeTo(null);
        
        this.setVisible(false);
    }//GEN-LAST:event_balanceLinkMouseClicked

    private void balanceLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balanceLinkMouseEntered
        // TODO add your handling code here:
        balanceLink.setForeground(new Color(105, 105, 105));
    }//GEN-LAST:event_balanceLinkMouseEntered

    private void balanceLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_balanceLinkMouseExited
        // TODO add your handling code here:
        balanceLink.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_balanceLinkMouseExited

    private void profileNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileNameMouseClicked
        // TODO add your handling code here:
        UpdateProfile updateProfile = new UpdateProfile();
        
        updateProfile.setVisible(true);
        updateProfile.setLocationRelativeTo(null);
        
        this.setVisible(false);
    }//GEN-LAST:event_profileNameMouseClicked

    private void profileNameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileNameMouseEntered
        // TODO add your handling code here:
        profileName.setForeground(new Color(105, 105, 105));
    }//GEN-LAST:event_profileNameMouseEntered

    private void profileNameMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profileNameMouseExited
        // TODO add your handling code here:
        profileName.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_profileNameMouseExited

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChooseTicket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceLink;
    private javax.swing.JLabel checkTicketLink;
    private javax.swing.JLabel chooseClassLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel line;
    private javax.swing.JButton payBtn;
    private javax.swing.JTextField price;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel profileName;
    private javax.swing.JRadioButton reg;
    private javax.swing.JLabel regLabel;
    private javax.swing.JLabel schedLink;
    private javax.swing.ButtonGroup ticketClasses;
    private javax.swing.JRadioButton vip;
    private javax.swing.JRadioButton vvip;
    // End of variables declaration//GEN-END:variables
}
