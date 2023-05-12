/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pankajan05
 */
public class Database {
    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    
    public Database(){
         final String url="jdbc:mysql://localhost:3306/RustRepair";
         final String user="root";
         final String password="1234";
        
        try {
           
            this.con = DriverManager.getConnection(url,user,password);
            System.out.println("Connected");
        } catch ( SQLException e) {
            System.out.println(e);
        }
    }
    
    public void run(StringBuilder sql) throws SQLException{
          preparedStatement = con.prepareStatement(sql.toString());
          preparedStatement.execute();
    }
    
    public void run(String sql) throws SQLException{
          preparedStatement = con.prepareStatement(sql);
          preparedStatement.execute();
    }
    
    public ResultSet read(String sql) throws SQLException{
        preparedStatement = con.prepareStatement(sql);
        this.resultSet = preparedStatement.executeQuery();
        
        return this.resultSet;
    }
}
