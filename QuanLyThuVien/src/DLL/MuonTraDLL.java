/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.MuonTraDAL;
import Entity.MuonTra;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class MuonTraDLL {
    MuonTraDAL dal = new MuonTraDAL();

    public boolean getLogin(String u, String p) {
        return dal.getLogin(u, p);
    }

    public ArrayList<MuonTra> getALL() {
        return dal.getALL();
    }

    public boolean AddData(MuonTra mt) {
        return dal.AddData(mt);
    }

    public boolean delete(String u) {
        return dal.DeleteData(u);
    }

    public boolean update(MuonTra mt) {
        return dal.Update(mt);
    }
}
