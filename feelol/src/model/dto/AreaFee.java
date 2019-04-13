/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

/**
 *
 * @author USER
 */
public class AreaFee {
    private int AreaId;
    private float FeeArea;

    public AreaFee() {
    }

    public int getAreaId() {
        return AreaId;
    }

    public void setAreaId(int AreaId) {
        this.AreaId = AreaId;
    }

    public float getFeeArea() {
        return FeeArea;
    }

    public void setFeeArea(float FeeArea) {
        this.FeeArea = FeeArea;
    }

    @Override
    public String toString() {
        return "AreaFee{" + "AreaId=" + AreaId + ", FeeArea=" + FeeArea + '}';
    }
    
}
