/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Department;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class DepartmentDAL extends DataAcccessHelper{
    private final String GET_BY_ID = "SELECT * FROM Department WHERE IDDep = ?";
    private final String GET_ALL = "SELECT * FROM Department";
    public ArrayList<Department> getByID(int id){
        ArrayList<Department> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs!=null &&rs.next()) {
                Department item = new Department();
                item.setIDDep(rs.getInt("IDDep"));
                item.setNameDep(rs.getString("NameDep"));
                objs.add(item);
            }
            
            getClose();
        } catch (Exception e) {
        }
        return objs;
    }
    
    public ArrayList<Department> getAll(){
        ArrayList<Department> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs!=null) {
                while(rs.next()){
                    Department item = new Department();
                    item.setIDDep(rs.getInt("IDDep"));
                    item.setNameDep(rs.getString("NameDep"));
                    objs.add(item);
                }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
}
