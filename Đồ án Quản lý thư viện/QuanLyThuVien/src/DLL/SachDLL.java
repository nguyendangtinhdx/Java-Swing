/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.SachDAL;
import Entity.Sach;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class SachDLL {
    SachDAL dal = new SachDAL();

    public ArrayList<Sach> getByMa(String ma) {
        return dal.getByMa(ma);
    }

    public ArrayList<Sach> getALL() {
        return dal.getALL();
    }

    public boolean AddData(Sach s) {
        return dal.AddData(s);
    }

    public boolean delete(String u) {
        return dal.DeleteData(u);
    }

    public boolean update(Sach s) {
        return dal.Update(s);
    }
}
