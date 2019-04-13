/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.DocGia;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class DocGiaDAL extends DataAccessHelper{
    private final String GET_BY_ID = "SELECT * FROM DocGia WHERE MaDG = ?";
    private final String GET_ALL = "SELECT * FROM DocGia";
    private final String UPDATE_DATA = "UPDATE DocGia SET TenDG=?, Khoa=?, SDT=? WHERE MaDG=? " ;
     public ArrayList<DocGia> getByMa(String ma){
        ArrayList<DocGia> objs = new ArrayList<>();
        try {
            getConnect();
                PreparedStatement ps = con.prepareStatement(GET_BY_ID);
                ps.setString(1, ma);
                ResultSet rs = ps.executeQuery();
                if (rs !=null && rs.next()) {
                DocGia item = new DocGia();
                item.setMaDG(rs.getString("MaDG"));
                item.setTenDG(rs.getString("TenDG"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public ArrayList<DocGia> getALL(){
        ArrayList<DocGia> objs = new ArrayList<>();
        try {
            getConnect();
                PreparedStatement ps = con.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                if (rs!=null) {
                    while(rs.next()){
                        DocGia item = new DocGia();
                        item.setMaDG(rs.getString("MaDG"));
                        item.setTenDG(rs.getString("TenDG"));
                        item.setKhoa(rs.getString("Khoa"));
                        item.setSDT(rs.getString("SDT"));
                        objs.add(item);
                    }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
     public boolean Update(DocGia dg){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1,dg.getTenDG());
            ps.setString(2,dg.getKhoa());
            ps.setString(3,dg.getSDT());
            ps.setString(4,dg.getMaDG());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
