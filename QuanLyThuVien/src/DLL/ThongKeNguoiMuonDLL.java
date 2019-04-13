/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ThongKeNguoiMuonDAL;
import Entity.ThongKeNguoiMuon;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ThongKeNguoiMuonDLL {
    ThongKeNguoiMuonDAL dal = new ThongKeNguoiMuonDAL();
     public ArrayList<ThongKeNguoiMuon> getALL() {
        return dal.getALL();
    }
}
