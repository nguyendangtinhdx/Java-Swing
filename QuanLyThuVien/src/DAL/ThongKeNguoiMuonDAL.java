/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Sach;
import Entity.ThongKeNguoiMuon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ThongKeNguoiMuonDAL extends DataAccessHelper{
    private final String GET_ALL = "SELECT * FROM ThongKeNguoiMuon";
    public ArrayList<ThongKeNguoiMuon> getALL() {
        ArrayList<ThongKeNguoiMuon> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ThongKeNguoiMuon item = new ThongKeNguoiMuon();
                    item.setMaDG(rs.getString("MaDG"));
                    item.setTenDG(rs.getString("TenDG"));
                    item.setMaSach(rs.getString("MaSach"));
                    item.setTenSach(rs.getString("TenSach"));
                    item.setSoLuongMuon(rs.getInt("SoLuongMuon"));
                    item.setSoLuongTra(rs.getInt("SoLuongTra"));
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
