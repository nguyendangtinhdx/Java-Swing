/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InvoicesAction;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dto.Invoices;

/**
 *
 * @author USER
 */
public class InvoiceIFrm extends javax.swing.JInternalFrame {

    InvoicesAction actions;

    /**
     * Creates new form InvoiceIFrm
     */
    java.sql.Date convert(java.util.Date d) {
        return new java.sql.Date(d.getTime());
    }

    public InvoiceIFrm() {
        actions = new InvoicesAction();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tblInvoices = new javax.swing.JTable();
        btnxoa = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnthem = new javax.swing.JButton();
        btnlamtuoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtinvoiceid = new javax.swing.JTextField();
        txtproductid = new javax.swing.JTextField();
        txtdatesell = new javax.swing.JTextField();
        txtaccountid = new javax.swing.JTextField();

        setClosable(true);

        tblInvoices.setModel(new javax.swing.table.DefaultTableModel(
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
        tblInvoices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInvoicesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInvoices);

        btnxoa.setText("Xóa");
        btnxoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnxoaActionPerformed(evt);
            }
        });

        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnlamtuoi.setText("Làm mới");
        btnlamtuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlamtuoiActionPerformed(evt);
            }
        });

        jLabel1.setText("Invoices ID:");

        jLabel2.setText("Product ID:");

        jLabel3.setText("Account ID:");

        jLabel4.setText("Date Sell:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdatesell, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtproductid, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtinvoiceid, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtaccountid, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlamtuoi)
                        .addGap(32, 32, 32)
                        .addComponent(btnthem)
                        .addGap(35, 35, 35)
                        .addComponent(btnsua)))
                .addGap(30, 30, 30)
                .addComponent(btnxoa)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtinvoiceid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtproductid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtaccountid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtdatesell, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnxoa)
                    .addComponent(btnsua)
                    .addComponent(btnthem)
                    .addComponent(btnlamtuoi))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        Invoices a = new Invoices();
        a.setInvoiceid(Integer.parseInt(txtinvoiceid.getText()));
        a.setProductid(Integer.parseInt(txtproductid.getText()));
        a.setAccountid(Integer.parseInt(txtaccountid.getText()));
        DateFormat f = new SimpleDateFormat("dd-mm-yyyy");
        try {
            a.setDatesell(convert(f.parse(txtdatesell.getText())));
        } catch (ParseException ex) {
            Logger.getLogger(InvoiceIFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(actions.create(a)!=null){
            JOptionPane.showMessageDialog(this,"Tạo mới thành công!!");
            loadTable(actions.readAll());
        }
        else
            JOptionPane.showMessageDialog(this, "Tạo mới thất bại!!");
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnlamtuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlamtuoiActionPerformed
        txtinvoiceid.setText("");
        txtproductid.setText("");
        txtaccountid.setText("");
        txtdatesell.setText("");
    }//GEN-LAST:event_btnlamtuoiActionPerformed

    private void tblInvoicesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInvoicesMouseClicked
        int index = tblInvoices.getSelectedRow();
        txtinvoiceid.setText(tblInvoices.getValueAt(0, index).toString());
        txtproductid.setText(tblInvoices.getValueAt(1, index).toString());
        txtaccountid.setText(tblInvoices.getValueAt(2, index).toString());
        txtdatesell.setText(tblInvoices.getValueAt(3, index).toString());
    }//GEN-LAST:event_tblInvoicesMouseClicked

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
         Invoices a = new Invoices();
        a.setInvoiceid(Integer.parseInt(txtinvoiceid.getText()));
        a.setProductid(Integer.parseInt(txtproductid.getText()));
        a.setAccountid(Integer.parseInt(txtaccountid.getText()));
        DateFormat f = new SimpleDateFormat("dd-mm-yyyy");
        try {
            a.setDatesell(convert(f.parse(txtdatesell.getText())));
        } catch (ParseException ex) {
            Logger.getLogger(InvoiceIFrm.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(actions.update(a)){
            JOptionPane.showMessageDialog(this,"cập nhật thành công!!");
            loadTable(actions.readAll());
        }
        else
            JOptionPane.showMessageDialog(this, "cập nhật thất bại!!");
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnxoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnxoaActionPerformed
        int index = tblInvoices.getSelectedRow();
        if(index == -1 )
        {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng để xóa");
        }
        else
        {
            int invoiceid = Integer.parseInt(tblInvoices.getValueAt(0, index).toString());
            if(actions.delete(invoiceid))
            {
                JOptionPane.showMessageDialog(this, "Xóa thành công");
                loadTable(actions.readAll());
            }
            else
                JOptionPane.showMessageDialog(this,"Xóa thất bại");
        }
    }//GEN-LAST:event_btnxoaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnlamtuoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JButton btnxoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblInvoices;
    private javax.swing.JTextField txtaccountid;
    private javax.swing.JTextField txtdatesell;
    private javax.swing.JTextField txtinvoiceid;
    private javax.swing.JTextField txtproductid;
    // End of variables declaration//GEN-END:variables

    private void loadTable(List<Invoices> readAll) {
        Vector col = new Vector();
        col.add("InvoiceID");
        col.add("ProductID");
        col.add("AccountID");
        col.add("Datesell");
        Vector rows = new Vector();
        for (Invoices r : readAll) {
            Vector row = new Vector();
            row.add(r.getInvoiceid());
            row.add(r.getProductid());
            row.add(r.getAccountid());
            row.add(r.getDatesell());
            rows.add(row);
        }
        tblInvoices.setModel(new DefaultTableModel(rows, col));
        tblInvoices.updateUI();
        jScrollPane1.setViewportView(this.tblInvoices);
    }
}