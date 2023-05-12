/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;

/**
 *
 * @author Pankajan05
 */
public interface CRUD {
    public boolean save();
    public boolean delete();
    public boolean update();
    public ResultSet read();
}
