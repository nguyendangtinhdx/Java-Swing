/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FeeAccountAction;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dto.FeeAccount;

/**
 *
 * @author BVMT
 */
public class FeeAccountFrm extends javax.swing.JFrame {

    FeeAccountAction actions;

    /**
     * Creates new form FeeAccountFrm
     */
    public FeeAccountFrm() {
        initComponents();
        setLocationRelativeTo(null);
        actions = new FeeAccountAction();
        loadTable(actions.readAll());
    }

    private void loadTable(List<FeeAccount> list) {
        Vector col = new Vector();
        col.add("Acount ID");
        col.add("Role ID");
        col.add("Username");
        col.add("Password");
        Vector rows = new Vector();
        for(FeeAccount fee: list)
        {
        Vector row = new Vector();
        row.add(fee.getAccountId());
        row.add(fee.getRoleId());
        row.add(fee.getUsername());
        row.add(fee.getPassword());
        rows.add(row);
        }
        tblFeeAccount.setModel(new DefaultTableModel(rows, col));
        tblFeeAccount.updateUI();
        jScrollPane1.setViewportView(this.tblFeeAccount);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblFeeAccount = new javax.swing.JTable();
        lblAccountID = new javax.swing.JLabel();
        lblRoleID = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        btnLamtuoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        txtAccountID = new javax.swing.JTextField();
        txtRoleID = new javax.swing.JTextField();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblFeeAccount.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFeeAccount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFeeAccountMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFeeAccount);

        lblAccountID.setText("Account ID");

        lblRoleID.setText("Role ID");

        lblUsername.setText("Username");

        lblPassword.setText("Password");

        btnLamtuoi.setText("Làm tươi");
        btnLamtuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamtuoiActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLamtuoi)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPassword)
                                    .addComponent(lblUsername)
                                    .addComponent(lblRoleID)
                                    .addComponent(lblAccountID))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(28, 28, 28)
                                .addComponent(btnXoa))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                                .addComponent(txtUsername, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtRoleID, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAccountID, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAccountID)
                    .addComponent(txtAccountID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoleID)
                    .addComponent(txtRoleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamtuoi)
                    .addComponent(btnThem)
                    .addComponent(btnSua)
                    .addComponent(btnXoa))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblFeeAccountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFeeAccountMouseClicked
        // TODO add your handling code here:
        int indexSelected = tblFeeAccount.getSelectedRow();
        txtAccountID.setText(tblFeeAccount.getValueAt(indexSelected, 0).toString());
        txtRoleID.setText(tblFeeAccount.getValueAt(indexSelected, 1).toString());
        txtUsername.setText(tblFeeAccount.getValueAt(indexSelected, 2).toString());
        txtPassword.setText(tblFeeAccount.getValueAt(indexSelected, 3).toString());
    }//GEN-LAST:event_tblFeeAccountMouseClicked

    private void btnLamtuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamtuoiActionPerformed
        // TODO add your handling code here:
        txtRoleID.setText("");
        txtAccountID.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
    }//GEN-LAST:event_btnLamtuoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        FeeAccount fee = new FeeAccount();
        fee.setAccountId(Integer.parseInt(txtAccountID.getText()));
        fee.setRoleId(Integer.parseInt(txtRoleID.getText()));
        fee.setUsername(txtUsername.getText());
        fee.setPassword(txtPassword.getText());
        if(actions.create(fee)==null){
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }else {
        JOptionPane.showMessageDialog( this, "Thêm thành công");
            loadTable(actions.readAll());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int indexSelected = tblFeeAccount.getSelectedRow();
        if(indexSelected==-1){
        JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng để xóa");
        }else{
        
            if(actions.delete(txtAccountID.getText())){
            JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadTable(actions.readAll());
            }else JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        FeeAccount fee = new FeeAccount();
        fee.setAccountId(Integer.parseInt(txtAccountID.getText()));
        fee.setRoleId(Integer.parseInt(txtRoleID.getText()));
        fee.setUsername(txtUsername.getText());
        fee.setPassword(txtPassword.getText());
        actions.update(fee);
        loadTable(actions.readAll());
    }//GEN-LAST:event_btnSuaActionPerformed

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
            java.util.logging.Logger.getLogger(FeeAccountFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FeeAccountFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FeeAccountFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FeeAccountFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FeeAccountFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamtuoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAccountID;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRoleID;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JTable tblFeeAccount;
    private javax.swing.JTextField txtAccountID;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtRoleID;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
