/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.FunctionAction;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dto.Function;


/**
 *
 * @author BVMT
 */
public class FunctionFrm extends javax.swing.JFrame {
    FunctionAction actions;
    /**
     * Creates new form FunctionFrm
     */
    public FunctionFrm() {
        initComponents();
        actions = new FunctionAction();
        setLocationRelativeTo(null);
        loadTable(actions.readAll());
    
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
        tblFuntion = new javax.swing.JTable();
        lblFuntionId = new javax.swing.JLabel();
        lblFunctionNAme = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        txtFunctionID = new javax.swing.JTextField();
        txtFunctionName = new javax.swing.JTextField();
        txtDescription = new javax.swing.JTextField();
        btnLamTuoi = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblFuntion.setModel(new javax.swing.table.DefaultTableModel(
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
        tblFuntion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFuntionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFuntion);

        lblFuntionId.setText("Function ID");

        lblFunctionNAme.setText("Function Name");

        lblDescription.setText("Description");

        btnLamTuoi.setText("Làm tươi");
        btnLamTuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamTuoiActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblDescription)
                                    .addComponent(lblFunctionNAme)
                                    .addComponent(lblFuntionId))
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFunctionID, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFunctionName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnLamTuoi)
                                .addGap(18, 18, 18)
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapNhat)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnXoa)))
                        .addGap(0, 57, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuntionId)
                    .addComponent(txtFunctionID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFunctionNAme)
                    .addComponent(txtFunctionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDescription)
                    .addComponent(txtDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamTuoi)
                    .addComponent(btnThem)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLamTuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamTuoiActionPerformed
        // TODO add your handling code here:
        txtFunctionName.setText("");
        txtFunctionID.setText("");
        txtDescription.setText("");
    }//GEN-LAST:event_btnLamTuoiActionPerformed

    private void tblFuntionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFuntionMouseClicked
        // TODO add your handling code here:
        int indexSelected = tblFuntion.getSelectedRow();
        txtFunctionID.setText(tblFuntion.getValueAt(indexSelected,0).toString());
        txtFunctionName.setText(tblFuntion.getValueAt(indexSelected, 1).toString());
        txtDescription.setText(tblFuntion.getValueAt(indexSelected, 2).toString());
    }//GEN-LAST:event_tblFuntionMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        Function func = new Function();
        func.setFuntionId(Integer.parseInt(txtFunctionID.getText()));
        func.setFuntionName(txtFunctionName.getText());
        func.setDescription(txtDescription.getText());
        if(actions.create(func)==null){
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        }else {
        JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable(actions.readAll());
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int indexSelected = tblFuntion.getSelectedRow();
        if(indexSelected==-1){
        JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng để xóa");
        }else{
            String fun = tblFuntion.getValueAt(indexSelected, 0).toString();
            if(actions.delete(Integer.parseInt(fun))){
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadTable(actions.readAll());
            }else JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        Function fun = new Function();
        fun.setFuntionId(Integer.parseInt(txtFunctionID.getText()));
        fun.setFuntionName(txtFunctionName.getText());
        fun.setDescription(txtDescription.getText());
        if(actions.update(fun)){
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadTable(actions.readAll());        
        }else JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
    }//GEN-LAST:event_btnCapNhatActionPerformed

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
            java.util.logging.Logger.getLogger(FunctionFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FunctionFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FunctionFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FunctionFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FunctionFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamTuoi;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblFunctionNAme;
    private javax.swing.JLabel lblFuntionId;
    private javax.swing.JTable tblFuntion;
    private javax.swing.JTextField txtDescription;
    private javax.swing.JTextField txtFunctionID;
    private javax.swing.JTextField txtFunctionName;
    // End of variables declaration//GEN-END:variables

    private void loadTable(List<Function> list) {
        Vector col = new Vector();
        col.add("FunctionID");
        col.add("Funtion Name");
        col.add("Description");
        Vector rows = new Vector();
        for(Function fun: list){
            Vector row = new Vector();
            row.add(fun.getFuntionId());
            row.add(fun.getFuntionName());
            row.add(fun.getDescription());
            rows.add(row);       
        }
        tblFuntion.setModel(new DefaultTableModel(rows, col));
        tblFuntion.updateUI();
        jScrollPane1.setViewportView(this.tblFuntion);
    }
}
