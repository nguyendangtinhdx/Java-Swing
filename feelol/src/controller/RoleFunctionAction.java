/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import model.dao.RoleFunctionDAO;
import model.dto.RoleFunction;

/**
 *
 * @author BVMT
 */
public class RoleFunctionAction {

        RoleFunctionDAO dao = null;

        public RoleFunctionAction() {
            dao = new RoleFunctionDAO();
        }

        public RoleFunction create(RoleFunction rolfun) {
            return dao.create(rolfun);
        }

        public List<RoleFunction> readAll() {
            return dao.readAll();
        }

        public boolean update(RoleFunction rolfun) {
            return dao.update(rolfun);
        }

        public boolean delete(int id) {
            return dao.delete(id);
        }

    }
