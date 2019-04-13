/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ThongKeNguoiMuonQuaHanDAL;
import Entity.ThongKeNguoiMuonQuaHan;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ThongKeNguoiMuonQuaHanDLL {
    ThongKeNguoiMuonQuaHanDAL dal = new ThongKeNguoiMuonQuaHanDAL();
     public ArrayList<ThongKeNguoiMuonQuaHan> getALL() {
        return dal.getALL();
    }
    
}
