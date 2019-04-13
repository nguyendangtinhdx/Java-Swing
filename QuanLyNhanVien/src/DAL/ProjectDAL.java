/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Department;
import Entity.Project;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class ProjectDAL extends DataAcccessHelper{
    private final String GET_BY_ID = "SELECT * FROM Project WHERE IDPro = ?";
    private final String GET_ALL = "SELECT * FROM Project";
     
    public ArrayList<Project> getByID(int id){
        ArrayList<Project> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs!=null &&rs.next()) {
                Project item = new Project();
                item.setIDPro(rs.getInt("IDPro"));
                item.setNamePro(rs.getString("NamePro"));
                objs.add(item);
            }
            
            getClose();
        } catch (Exception e) {
        }
        return objs;
    }
    
    public ArrayList<Project> getAll(){
        ArrayList<Project> objs = new ArrayList<>();
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_ALL);
            ResultSet rs = ps.executeQuery();
            if (rs!=null) {
                while(rs.next()){
                    Project item = new Project();
                    item.setIDPro(rs.getInt("IDPro"));
                    item.setNamePro(rs.getString("NamePro"));
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
