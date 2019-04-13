/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLL;

import DAL.DocGiaDAL;
import Entity.DocGia;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class DocGiaDLL {
    DocGiaDAL dal = new DocGiaDAL();
    public ArrayList<DocGia> getByMa(String ma){
        return dal.getByMa(ma);
    }
   public ArrayList<DocGia> getALL(){
       return dal.getALL();
   }
   public boolean update(DocGia dg){
       return dal.Update(dg);
   }
}
