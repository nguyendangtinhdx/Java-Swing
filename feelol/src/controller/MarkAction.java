/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.MarkDAO;
import model.dto.Mark;

/**
 *
 * @author BVMT
 */
public class MarkAction {

    MarkDAO dao = null;

    public MarkAction() {
        dao = new MarkDAO();
    }

    public Mark create(Mark mark) {
        return dao.create(mark);
    }

    public List<Mark> readAll() {
        return dao.readAll();
    }

    public boolean update(Mark mark) {
        return dao.update(mark);
    }

    public boolean delete(int markID) {
        return dao.delete(markID);
    }
}
