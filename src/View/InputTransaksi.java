/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Config.Conn;
import Models.Transaksi;
import Controller.ControllerTransaksi;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author dzakwandh
 */
public class InputTransaksi extends javax.swing.JFrame {
    private Object tabel;
    ResultSet rs;
    private Conn conn;
    private ControllerTransaksi tabelDataTransaksi ;
    /**
     * Creates new form Transaksi
     */
    public InputTransaksi() {
        initComponents();
        setTitle("Transaksi");
        conn = new Conn();
        tabelDataTransaksi = new ControllerTransaksi();
        tabelTransaksi.setModel(tabelDataTransaksi);
        tampilData();
        SetEditOff();
        getListJasa();
    }
    
    public void SetEditOn(){
        jComboBoxNamaJasa.setEnabled(true);
        tfOngkir.setEnabled(true);
        tfBerat.setEnabled(true);
        tfTotal.setEnabled(false);
        taDeskripsi.setEnabled(true);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(true);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnNew.setEnabled(true);
    }
    
    private void SetEditOff() {
        jComboBoxNamaJasa.setEnabled(false);
        tfOngkir.setEnabled(false);
        tfBerat.setEnabled(false);
        tfTotal.setEnabled(false);
        taDeskripsi.setEnabled(false);
        btnCancel.setEnabled(false);
        btnDelete.setEnabled(false);
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnNew.setEnabled(true);
    }
    
