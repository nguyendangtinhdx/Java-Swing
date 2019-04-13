/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ThongKeSachChuaDuocMuonDAL;
import Entity.ThongKeSachChuaDuocMuon;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ThongKeSachChuaDuocMuonDLL {
    ThongKeSachChuaDuocMuonDAL dal = new ThongKeSachChuaDuocMuonDAL();
     public ArrayList<ThongKeSachChuaDuocMuon> getALL() {
        return dal.getALL();
    }
}
