/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.util.Date;

/**
 *
 * @author USER
 */
public class Fee {
    private int FeeId;
    private int AccountId;
    private Date DateStart;
    private Date DateEnd;
    private int AreaId;

    public Fee() {
    }

    public int getFeeId() {
        return FeeId;
    }

    public void setFeeId(int FeeId) {
        this.FeeId = FeeId;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int AccountId) {
        this.AccountId = AccountId;
    }

    public Date getDateStart() {
        return DateStart;
    }

    public void setDateStart(Date DateStart) {
        this.DateStart = DateStart;
    }

    public Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(Date DateEnd) {
        this.DateEnd = DateEnd;
    }

    public int getAreaId() {
        return AreaId;
    }

    public void setAreaId(int AreaId) {
        this.AreaId = AreaId;
    }

    @Override
    public String toString() {
        return "Fee{" + "FeeId=" + FeeId + ", AccountId=" + AccountId + ", DateStart=" + DateStart + ", DateEnd=" + DateEnd + ", AreaId=" + AreaId + '}';
    }
    
}
