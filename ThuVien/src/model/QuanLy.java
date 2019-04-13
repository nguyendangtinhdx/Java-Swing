/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.GiaoTiep;
import java.io.Serializable;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class QuanLy implements Serializable, GiaoTiep{

    private int soluongmuon,soluongtra,giahan;
    private String ngaymuon,ngaytra;
    private DocGia d;
    private Sach s;
    
    @Override
    public Object[] toObject() {
            return new Object[]{
            this.getD().getMadg(),this.getD().getTendg(),this.getD().getKhoa(),this.getS().getMasach(),this.getS().getTensach(),
            this.getS().getTheloai(),this.getSoluongmuon(),this.getSoluongtra(),this.getNgaymuon(),this.getNgaytra(),this.getGiahan()
        };
    }

    public int getSoluongmuon() {
        return soluongmuon;
    }

    public void setSoluongmuon(int soluongmuon) {
        this.soluongmuon = soluongmuon;
    }

    public int getSoluongtra() {
        return soluongtra;
    }

    public void setSoluongtra(int soluongtra) {
        this.soluongtra = soluongtra;
    }

    public int getGiahan() {
        return giahan;
    }

    public void setGiahan(int giahan) {
        this.giahan = giahan;
    }

    public String getNgaymuon() {
        return ngaymuon;
    }

    public void setNgaymuon(String ngaymuon) {
        this.ngaymuon = ngaymuon;
    }

    public String getNgaytra() {
        return ngaytra;
    }

    public void setNgaytra(String ngaytra) {
        this.ngaytra = ngaytra;
    }

    public DocGia getD() {
        return d;
    }

    public void setD(DocGia d) {
        this.d = d;
    }

    public Sach getS() {
        return s;
    }

    public void setS(Sach s) {
        this.s = s;
    }
    
}
