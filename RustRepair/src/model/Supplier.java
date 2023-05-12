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
public class Supplier extends Person implements CRUD{
    private String Company;
    private Database db = new Database();

    public Supplier(){
        super();
    }

    public Supplier(String Id, String Name, String Address, String PhoneNo, String Dob, String NIC, String Email,String Company) {
        super(Id, Name, Email, Address, PhoneNo, NIC, Dob);
        this.Company = Company;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    
    @Override
    public boolean save() {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO suppliers (Id,Name,Address,Telephone,DOB,NIC,Email,Company) values('");
        sql.append(this.getId()).append("','");
        sql.append(this.getName()).append("','");
        sql.append(this.getAddress()).append("','");
        sql.append(this.getPhoneNo()).append("','");
        sql.append(this.getDob()).append("','");
        sql.append(this.getNIC()).append("','");
        sql.append(this.getEmail()).append("','");
        sql.append(this.getCompany()).append("')");
        
        try {
            db.run(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }   
    }

    @Override
    public boolean delete() {
        String sql = "DELETE FROM suppliers WHERE Id='" + super.getId() + "'";
        
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

            sql2.append("UPDATE suppliers SET NIC='").append(this.getNIC());
            sql2.append("',Name='").append(this.getName());
            sql2.append("',Address='").append(this.getAddress());
            sql2.append("',Email='").append(this.getEmail());
            sql2.append("',DOB='").append(this.getDob());
            sql2.append("',Telephone='").append(this.getPhoneNo());
            sql2.append("',Company='").append(this.getCompany());
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
        String sql = "SELECT * FROM suppliers";  
        try {
            return db.read(sql);
             
        } catch (SQLException ex) {
            return null;
        } 
    }
    
}
