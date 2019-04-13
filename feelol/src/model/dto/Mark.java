/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dto;

import java.io.Serializable;

/**
 *
 * @author BVMT
 */
public class Mark implements Serializable{
    private int markID;
    private int courseID;
    private float mark;
    private int accountID;

    public Mark() {
    }

    public Mark(int markID, int courseID, float mark, int accountID) {
        this.markID = markID;
        this.courseID = courseID;
        this.mark = mark;
        this.accountID = accountID;
    }

    public int getMarkID() {
        return markID;
    }

    public void setMarkID(int markID) {
        this.markID = markID;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    
}
