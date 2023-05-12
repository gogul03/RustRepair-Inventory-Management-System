/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pankajan05
 */
public class Restoration extends Job implements CRUD{
    private String Prefer;

    public Restoration() {
    }

    public Restoration(String Prefer, String Id, String VehicleId, double Cost, String S_date, String E_date, String Status, String CustomerId) {
        super(Id, VehicleId, Cost, S_date, E_date, Status, CustomerId);
        this.Prefer = Prefer;
    }

    public String getPrefer() {
        return Prefer;
    }

    public void setPrefer(String Prefer) {
        this.Prefer = Prefer;
    }

    @Override
    public boolean save() {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO restoration (Id,VehicleId,Prefer,Cost,StartingDate,EndingDate,Status,CustomerId) values('");
        sql.append(this.getId()).append("','");
        sql.append(this.getVehicleId()).append("','");
        sql.append(this.getPrefer()).append("','");
        sql.append(this.getCost()).append("','");
        sql.append(this.getS_date()).append("','");
        sql.append(this.getE_date()).append("','");
        sql.append(this.getStatus()).append("','");
        sql.append(this.getCustomerId()).append("')");
        System.out.print(sql);
        try {
            this.getDb().run(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }   
    }

    @Override
    public boolean delete() {
        String sql = "DELETE FROM restoration WHERE Id='" + super.getId() + "'";
        
        try {
            this.getDb().run(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        } 
    }

    @Override
    public boolean update() {
        StringBuilder sql2 = new StringBuilder();

            sql2.append("UPDATE restoration SET VehicleId='").append(this.getVehicleId());
            sql2.append("',Prefer='").append(this.getPrefer());
            sql2.append("',Cost='").append(this.getCost());
            sql2.append("',StartingDate='").append(this.getS_date());
            sql2.append("',EndingDate='").append(this.getE_date());
            sql2.append("',Status='").append(this.getStatus());
            sql2.append("',CustomerId='").append(this.getCustomerId());
            sql2.append("' WHERE Id='").append(this.getId()).append("'");
            
        try {
            this.getDb().run(sql2);
            return true;
        } catch (SQLException ex) {
            return false;
        }  
    }

    @Override
    public ResultSet read() {
         String sql = "SELECT * FROM restoration";  
        try {
            return this.getDb().read(sql);
             
        } catch (SQLException ex) {
            return null;
        }    
    }
}
