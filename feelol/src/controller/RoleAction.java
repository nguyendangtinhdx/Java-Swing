/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.RoleDAO;
import model.dto.Role;

/**
 *
 * @author BVMT
 */
public class RoleAction {

    RoleDAO dao = null;

    public RoleAction() {
        dao = new RoleDAO();
    }

    public Role create(Role role) {
        return dao.create(role);
    }

    public List<Role> readAll() {
        return dao.readAll();
    }

    public boolean update(Role role) {
        return dao.update(role);
    }

    public boolean delete(int RoleId) {
        return dao.delete(RoleId);
    }

}
