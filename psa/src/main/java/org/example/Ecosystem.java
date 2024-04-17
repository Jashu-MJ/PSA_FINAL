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
    SubDetailsDirectory subDetailsDirectory;
    DPDirectory dPDirectory;
    LocationDirectory locDirectory;
    BookingDirectory bookingDirectory;
    Connection conn;

    public Ecosystem(String name){
        this.name = name;
        this.conn = DBConn.establishConnection();
        customerDirectory = new CustomerDirectory(DBConn.getCustomersFromDB(this.conn));
        //managerDirectory = new ManagerDirectory();
        dPDirectory = new DPDirectory(DBConn.getDPFromDB(this.conn));
        locDirectory = new LocationDirectory(DBConn.getLocFromDB(this.conn));
        bookingDirectory = new BookingDirectory(DBConn.getBookFromDB(this.conn));
        subDetailsDirectory = new SubDetailsDirectory(DBConn.getSubDetailsFromDB(this.conn));
    }
    
    public void refreshCustomers(){
        customerDirectory.customerList = DBConn.getCustomersFromDB(this.conn);
    }
    public void refreshDPs(){
        dPDirectory.dpList = DBConn.getDPFromDB(this.conn);
    }
    public void refreshSubDetails(){
        subDetailsDirectory.subDetailsList = DBConn.getSubDetailsFromDB(this.conn);
    }
      public void refreshBookingDetails(){
        bookingDirectory = new BookingDirectory(DBConn.getBookFromDB(this.conn));
        //bookingDirectory.displayAllBookings();
    }
    }
