/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import Entity.Employees;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nguyen Dang Tinh
 */
public class EmployeesDAL extends DataAcccessHelper{
    private final String GET_LOGIN = "SELECT * FROM Employees where username=? and password=? ";
    private final String GET_ALL = "SELECT * FROM Employees";
    private final String ADD_DATA = "INSERT INTO Employees(username,password,age,address,phone,IDDep,IDPro) VALUES (?,?,?,?,?,?,?)";
    private final String UPDATE_DATA = "UPDATE Employees SET password=?, age=?,address=?,phone=?,IDDep=?,IDPro=? WHERE username=? " ;
    private final String REMOVE_DATA = "DELETE FROM Employees WHERE username = ? ";
    public boolean getLogin(String u, String p){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(GET_LOGIN);
            ps.setString(1,u);
            ps.setString(2,p);
            ResultSet rs = ps.executeQuery();
            if(rs!=null && rs.next()){
                check=true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public ArrayList<Employees> getAll(){
        ArrayList<Employees> objs = new ArrayList<>();
        try {
            getConnect();
                PreparedStatement ps = con.prepareStatement(GET_ALL);
                ResultSet rs = ps.executeQuery();
                if (rs!=null) {
                    while(rs.next()){
                        Employees item = new Employees();
                        item.setUsername(rs.getString("username"));
                        item.setPassword(rs.getString("password"));
                        item.setAge(rs.getInt("age"));
                        item.setAddress(rs.getString("address"));
                        item.setPhone(rs.getString("phone"));
                        item.setIDDep(rs.getInt("IDDep"));
                        item.setIDPro(rs.getInt("IDPro"));
                        objs.add(item);
                    }
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }
    
    public boolean AddData(Employees emp){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(ADD_DATA);
            ps.setString(1,emp.getUsername());
            ps.setString(2,emp.getPassword());
            ps.setInt(3,emp.getAge());
            ps.setString(4,emp.getAddress());
            ps.setString(5,emp.getPhone());
            ps.setInt(6,emp.getIDDep());
            ps.setInt(7,emp.getIDPro());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    public boolean DeleteData(String u){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(REMOVE_DATA);
            ps.setString(1, u);
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
    
    public boolean Update(Employees emp){
        boolean check = false;
        try {
            getConnect();
            PreparedStatement ps = con.prepareStatement(UPDATE_DATA);
            ps.setString(1,emp.getPassword());
            ps.setInt(2,emp.getAge());
            ps.setString(3,emp.getAddress());
            ps.setString(4,emp.getPhone());
            ps.setInt(5,emp.getIDDep());
            ps.setInt(6,emp.getIDPro());
            ps.setString(7,emp.getUsername());
            int rs = ps.executeUpdate();
            if (rs > 0) {
                check = true;
            }
            getClose();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return check;
    }
}
