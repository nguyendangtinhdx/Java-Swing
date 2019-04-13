/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.ThongKeNguoiMuon;
import Entity.ThongKeNguoiMuonQuaHan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ThongKeNguoiMuonQuaHanDAL extends DataAccessHelper{
    private final String GET_ALL = "SELECT * FROM ThongKeNguoiMuonQuaHan";
    public ArrayList<ThongKeNguoiMuonQuaHan> getALL() {
        ArrayList<ThongKeNguoiMuonQuaHan> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    ThongKeNguoiMuonQuaHan item = new ThongKeNguoiMuonQuaHan();
                    item.setMaDG(rs.getString("MaDG"));
                    item.setTenDG(rs.getString("TenDG"));
                    item.setMaSach(rs.getString("MaSach"));
                    item.setTenSach(rs.getString("TenSach"));
                    item.setNgayMuon(rs.getString("NgayMuon"));
                    item.setNgayTra(rs.getString("NgayTra"));
                    item.setSoNgayQuaHan(rs.getInt("SoNgayQuaHan"));
                    item.setTienNopPhat(rs.getInt("TienNopPhat"));
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
