package ticketconcert;

import java.awt.Color;
import java.awt.Cursor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class CheckIn extends javax.swing.JFrame {
    Koneksi k = new Koneksi();
    
    private PreparedStatement stat;
    private ResultSet rs;
    
    public CheckIn() {
        initComponents();
        k.connect();
        
        submitBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        passcodeField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        walletLabel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        walletLabel.setForeground(new java.awt.Color(0, 102, 153));
        walletLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        walletLabel.setText("CHECK IN");

        topUpLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        topUpLabel.setForeground(new java.awt.Color(0, 102, 153));
        topUpLabel.setText("Passcode:");

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(walletLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(submitBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(topUpLabel)
                    .addComponent(passcodeField))
                .addGap(0, 52, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(walletLabel)
                .addGap(40, 40, 40)
                .addComponent(topUpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passcodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        String getPasscode = passcodeField.getText(), ticketPasscode = "";
        
        try {
            this.stat = k.getCon().prepareStatement("SELECT passcode FROM "
                        + "transaction;");
            this.rs = this.stat.executeQuery();
            
            while(rs.next()) {
                ticketPasscode = rs.getString("passcode");
            }
            
            if(!getPasscode.equals("")) {
                try {
                    this.stat = k.getCon().prepareStatement("UPDATE transaction SET stat='"
                                + "In' WHERE passcode='" + getPasscode + "';");
                    stat.executeUpdate();
                    
                    this.setVisible(false);
                } catch (Exception e) {
                    System.out.println(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Wrong passcode.");
            }
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField passcodeField;
    private javax.swing.JButton submitBtn;
    private javax.swing.ButtonGroup ticketClasses;
    private javax.swing.JLabel topUpLabel;
    private javax.swing.JLabel walletLabel;
    // End of variables declaration//GEN-END:variables
}
