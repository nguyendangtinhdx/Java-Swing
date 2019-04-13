/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import model.dao.RoleDAO;
import model.dto.Function;
import model.dto.Product;
import model.dto.Role;
import view.AccountIFrm;
import view.FunctionIFrm;
import view.InvoiceIFrm;
import view.MainFrm;
import view.ProductIFrm;
import view.RoleIFrm;
import view.sell.SellProductIFrm;

/**
 *
 * @author vtson
 */
public class MenuBarFee extends JMenuBar implements ActionListener {

    JMenu mnSystem, mnBuz, mnWindow, mnHelp;
    JMenuItem mniExit, mniAccount, mniFunction, mniRole, mniSell, mniClose, mniCloseAll, mniHelp, mniAbount, mniProduct, mniProducer, mniInvoice, mniInvoicedetail;
    private int roleid;

    public MenuBarFee() {
        super();
        this.initMenubar();
    }

    public MenuBarFee(int roleid) {
        super();
        this.roleid = roleid;
        this.initMenubar(roleid);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.mniAccount)) {
            AccountIFrm f = new AccountIFrm();
            f.setTitle("Account management");
            createView(f);
        } else if (e.getSource().equals(this.mniExit)) {
            JOptionPane.showMessageDialog(this, "Thank for using app!");
            System.exit(0);
        } else if (e.getSource().equals(this.mniRole)) {
            RoleIFrm f = new RoleIFrm();
            f.setTitle("Role management");
            createView(f);
        } else if (e.getSource().equals(this.mniProduct)) {
            ProductIFrm p = new ProductIFrm();
            p.setTitle("Product management");
            createView(p);
        } else if (e.getSource().equals(this.mniFunction)) {
            FunctionIFrm f = new FunctionIFrm();
            f.setTitle("Function Management");
            createView(f);
        } else if (e.getSource().equals(this.mniSell)) {
            if (this.roleid == 2) {
                SellProductIFrm f = new SellProductIFrm();
                f.setTitle("Sell");
                createView(f);
            }else {
                
            }
        }
    }

    private void initMenubar(int r) {
        List<Function> dsChucnang = new RoleDAO().readAllFunction(r);
        boolean fA = false;
        boolean fR = false;
        boolean fF = false;
        boolean fS = false;
        boolean fP = false;
        boolean fI = false;
        boolean fID = false;
        mnSystem = new JMenu("System");
        mnBuz = new JMenu("Bussiness");
        for (Function f : dsChucnang) {
            if (f.getFuntionName().equals("AccountManager")) {
                fA = true;
            }
            if (f.getFuntionName().equals("RoleManager")) {
                fR = true;
            }
            if (f.getFuntionName().equals("FunctionManager")) {
                fF = true;
            }
            if (f.getFuntionName().equals("Sell")) {
                fS = true;
            }
            if (f.getFuntionName().equals("Product")) {
                fP = true;
            }
            if (f.getFuntionName().equals("Invoice")) {
                fI = true;
            }
            if (f.getFuntionName().equals("Invoicedetail")) {
                fID = true;
            }

        }
        mnSystem = new JMenu("System");
        if (fA) {
            mniAccount = new JMenuItem("Manager account");
            mniAccount.addActionListener(this);
            mnSystem.add(mniAccount);
        }
        if (fR) {
            mniRole = new JMenuItem("Manager Role");
            mniRole.addActionListener(this);
            mnSystem.add(mniRole);
        }
        if (fF) {
            mniFunction = new JMenuItem("Manager Function");
            mniFunction.addActionListener(this);
            mnSystem.add(mniFunction);
        }
        if (fS) {
            mniSell = new JMenuItem("Manager Sell");
            mniSell.addActionListener(this);
            mnBuz.add(mniSell);
        }
        if (fP) {
            mniProduct = new JMenuItem("Manager Product");
            mniProduct.addActionListener(this);
            mnBuz.add(mniProduct);
        }
        if (fI) {
            mniInvoice = new JMenuItem("Manager Invoice");
            mniInvoice.addActionListener(this);
            mnBuz.add(mniInvoice);
        }
        mniExit = new JMenuItem("Exit");
        mniExit.addActionListener(this);
        mnSystem.add(mniExit);

        mnHelp = new JMenu("Help");
        mniHelp = new JMenuItem("Help");
        mnHelp.add(mniHelp);

        mniAbount = new JMenuItem("About");
        mnHelp.add(mniAbount);

        this.add(mnSystem);
        this.add(mnBuz);
        this.add(mnHelp);
    }

    private void createView(JInternalFrame f) {
        JInternalFrame[] list = MainFrm.dt.getAllFrames();
        boolean flag = false;
        for (JInternalFrame i : list) {
            if (i.getTitle().equals(f.getTitle())) {
                flag = true;
                break;
            }
        }
        if (flag) {
            f.setVisible(true);
        } else {
            MainFrm.dt.add(f);
            f.setVisible(true);
        }
    }

    private void initMenubar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
