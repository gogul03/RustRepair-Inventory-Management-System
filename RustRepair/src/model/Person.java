/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Pankajan05
 */
public class Person {
    private String Id;
    private String Name;
    private String Email;
    private String Address;
    private String PhoneNo;
    private String NIC;
    private String Dob;
    
    public Person() {
        
    }

    public Person(String Id, String Name, String Email, String Address, String PhoneNo, String NIC, String Dob) {
        this.Id = Id;
        this.Name = Name;
        this.Email = Email;
        this.Address = Address;
        this.PhoneNo = PhoneNo;
        this.NIC = NIC;
        this.Dob = Dob;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(String PhoneNo) {
        this.PhoneNo = PhoneNo;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String Dob) {
        this.Dob = Dob;
    }
    
    
}
