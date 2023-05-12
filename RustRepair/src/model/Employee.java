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
public class Employee extends Person implements CRUD{
    
    private Double Salary;
    private String Job;
    private Database db = new Database();

    public Employee(){
        super();
    }

    public Employee(String Id, String Name, String Address, String PhoneNo, String Dob, String NIC, String Email,String Job, Double Salary) {
        super(Id, Name, Email, Address, PhoneNo, NIC, Dob);
        this.Salary = Salary;
        this.Job = Job;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String Job) {
        this.Job = Job;
    }

    @Override
    public boolean save() {
        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO employee (Id,Name,Address,Telephone,DOB,NIC,Email,Salary,Job) values('");
        sql.append(this.getId()).append("','");
        sql.append(this.getName()).append("','");
        sql.append(this.getAddress()).append("','");
        sql.append(this.getPhoneNo()).append("','");
        sql.append(this.getDob()).append("','");
        sql.append(this.getNIC()).append("','");
        sql.append(this.getEmail()).append("','");
        sql.append(this.getSalary()).append("','");
        sql.append(this.getJob()).append("')");
        
        try {
            db.run(sql);
            return true;
        } catch (SQLException ex) {
            return false;
        }   
    }

    @Override
    public boolean delete() {
        String sql = "DELETE FROM employee WHERE Id='" + super.getId() + "'";
        
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

            sql2.append("UPDATE employee SET NIC='").append(this.getNIC());
            sql2.append("',Name='").append(this.getName());
            sql2.append("',Address='").append(this.getAddress());
            sql2.append("',Email='").append(this.getEmail());
            sql2.append("',Salary='").append(this.getSalary());
            sql2.append("',DOB='").append(this.getDob());
            sql2.append("',Telephone='").append(this.getPhoneNo());
            sql2.append("',Job='").append(this.getJob());
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
        String sql = "SELECT * FROM employee";  
        try {
            return db.read(sql);
             
        } catch (SQLException ex) {
            return null;
        } 
    }

    
    
    
}
