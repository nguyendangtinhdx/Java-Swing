/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dto.Function;
import utils.DBConnect;


/**
 *
 * @author BVMT
 */
public class FunctionDAO {
    private final String SQLCREATE = "INSERT INTO [function] VALUES(?,?)";  
    private String SQLREADALL = "";
    private String SQLUPDATE = "";
    private String SQLDELETE = "";
    private Connection con = null;
    public FunctionDAO() {
        con = new DBConnect().getCon();
    }

    public Function create(Function func) {
        try {
            PreparedStatement pr = con.prepareStatement(SQLCREATE, Statement.RETURN_GENERATED_KEYS);
//            pr.setInt(1, func.getFuntionId());
            pr.setString(1, func.getFuntionName());
            pr.setString(2, func.getDescription());
            pr.execute();
            ResultSet rs = pr.getGeneratedKeys();
            int generatedKey=0;
            if(rs.next()){
            generatedKey= rs.getInt(1);
            }
            return func;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Function> readAll() {
        String s = "SELECT * FROM [function]";
        List<Function> list = new ArrayList<Function>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(s);
            if (rs != null) {   
                while (rs.next()) {
                    Function func = new Function();
                    func.setFuntionId(rs.getInt(1));
                    func.setFuntionName(rs.getString(2));
                    func.setDescription(rs.getString(3));
                    list.add(func);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public boolean update(Function func) {
        try {
            String s = "UPDATE [function] SET FunctionName = ?,description = ? WHERE functionid = ?";
            PreparedStatement pr = con.prepareStatement(s);
            pr.setFloat(3, func.getFuntionId());
            pr.setString(1, func.getFuntionName());
            pr.setString(2, func.getDescription());
            pr.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean delete(int funcId) {
          try {
            String s = "delete from [function] where functionId ='" + funcId + "'";
            Statement st = con.createStatement();
            st.execute(s);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(FunctionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
    
