/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ThongKeSachChuaDuocMuon;
import Entity.ThongKeSachDaMuon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ThongKeSachChuaDuocMuonDAL extends DataAccessHelper{
    private final String GET_ALL = "SELECT * FROM ThongKeSachChuaDuocMuon";
    public ArrayList<ThongKeSachChuaDuocMuon> getALL() {
        ArrayList<ThongKeSachChuaDuocMuon> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ThongKeSachChuaDuocMuon item = new ThongKeSachChuaDuocMuon();
                    item.setMaSach(rs.getString("MaSach"));
                    item.setTenSach(rs.getString("TenSach"));
                    item.setTheLoai(rs.getString("TheLoai"));
                    item.setTenTG(rs.getString("TenTG"));
                    item.setNXB(rs.getInt("NXB"));
                    item.setViTri(rs.getString("ViTri"));
                    item.setSoLuong(rs.getInt("SoLuong"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
}
