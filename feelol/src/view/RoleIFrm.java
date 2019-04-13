/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RoleAction;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dto.Role;

/**
 *
 * @author BVMT
 */
public class RoleIFrm extends javax.swing.JInternalFrame {
    RoleAction actions;

    /**
     * Creates new form RoleIFrm
     */
    public RoleIFrm() {
        initComponents();
        actions= new RoleAction();
        loadTable(actions.readAll());
    }
     void loadTable(List<Role> list) {
        Vector col = new Vector();
        col.add("RoleID");
        col.add("Role Name");
        Vector rows = new Vector();
        for (Role rol : list) {
            Vector row = new Vector();
            row.add(rol.getRoleId());
            row.add(rol.getRoleName());
            rows.add(row);
        }
        tblRole.setModel(new DefaultTableModel(rows, col));
        tblRole.updateUI();
        jScrollPane1.setViewportView(this.tblRole);
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
        tblRole = new javax.swing.JTable();
        blbRoleid = new javax.swing.JLabel();
        txtRoleID = new javax.swing.JTextField();
        txtRoleName = new javax.swing.JTextField();
        lblRoleName = new javax.swing.JLabel();
        btnLamtuoi = new javax.swing.JButton();
        BtnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();

        setClosable(true);

        tblRole.setModel(new javax.swing.table.DefaultTableModel(
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
        tblRole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRoleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblRole);

        blbRoleid.setText("RoleId");

        lblRoleName.setText("Role Name");

        btnLamtuoi.setText("Làm tươi");
        btnLamtuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamtuoiActionPerformed(evt);
            }
        });

        BtnThem.setText("Thêm");
        BtnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setText("cập nhật");
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
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(blbRoleid)
                    .addComponent(lblRoleName))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtRoleID, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                    .addComponent(txtRoleName))
                .addContainerGap(77, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLamtuoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnThem)
                .addGap(18, 18, 18)
                .addComponent(btnCapNhat)
                .addGap(18, 18, 18)
                .addComponent(btnXoa)
                .addGap(41, 41, 41))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(blbRoleid)
                    .addComponent(txtRoleID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRoleName)
                    .addComponent(txtRoleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLamtuoi)
                    .addComponent(BtnThem)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoa))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblRoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRoleMouseClicked
        // TODO add your handling code here:
        int indexSelected = tblRole.getSelectedRow();
        txtRoleID.setText(tblRole.getValueAt(indexSelected, 0).toString());
        txtRoleName.setText(tblRole.getValueAt(indexSelected, 1).toString());
    }//GEN-LAST:event_tblRoleMouseClicked

    private void btnLamtuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamtuoiActionPerformed
        // TODO add your handling code here:
        txtRoleID.setText("");
        txtRoleName.setText("");
    }//GEN-LAST:event_btnLamtuoiActionPerformed

    private void BtnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnThemActionPerformed
        // TODO add your handling code here:
        Role rol = new Role();
        //        rol.setRoleId(Integer.parseInt(txtRoleID.getText()));
        rol.setRoleName(txtRoleName.getText());
        if (actions.create(rol) == null) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thành công");
            loadTable(actions.readAll());
        }
    }//GEN-LAST:event_BtnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        // TODO add your handling code here:
        Role r = new Role();
        r.setRoleId(Integer.parseInt(txtRoleID.getText()));
        r.setRoleName(txtRoleName.getText());
        if(actions.update(r)){
            JOptionPane.showMessageDialog(this, "Cập nhật thành công");
            loadTable(actions.readAll());}else{
            JOptionPane.showMessageDialog(this, "Cập nhật thất bại");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int indexSelected = tblRole.getSelectedRow();
        if (indexSelected == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng cần xóa");
        } else {
            String role = tblRole.getValueAt(indexSelected, 0).toString();
            if (actions.delete(Integer.parseInt(role))) {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadTable(actions.readAll());
            } else {
                JOptionPane.showMessageDialog(this, "xóa thất bại");
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnThem;
    private javax.swing.JLabel blbRoleid;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLamtuoi;
    private javax.swing.JButton btnXoa;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRoleName;
    private javax.swing.JTable tblRole;
    private javax.swing.JTextField txtRoleID;
    private javax.swing.JTextField txtRoleName;
    // End of variables declaration//GEN-END:variables
}
