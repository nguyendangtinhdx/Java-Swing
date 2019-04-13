/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.MuonTra;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class MuonTraDAL extends DataAccessHelper{
    private final String GET_LOGIN = "SELECT * FROM Admin where username=? and password=? ";
    private final String GET_ALL = "SELECT * FROM MuonTra";
    private final String ADD_DATA = "INSERT INTO MuonTra(MaMuonTra,SoLuongMuon,SoLuongTra,NgayMuon,NgayTra,SoLanGiaHan,MaDG,MaSach)"
            + " VALUES (?,?,?,?,?,?,?,?)";
    private final String UPDATE_DATA = "UPDATE MuonTra SET SoLuongMuon=?, SoLuongTra=?,NgayMuon=?,NgayTra=?,SoLanGiaHan=?, MaDG=?,MaSach=? WHERE MaMuonTra=? " ;
    private final String REMOVE_DATA = "DELETE FROM MuonTra WHERE MaMuonTra = ? ";

    public boolean getLogin(String u, String p) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
            ps.setString(1, u);
            ps.setString(2, p);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }

    public ArrayList<MuonTra> getALL() {
        ArrayList<MuonTra> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    MuonTra item = new MuonTra();
                    item.setMaMuonTra(rs.getString("MaMuonTra"));
                    item.setSoLuongMuon(rs.getInt("SoLuongMuon"));
                    item.setSoLuongTra(rs.getInt("SoLuongTra"));
                    item.setNgayMuon(rs.getString("NgayMuon"));
                    item.setNgayTra(rs.getString("NgayTra"));
                    item.setSoLanGiaHan(rs.getInt("SoLanGiaHan"));
                    item.setMaDG(rs.getString("MaDG"));
                    item.setMaSach(rs.getString("MaSach"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public boolean AddData(MuonTra mt) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, mt.getMaMuonTra());
            ps.setInt(2, mt.getSoLuongMuon());
            ps.setInt(3, mt.getSoLuongTra());
            ps.setString(4, mt.getNgayMuon());
            ps.setString(5, mt.getNgayTra());
            ps.setInt(6, mt.getSoLanGiaHan());
            ps.setString(7, mt.getMaDG());
            ps.setString(8, mt.getMaSach());
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

    public boolean DeleteData(String u) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA);
            ps.setString(1, u);
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

    public boolean Update(MuonTra mt) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setInt(1, mt.getSoLuongMuon());
            ps.setInt(2, mt.getSoLuongTra());
            ps.setString(3, mt.getNgayMuon());
            ps.setString(4, mt.getNgayTra());
            ps.setInt(5, mt.getSoLanGiaHan());
            ps.setString(6, mt.getMaDG());
            ps.setString(7, mt.getMaSach());
            ps.setString(8, mt.getMaMuonTra());
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
