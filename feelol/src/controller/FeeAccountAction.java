/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.FeeAccountDAO;
import model.dto.FeeAccount;

/**
 *
 * @author BVMT
 */
public class FeeAccountAction {

    FeeAccountDAO dao = null;

    public FeeAccountAction() {
        dao = new FeeAccountDAO();
    }

    public FeeAccount create(FeeAccount fee) {
        return dao.create(fee);
    }

    public List<FeeAccount> readAll() {
        return dao.readAll();
    }

    public FeeAccount readByUsername(String username) {
        return dao.readByUsername(username);
    }

    public boolean update(FeeAccount fee) {
        return dao.update(fee);
    }

    public boolean delete(String AcId) {
        return dao.delete(AcId);
    }

}
