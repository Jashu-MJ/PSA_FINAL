/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import lombok.Data;
import org.example.utils.DBConn;

/**
 *
 * @author marri
 */
@Data
public class Ecosystem {   
    String name;
    CustomerDirectory customerDirectory;
    //ManagerDirectory managerDirectory;
    DPDirectory dPDirectory;
    Connection conn;

    public Ecosystem(String name){
        this.name = name;
        this.conn = DBConn.establishConnection();
        customerDirectory = new CustomerDirectory(DBConn.getCustomersFromDB(this.conn));
        //managerDirectory = new ManagerDirectory();
        dPDirectory = new DPDirectory(DBConn.getDPFromDB(this.conn));   
    }
    }