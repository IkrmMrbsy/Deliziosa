package ticketconcert;

import java.awt.Color;
import java.awt.Cursor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

public class TransactionHistory extends javax.swing.JFrame {
    Koneksi k = new Koneksi();
    private PreparedStatement stat;
    private ResultSet rs;
    private String phoneNumbers, ticketClasses, passcode, date, balance, status;
    private DefaultTableModel transactionModel, topupModel;

    public TransactionHistory() {
        initComponents();
        
        k.connect();
        
        transactionSearchBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        transactionSearch.setBackground(Color.white);
        
        refreshTransactTable("");
        refreshTopupTable("");
    }
    
    public void refreshTransactTable(String ticketPasscode) {
        transactionModel = new DefaultTableModel();
        transactionTable.setModel(transactionModel);
        
        transactionModel.addColumn("Phone Numbers");
        transactionModel.addColumn("Class");
        transactionModel.addColumn("Passcode");
        transactionModel.addColumn("Date");
        transactionModel.addColumn("Status");
        
        if(ticketPasscode.equals("")) {
            try {
                this.stat = k.getCon().prepareStatement("SELECT * FROM "
                            + "transaction;");
                this.rs = this.stat.executeQuery();
                while(rs.next()) {
                    Object[] data = {
                        phoneNumbers = rs.getString("numbers_phone"),
                        ticketClasses = rs.getString("class"),
                        passcode = rs.getString("passcode"),
                        date = rs.getString("date"),
                        status = rs.getString("stat")
                    };
                
                    transactionModel.addRow(data);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                this.stat = k.getCon().prepareStatement("SELECT * FROM "
                            + "transaction WHERE passcode='" + ticketPasscode + "';");
                this.rs = this.stat.executeQuery();
                while(rs.next()) {
                    Object[] data = {
                        phoneNumbers = rs.getString("numbers_phone"),
                        ticketClasses = rs.getString("class"),
                        passcode = rs.getString("passcode"),
                        date = rs.getString("date"),
                        status = rs.getString("stat")
                    };
                
                    transactionModel.addRow(data);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public void refreshTopupTable(String numbersPhone) {
        topupModel = new DefaultTableModel();
        topupHistoryTable.setModel(topupModel);
        
        topupModel.addColumn("Phone numbers");
        topupModel.addColumn("Balance");
        topupModel.addColumn("Date");
        
        if(numbersPhone.equals("")) {
            try {
                this.stat = k.getCon().prepareStatement("SELECT * FROM "
                            + "topup_history;");
                this.rs = this.stat.executeQuery();
                while(rs.next()) {
                    Object[] data = {
                        phoneNumbers = rs.getString("numbers_phone"),
                        balance = Integer.toString(rs.getInt("balance")),
                        date = rs.getString("date")
                    };
                
                    topupModel.addRow(data);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            try {
                this.stat = k.getCon().prepareStatement("SELECT * FROM "
                            + "topup_history WHERE numbers_phone='" 
                            + numbersPhone + "';");
                this.rs = this.stat.executeQuery();
                while(rs.next()) {
                    Object[] data = {
                        phoneNumbers = rs.getString("numbers_phone"),
                        balance = Integer.toString(rs.getInt("balance")),
                        date = rs.getString("date")
                    };
                
                    topupModel.addRow(data);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        ticketLabel = new javax.swing.JLabel();
        regLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        transactionTable = new javax.swing.JTable();
        transactionSearchBtn = new javax.swing.JButton();
        transactionLabel = new javax.swing.JLabel();
        topupHistoryLabel = new javax.swing.JLabel();
        topupSearchBtn = new javax.swing.JButton();
        topupSearch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        topupHistoryTable = new javax.swing.JTable();
        topupHistoryLabel1 = new javax.swing.JLabel();
        transactionSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        ticketLabel.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        ticketLabel.setForeground(new java.awt.Color(0, 102, 153));
        ticketLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ticketLabel.setText("TRANSACTION");

        regLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        regLabel1.setForeground(new java.awt.Color(0, 102, 153));
        regLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        transactionTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        transactionTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Phone Numbers", "Class", "Passcode", "Stat"
            }
        ));
        transactionTable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        transactionTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(transactionTable);

        transactionSearchBtn.setBackground(new java.awt.Color(0, 102, 153));
        transactionSearchBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        transactionSearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        transactionSearchBtn.setText("Search");
        transactionSearchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                transactionSearchBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                transactionSearchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                transactionSearchBtnMouseExited(evt);
            }
        });

        transactionLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        transactionLabel.setForeground(new java.awt.Color(0, 102, 153));
        transactionLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        transactionLabel.setText("Ticket transaction:");

        topupHistoryLabel.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        topupHistoryLabel.setForeground(new java.awt.Color(0, 102, 153));
        topupHistoryLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        topupHistoryLabel.setText("Topup history:");

        topupSearchBtn.setBackground(new java.awt.Color(0, 102, 153));
        topupSearchBtn.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        topupSearchBtn.setForeground(new java.awt.Color(255, 255, 255));
        topupSearchBtn.setText("Search");
        topupSearchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topupSearchBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                topupSearchBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                topupSearchBtnMouseExited(evt);
            }
        });

        topupSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        topupHistoryTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        topupHistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Phone Numbers", "Balance", "Date"
            }
        ));
        topupHistoryTable.setGridColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(topupHistoryTable);

        topupHistoryLabel1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        topupHistoryLabel1.setForeground(new java.awt.Color(0, 102, 153));
        topupHistoryLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        topupHistoryLabel1.setText("*Note: Input the phone numbers");

        transactionSearch.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap(498, Short.MAX_VALUE)
                        .addComponent(regLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                    .addComponent(transactionSearch)
                                    .addGap(18, 18, 18)
                                    .addComponent(transactionSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(transactionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ticketLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(topupHistoryLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(topupHistoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(topupSearch)
                            .addGap(18, 18, 18)
                            .addComponent(topupSearchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)))
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(regLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ticketLabel)
                .addGap(27, 27, 27)
                .addComponent(transactionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(transactionSearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(transactionSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19)
                .addComponent(topupHistoryLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(topupSearchBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(topupSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(topupHistoryLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 530, 600);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 530, 600);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void transactionSearchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionSearchBtnMouseClicked
        // TODO add your handling code here:
        refreshTransactTable(transactionSearch.getText());
    }//GEN-LAST:event_transactionSearchBtnMouseClicked

    private void transactionSearchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionSearchBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionSearchBtnMouseEntered

    private void transactionSearchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_transactionSearchBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionSearchBtnMouseExited

    private void topupSearchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topupSearchBtnMouseClicked
        // TODO add your handling code here:
        refreshTopupTable(topupSearch.getText());
    }//GEN-LAST:event_topupSearchBtnMouseClicked

    private void topupSearchBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topupSearchBtnMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_topupSearchBtnMouseEntered

    private void topupSearchBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topupSearchBtnMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_topupSearchBtnMouseExited

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionHistory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel regLabel1;
    private javax.swing.JLabel ticketLabel;
    private javax.swing.JLabel topupHistoryLabel;
    private javax.swing.JLabel topupHistoryLabel1;
    private javax.swing.JTable topupHistoryTable;
    private javax.swing.JTextField topupSearch;
    private javax.swing.JButton topupSearchBtn;
    private javax.swing.JLabel transactionLabel;
    private javax.swing.JTextField transactionSearch;
    private javax.swing.JButton transactionSearchBtn;
    private javax.swing.JTable transactionTable;
    // End of variables declaration//GEN-END:variables
}
