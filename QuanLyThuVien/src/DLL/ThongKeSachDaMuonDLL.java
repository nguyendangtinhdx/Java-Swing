/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.ThongKeSachDaMuonDAL;
import Entity.ThongKeSachDaMuon;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ThongKeSachDaMuonDLL {
    ThongKeSachDaMuonDAL dal = new ThongKeSachDaMuonDAL();
     public ArrayList<ThongKeSachDaMuon> getALL() {
        return dal.getALL();
    }
}
