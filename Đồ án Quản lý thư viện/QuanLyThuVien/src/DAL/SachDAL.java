/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Sach;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class SachDAL extends DataAccessHelper{
    private final String GET_BY_ID = "SELECT * FROM Sach WHERE MaSach = ?";
    private final String GET_ALL = "SELECT * FROM Sach";
    private final String ADD_DATA = "INSERT INTO Sach(MaSach,TenSach,TheLoai,TenTG,NXB,ViTri,SoLuong) VALUES (?,?,?,?,?,?,?)";
    private final String UPDATE_DATA = "UPDATE Sach SET TenSach=?, TheLoai=?,TenTG=?,NXB=?,ViTri=?,SoLuong=?  WHERE MaSach=? ";
    private final String REMOVE_DATA = "DELETE FROM Sach WHERE MaSach = ? ";

    public ArrayList<Sach> getByMa(String ma) {
        ArrayList<Sach> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setString(1, ma);
            ResultSet rs = ps.executeQuery();
            if (rs != null && rs.next()) {
                Sach item = new Sach();
                item.setMaSach(rs.getString("MaSach"));
                item.setTenSach(rs.getString("TenSach"));
                objs.add(item);
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public ArrayList<Sach> getALL() {
        ArrayList<Sach> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Sach item = new Sach();
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

    public boolean AddData(Sach s) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1, s.getMaSach());
            ps.setString(2, s.getTenSach());
            ps.setString(3, s.getTheLoai());
            ps.setString(4, s.getTenTG());
            ps.setInt(5, s.getNXB());
            ps.setString(6, s.getViTri());
            ps.setInt(7, s.getSoLuong());
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

    public boolean Update(Sach s) {
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1, s.getTenSach());
            ps.setString(2, s.getTheLoai());
            ps.setString(3, s.getTenTG());
            ps.setInt(4, s.getNXB());
            ps.setString(5, s.getViTri());
            ps.setInt(6, s.getSoLuong());
            ps.setString(7, s.getMaSach());
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