     private void tampilData() {
        try {
            int baris = tabelTransaksi.getRowCount();
            for (int i = 0; i < baris; i++) {
                tabelDataTransaksi.delete(0, baris);
            }
            String sql = "SELECT * FROM transaksi";
            ResultSet rs = conn.getData(sql);
            while (rs.next()) {
                Transaksi trans = new Transaksi();
                trans.setIdTransaksi(Integer.parseInt(rs.getString(1)));
                trans.setDeskripsiCucian(rs.getString(3));
                trans.setBeratCucian(Integer.parseInt(rs.getString(4)));
                trans.setOngkir(Integer.parseInt(rs.getString(5)));
                trans.setTotalBayar(Integer.parseInt(rs.getString(6)));
                trans.setTglTransaksi(rs.getString(7));
                tabelDataTransaksi.add(trans);
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }

    public void clearText() {
        tfBerat.setText("");
        tfOngkir.setText("");
        tfTotal.setText("");
        taDeskripsi.setText("");
    }
    
    private void getListJasa(){
        try {
            String SQL = "SELECT * FROM jasa";
            ResultSet res = conn.getData(SQL);
            while(res.next()){
                jComboBoxNamaJasa.addItem(res.getString(1));
            }
        } catch (SQLException ex) {
            System.err.print(ex);
        }
    }
    
    public void TampilText(){
        int row = 0;
        row = tabelTransaksi.getSelectedRow();
        Transaksi transaksi = tabelDataTransaksi.get(row);
        tfIDTransaksi.setText(String.valueOf(transaksi.getIdTransaksi()));
        tfBerat.setText(String.valueOf(transaksi.getBeratCucian()));
        tfOngkir.setText(String.valueOf(transaksi.getOngkir()));
        tfTotal.setText(String.valueOf(transaksi.getTotalBayar()));
        taDeskripsi.setText(String.valueOf(transaksi.getDeskripsiCucian()));
        btnSave.setEnabled(false);
        btnNew.setEnabled(false);
        SetEditOn();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        judulTransaksi = new javax.swing.JLabel();
        idJasaTransaksi = new javax.swing.JLabel();
        jComboBoxNamaJasa = new javax.swing.JComboBox<>();
        berat = new javax.swing.JLabel();
        tfBerat = new javax.swing.JTextField();
        ongkir = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        btnNew = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelTransaksi = new javax.swing.JTable();
        tfOngkir = new javax.swing.JTextField();
        tfTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDeskripsi = new javax.swing.JTextArea();
        ongkir1 = new javax.swing.JLabel();
        tfIDTransaksi = new javax.swing.JTextField();

        setSize(new java.awt.Dimension(506, 500));

        judulTransaksi.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        judulTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        judulTransaksi.setText("TRANSAKSI");

        idJasaTransaksi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        idJasaTransaksi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        idJasaTransaksi.setText("ID JASA");

        jComboBoxNamaJasa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        berat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        berat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        berat.setText("BERAT (KG)");

        ongkir.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ongkir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ongkir.setText("ONGKIR");

        total.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        total.setText("TOTAL:");

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        tabelTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelTransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelTransaksi);

        tfTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTotalActionPerformed(evt);
            }
        });

        taDeskripsi.setColumns(20);
        taDeskripsi.setRows(5);
        jScrollPane1.setViewportView(taDeskripsi);

        ongkir1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ongkir1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ongkir1.setText("DESKRIPSI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ongkir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(idJasaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(berat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxNamaJasa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tfBerat, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                    .addComponent(tfOngkir)
                                    .addComponent(tfIDTransaksi, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(total)
                                        .addGap(35, 35, 35)
                                        .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(ongkir1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnNew, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                        .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(judulTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(judulTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(tfIDTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(idJasaTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(berat, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ongkir, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBoxNamaJasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(tfOngkir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(total)
                            .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(ongkir1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSave)
                            .addComponent(btnNew)
                            .addComponent(btnUpdate))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDelete)
                            .addComponent(btnCancel))))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public int hitungTotal() throws SQLException {
        String Sberat = tfBerat.getText();
        String Songkir = tfOngkir.getText();
        String deskripsi = taDeskripsi.getText();
        
        String sql = "SELECT harga FROM jasa WHERE idJasa='" + jComboBoxNamaJasa.getSelectedItem() +"';";
        rs = conn.getData(sql);
        int Stotal = Integer.parseInt(Sberat) * Integer.parseInt(rs.getString(4)) + Integer.parseInt(Songkir);
        return Stotal;
    }
    
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String Sberat = tfBerat.getText();
        String Songkir = tfOngkir.getText();
        String deskripsi = taDeskripsi.getText();
        
        if ((Sberat.isEmpty()) | (Songkir.isEmpty()) | (deskripsi.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, " +
                "silahkan dilengkapi");
            tfBerat.requestFocus();
        }else {
            try {
                String Stotal = String.valueOf(hitungTotal());
                tfTotal.setText(Stotal);
        
                String sql = "INSERT INTO transaksi (idJasa, deskripsiTransaksi, "
                        + "berat, ongkir, totalBayar, tgl_transaksi) "
                        + "VALUES ("
                        + "'" + jComboBoxNamaJasa.getSelectedItem() + "',"
                        + "'" + deskripsi + "',"
                        + "'" + berat + "',"
                        + "'" + ongkir + "',"
                        + "'" + total + "',"
                        + "'" + LocalDate.now() + "'" + ")";
                conn.query(sql);
                tampilData();
                JOptionPane.showMessageDialog(null, deskripsi + " Berhasil Disimpan");
                clearText();
                SetEditOff();
                btnNew.setEnabled(true);
            }catch (HeadlessException | NumberFormatException | SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void tfTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTotalActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        // TODO add your handling code here:
        clearText();
        tfBerat.requestFocus();
        SetEditOn();
        btnSave.setEnabled(true);
        btnDelete.setEnabled(false);
        btnNew.setEnabled(false);
        btnCancel.setEnabled(true);
        btnUpdate.setEnabled(false);
    }//GEN-LAST:event_btnNewActionPerformed

    private void tabelTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelTransaksiMouseClicked
        if(evt.getClickCount()==1){
            TampilText();
        }
        tfTotal.setEnabled(false);
        tfIDTransaksi.setEnabled(false);
        btnCancel.setEnabled(true);
        btnNew.setEnabled(false);
    }//GEN-LAST:event_tabelTransaksiMouseClicked

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        clearText();
        SetEditOff();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        String berat = tfBerat.getText();
        String ongkir = tfOngkir.getText();
        String deskripsi = taDeskripsi.getText();
        String total = tfTotal.getText();
        if ((berat.isEmpty()) | (ongkir.isEmpty()) | (deskripsi.isEmpty()) 
                | (total.isEmpty())){
            JOptionPane.showMessageDialog(null, "data tidak boleh kosong, " +
                "silahkan dilengkapi");
            tfBerat.requestFocus();
        }else {
            try {
                String sql = "UPDATE transaksi SET "
                        + "idJasa = '" + jComboBoxNamaJasa.getSelectedItem() + "',"
                        + "deskripsiTransaksi = '" + deskripsi + "',"
                        + "berat = '" + berat + "',"
                        + "ongkir = '" + ongkir + "',"
                        + "totalBayar = '" + total + "',"
                        + "tgl_transaksi = '" + LocalDate.now() + "' WHERE "
                        + "idTransaksi = '" + tfIDTransaksi.getText() + "'";
                conn.query(sql);
                tampilData();
                JOptionPane.showMessageDialog(null, deskripsi + " Berhasil Diperbarui");
                clearText();
                SetEditOff();
                btnNew.setEnabled(true);
            }catch (Exception ex) {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String deskripsi = taDeskripsi.getText();
        int app;
        if ((app = JOptionPane.showConfirmDialog(null, "Anda yakin akan menghapus data "
                + deskripsi+ " ?", "Perhatian", JOptionPane.YES_NO_OPTION)) == 0){
            try {
                String sql = "DELETE FROM transaksi WHERE"
                + " idTransaksi = '" + tfIDTransaksi.getText()+ "'";
                conn.query(sql);
                tampilData();
                JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                clearText();
                SetEditOff();
                btnNew.setEnabled(true);
            }catch (Exception ex) {
                System.err.print(ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InputTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputTransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputTransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel berat;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel idJasaTransaksi;
    private javax.swing.JComboBox<String> jComboBoxNamaJasa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel judulTransaksi;
    private javax.swing.JLabel ongkir;
    private javax.swing.JLabel ongkir1;
    private javax.swing.JTextArea taDeskripsi;
    private javax.swing.JTable tabelTransaksi;
    private javax.swing.JTextField tfBerat;
    private javax.swing.JTextField tfIDTransaksi;
    private javax.swing.JTextField tfOngkir;
    private javax.swing.JTextField tfTotal;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
