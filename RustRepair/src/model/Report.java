/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DB.Database;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pankajan05
 */
public class Report {
    private Database db = new Database();

    public Report(){
        
    }
    
    public String generateReport() {
             String sql = "SELECT Salary FROM employee"; 
             String sql1 = "SELECT Cost FROM restoration";  
             String sql2 = "SELECT Cost FROM repair";
             
             ResultSet rs;
             
             double cost = 0.0;
             double earn = 0.0;
             
        try {
             rs = this.db.read(sql);
             while (rs.next()) {
                cost += rs.getDouble("Salary");
             }
             
             rs = this.db.read(sql1);
             while (rs.next()) {
                earn += rs.getDouble("Cost");
             }
             rs = this.db.read(sql2);
             while (rs.next()) {
                earn += rs.getDouble("Cost");
             }
        } catch (SQLException ex) {
            return "There is some error in the database so try later";
        } 
        
        return "<html>Total Earning In Rust Repair : " + earn + "<br/>Total Cost In Rust Repair : " + cost + "<br/><br/><br/> So Total Income : " + (earn - cost)+"</html>";
            
    }
    
}
