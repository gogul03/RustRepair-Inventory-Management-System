/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import DB.Database;

/**
 *
 * @author Pankajan05
 */
public class Job {
    private String Id;
    private String VehicleId;
    private Double Cost;
    private String S_date;
    private String E_date;
    private String Status;
    private String CustomerId;
    private Database db = new Database();

    public Job() {
    }

    public Job(String Id, String VehicleId, Double Cost, String S_date, String E_date, String Status, String CustomerId) {
        this.Id = Id;
        this.VehicleId = VehicleId;
        this.Cost = Cost;
        this.S_date = S_date;
        this.E_date = E_date;
        this.Status = Status;
        this.CustomerId = CustomerId;
    }
    
    public void sendNotification(){
        System.out.println("Notification send successfully.");
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String VehicleId) {
        this.VehicleId = VehicleId;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(double Cost) {
        this.Cost = Cost;
    }

    public String getS_date() {
        return S_date;
    }

    public void setS_date(String S_date) {
        this.S_date = S_date;
    }

    public String getE_date() {
        return E_date;
    }

    public void setE_date(String E_date) {
        this.E_date = E_date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Database getDb() {
        return db;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String CustomerId) {
        this.CustomerId = CustomerId;
    }
    
    
    
    
}
