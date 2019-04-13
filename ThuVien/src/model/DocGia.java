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
public class DocGia implements Serializable, GiaoTiep{
    private int madg;
    private String tendg,khoa,diachi,nghenghiep;
    @Override
    public Object[] toObject() {
        return new Object[]{
            this.getMadg(),this.getTendg(),this.getKhoa(),this.getDiachi(),this.getNghenghiep()
        };
    }

    public int getMadg() {
        return madg;
    }

    public void setMadg(int madg) {
        this.madg = madg;
    }

    public String getTendg() {
        return tendg;
    }

    public void setTendg(String tendg) {
        this.tendg = tendg;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNghenghiep() {
        return nghenghiep;
    }

    public void setNghenghiep(String nghenghiep) {
        this.nghenghiep = nghenghiep;
    }
    
}
