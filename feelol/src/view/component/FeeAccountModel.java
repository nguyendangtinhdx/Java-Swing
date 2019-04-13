/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.component;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.dto.FeeAccount;

/**
 *
 * @author vtson
 */
public class FeeAccountModel extends AbstractTableModel {

    List<FeeAccount> data;
    String[] cols = {"Acount ID", "Role ID", "Username", "Password"};

    public FeeAccountModel(List<FeeAccount> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        if (data != null) {
            return data.size();
        } else {
            return 0;
        }
    }

    @Override
    public int getColumnCount() {
        return this.cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.data.get(rowIndex).getAccountId();
            case 1:
                return this.data.get(rowIndex).getRoleId();
            case 2:
                return this.data.get(rowIndex).getUsername();
            case 3:
                return this.data.get(rowIndex).getPassword();
            default:
                return null;
        }
    }

    public String getColumnName(int colIndex) {
        return cols[colIndex];
    }

    public void setData(ArrayList<FeeAccount> varList) {
        this.data = varList;
        fireTableDataChanged();
    }
}
