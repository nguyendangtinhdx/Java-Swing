/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ThongKeNguoiMuonQuaHan {
    String MaDG,TenDG,MaSach,TenSach;
    String NgayMuon,NgayTra;
    int SoNgayQuaHan,TienNopPhat;

    public int getSoNgayQuaHan() {
        return SoNgayQuaHan;
    }

    public void setSoNgayQuaHan(int SoNgayQuaHan) {
        this.SoNgayQuaHan = SoNgayQuaHan;
    }

    public int getTienNopPhat() {
        return TienNopPhat;
    }

    public void setTienNopPhat(int TienNopPhat) {
        this.TienNopPhat = TienNopPhat;
    }
    

    public String getMaDG() {
        return MaDG;
    }

    public void setMaDG(String MaDG) {
        this.MaDG = MaDG;
    }

    public String getTenDG() {
        return TenDG;
    }

    public void setTenDG(String TenDG) {
        this.TenDG = TenDG;
    }

    public String getMaSach() {
        return MaSach;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public String getNgayMuon() {
        return NgayMuon;
    }

    public void setNgayMuon(String NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }
    
}
