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
public class SparePart implements CRUD{
    private String Id;
    private String Name;
    private Double Price;
    private Integer Quantity;
    private Database db = new Database();
    private String SupplierId;

    public SparePart() {
    }

    public SparePart(String Id, String Name, Double Price, Integer Quantity, String SupplierId) {
        this.Id = Id;
        this.Name = Name;
        this.Price = Price;
        this.Quantity = Quantity;
        this.SupplierId = SupplierId;
    }
    
    public void sendNotification(){
        if(Quantity == 0){
            System.out.println("Notification send to " + this.SupplierId );
        }
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public String getSupplierId() {
        return SupplierId;
    }

    public void setSupplierId(String SupplierId) {
        this.SupplierId = SupplierId;
    }

    @Override
    public boolean save() {
         StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO spareparts (Id,Name,Quantity,Price,SupplierId) values('");
        sql.append(this.getId()).append("','");
        sql.append(this.getName()).append("','");
        sql.append(this.getQuantity()).append("','");
        sql.append(this.getPrice()).append("','");
        sql.append(this.getSupplierId()).append("')");
        
        try {
            db.run(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        } 
    }

    @Override
    public boolean delete() {
        String sql = "DELETE FROM spareparts WHERE Id='" + this.getId() + "'";
        
        try {
            db.run(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }   
    }

    @Override
    public boolean update() {
        StringBuilder sql2 = new StringBuilder();

            sql2.append("UPDATE spareparts SET Price='").append(this.getPrice());
            sql2.append("',Quantity='").append(this.getQuantity());
            sql2.append("',Name='").append(this.getName());
            sql2.append("',SupplierId='").append(this.getSupplierId());
            sql2.append("' WHERE Id='").append(this.getId()).append("'");
            
        try {
            db.run(sql2);
            return true;
        } catch (SQLException ex) {
            return false;
        }  
    }

    @Override
    public ResultSet read() {
        String sql = "SELECT * FROM spareparts";  
        try {
            return db.read(sql);
             
        } catch (SQLException ex) {
            return null;
        } 
    }
    
    
}
