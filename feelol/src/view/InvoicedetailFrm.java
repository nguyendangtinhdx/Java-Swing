/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InvoicedetailAction;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import model.dto.Invoicedetail;
import model.dto.Product;

/**
 *
 * @author USER
 */
public class InvoicedetailFrm extends javax.swing.JInternalFrame {

    InvoicedetailAction actions;

    /**
     * Creates new form InvoicedetailFrm
     */
    public InvoicedetailFrm() {
        actions = new InvoicedetailAction();
        initComponents();
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

        invoicedetailId = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoicedetail = new javax.swing.JTable();
        productsId = new javax.swing.JLabel();
        invoiceId = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        btnlammoi = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnxoa = new javax.swing.JButton();
        txtinvoicedetail = new javax.swing.JTextField();
        txtproductsid = new javax.swing.JTextField();
        txtinvoiceid = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();

        setClosable(true);

        invoicedetailId.setText("Invoicedetail ID:");

        tblInvoicedetail.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInvoicedetail.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInvoicedetailMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInvoicedetail);

        productsId.setText("Products ID:");

        invoiceId.setText("Invoice ID:");

        quantity.setText("Quantity:");

        btnlammoi.setText("Làm Mới");
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        txtinvoicedetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinvoicedetailActionPerformed(evt);
            }
        });

        txtproductsid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductsidActionPerformed(evt);
            }
        });

        txtinvoiceid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtinvoiceidActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlammoi)
                    .addComponent(invoicedetailId)
                    .addComponent(productsId)
                    .addComponent(invoiceId)
                    .addComponent(quantity))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtinvoiceid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtproductsid, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtinvoicedetail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnthem)
                        .addGap(18, 18, 18)
                        .addComponent(btnsua))
                    .addComponent(txtquantity))
                .addGap(18, 18, 18)
                .addComponent(btnxoa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(invoicedetailId)
                    .addComponent(txtinvoicedetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productsId)
                    .addComponent(txtproductsid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(invoiceId)
                    .addComponent(txtinvoiceid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantity)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnlammoi)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnxoa))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblInvoicedetailMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInvoicedetailMouseClicked
        int index = tblInvoicedetail.getSelectedRow();
        txtinvoicedetail.setText(tblInvoicedetail.getValueAt(0, index).toString());
        txtproductsid.setText(tblInvoicedetail.getValueAt(1, index).toString());
        txtinvoiceid.setText(tblInvoicedetail.getValueAt(2, index).toString());
        txtquantity.setText(tblInvoicedetail.getValueAt(3, index).toString());
    }//GEN-LAST:event_tblInvoicedetailMouseClicked

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        txtinvoicedetail.setText("");
        txtinvoiceid.setText("");
        txtproductsid.setText("");
        txtquantity.setText("");
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void txtinvoicedetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinvoicedetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtinvoicedetailActionPerformed

    private void txtproductsidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductsidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductsidActionPerformed

    private void txtinvoiceidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtinvoiceidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtinvoiceidActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        Invoicedetail a = new Invoicedetail();
        a.setInvoicedetailid(Integer.parseInt(txtinvoicedetail.getText()));
        a.setInvoiceid(Integer.parseInt(txtinvoiceid.getText()));
        a.setProductid(Integer.parseInt(txtproductsid.getText()));
        a.setQuantity(Integer.parseInt(txtquantity.getText()));
        if (actions.create(a) != null) {
            JOptionPane.showMessageDialog(this, "Tạo mới thành công!");
            loadTable(actions.readAll());
        } else {
            JOptionPane.showMessageDialog(this, "Tạo mới thất bại!!");
        }

    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        Invoicedetail a = new Invoicedetail();
        a.setInvoicedetailid(Integer.parseInt(txtinvoicedetail.getText()));
        a.setInvoiceid(Integer.parseInt(txtinvoiceid.getText()));
        a.setProductid(Integer.parseInt(txtproductsid.getText()));
        a.setQuantity(Integer.parseInt(txtquantity.getText()));
        if (actions.update(a)) {
            JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
            loadTable(actions.readAll());
        } else {
            JOptionPane.showMessageDialog(this, "cập nhật thất bại!!");
        }

    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int index = tblInvoicedetail.getSelectedRow();
        if(index == -1)
        {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng để xóa");
        }
        else
        {
            int a = Integer.parseInt(tblInvoicedetail.getValueAt(0, index).toString());
            if(actions.delete(a))
            {
                JOptionPane.showMessageDialog(this,"Xóa thành công");
                loadTable(actions.readAll());
            }
            else
                JOptionPane.showMessageDialog(this, "Xóa thất bại");
        }
    }//GEN-LAST:event_btnxoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel invoiceId;
    private javax.swing.JLabel invoicedetailId;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel productsId;
    private javax.swing.JLabel quantity;
    private javax.swing.JTable tblInvoicedetail;
    private javax.swing.JTextField txtinvoicedetail;
    private javax.swing.JTextField txtinvoiceid;
    private javax.swing.JTextField txtproductsid;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables

    private void loadTable(List<Invoicedetail> readAll) {
        Vector col = new Vector();
        col.add("InvoicedetailID");
        col.add("ProductsID");
        col.add("InvoiceID");
        col.add("Quantity");

        Vector rows = new Vector();
        for (Invoicedetail p : readAll) {
            Vector row = new Vector();
            row.add(p.getInvoicedetailid());
            row.add(p.getProductid());
            row.add(p.getInvoiceid());
            row.add(p.getQuantity());
            rows.add(row);

        }
    }

    private Object creat(Invoicedetail a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}