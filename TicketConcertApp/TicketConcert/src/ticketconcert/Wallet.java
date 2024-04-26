package ticketconcert;

import java.awt.Color;
import java.awt.Cursor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Wallet extends javax.swing.JFrame {
    Koneksi k = new Koneksi();
    
    private PreparedStatement stat;
    private ResultSet rs;
    
    public String nickname;
    private int topUpBalance = 0, convertedBalance = 0;
    
    public Wallet() {
        initComponents();
        k.connect();
        
        submitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        buyTicketLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        balanceLink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        topUpComboBox.setBackground(Color.white);
    }
    
    public void setBalance(String balance) {
            balanceLink.setText(balance);
    }
    
    public int getBalance() {
        String getBalance[] = balanceLink.getText().split(" ");
        convertedBalance = Integer.parseInt(getBalance[2]);
        
        topUpBalance = Integer.parseInt(topUpComboBox.getSelectedItem().
                       toString()) + convertedBalance;
        
        return topUpBalance;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ticketClasses = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        walletLabel = new javax.swing.JLabel();
        topUpLabel = new javax.swing.JLabel();
        submitBtn = new javax.swing.JButton();
        buyTicketLink = new javax.swing.JLabel();
        line = new javax.swing.JLabel();
        balanceLink = new javax.swing.JLabel();
        topUpComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        walletLabel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        walletLabel.setForeground(new java.awt.Color(0, 102, 153));
        walletLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        walletLabel.setText("WALLET");

        topUpLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        topUpLabel.setForeground(new java.awt.Color(0, 102, 153));
        topUpLabel.setText("Top up:");

        submitBtn.setBackground(new java.awt.Color(0, 102, 153));
        submitBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        submitBtn.setForeground(new java.awt.Color(255, 255, 255));
        submitBtn.setText("Submit");
        submitBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitBtnMouseExited(evt);
            }
        });

        buyTicketLink.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        buyTicketLink.setForeground(new java.awt.Color(0, 102, 153));
        buyTicketLink.setText("<< Buy ticket");
        buyTicketLink.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                buyTicketLinkMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                buyTicketLinkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                buyTicketLinkMouseExited(evt);
            }
        });

        line.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        line.setForeground(new java.awt.Color(0, 102, 153));
        line.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        line.setText("|");

        balanceLink.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        balanceLink.setForeground(new java.awt.Color(0, 102, 153));
        balanceLink.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        balanceLink.setText("Balance:");

        topUpComboBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        topUpComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "150000", "225000", "300000" }));
        topUpComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                topUpComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(buyTicketLink, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(line)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(balanceLink, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(walletLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(topUpLabel)
                    .addComponent(topUpComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buyTicketLink)
                    .addComponent(line)
                    .addComponent(balanceLink))
                .addGap(34, 34, 34)
                .addComponent(walletLabel)
                .addGap(40, 40, 40)
                .addComponent(topUpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topUpComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(submitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(483, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseClicked
        // TODO add your handling code here:
        try {
            this.stat = k.getCon().prepareStatement("UPDATE wallet SET balance='"
                        + getBalance() + "' WHERE numbers_phone='" 
                        + UpdateProfile.phoneNumbers + "';");
            stat.executeUpdate();
                
            setBalance("Balance (rupiah): " + Integer.toString(getBalance()));
            
            this.stat = k.getCon().prepareStatement("INSERT INTO topup_history"
                        + " (numbers_phone, balance) VALUE(?, ?);");
            
            stat.setString(1, UpdateProfile.phoneNumbers);
            stat.setInt(2, convertedBalance);
            stat.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_submitBtnMouseClicked

    private void submitBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseEntered
        // TODO add your handling code here:
        submitBtn.setBackground(new Color(0,102,153));
    }//GEN-LAST:event_submitBtnMouseEntered

    private void submitBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitBtnMouseExited
        // TODO add your handling code here:
        submitBtn.setBackground(new Color(0, 76, 114));
    }//GEN-LAST:event_submitBtnMouseExited

    private void buyTicketLinkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyTicketLinkMouseClicked
        // TODO add your handling code here:
        ChooseTicket choose = new ChooseTicket();
        
        String balance[] = balanceLink.getText().split(" ");
        
        choose.setNickname(nickname);
        choose.setBalance(Integer.parseInt(balance[2]));
        choose.setVisible(true);
        choose.setLocationRelativeTo(null);
        
        this.setVisible(false);
    }//GEN-LAST:event_buyTicketLinkMouseClicked

    private void buyTicketLinkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyTicketLinkMouseEntered
        // TODO add your handling code here:
        buyTicketLink.setForeground(new Color(105, 105, 105));
    }//GEN-LAST:event_buyTicketLinkMouseEntered

    private void buyTicketLinkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buyTicketLinkMouseExited
        // TODO add your handling code here:
        buyTicketLink.setForeground(new Color(0,102,153));
    }//GEN-LAST:event_buyTicketLinkMouseExited

    private void topUpComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_topUpComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_topUpComboBoxActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Wallet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel balanceLink;
    private javax.swing.JLabel buyTicketLink;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel line;
    private javax.swing.JButton submitBtn;
    private javax.swing.ButtonGroup ticketClasses;
    private javax.swing.JComboBox<String> topUpComboBox;
    private javax.swing.JLabel topUpLabel;
    private javax.swing.JLabel walletLabel;
    // End of variables declaration//GEN-END:variables
}
