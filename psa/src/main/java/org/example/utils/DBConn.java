/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.example.dsa.ArrayBag;
import org.example.persona.Booking;
import org.example.persona.Customer;
import org.example.persona.DelPartner;
import org.example.persona.Location;
import ui.WorkAreaMainFrame;

/**
 *
 * @author marri
 */
public class DBConn {
    
    public static final Connection establishConnection() {
       Connection con = null;
        try{
           String DB_URL =
          "jdbc:oracle:thin:@hl01ltha13349reo_high?TNS_ADMIN=/Users/srushtyr/Desktop/PSA_Assignments/PSA_Project/PSA_FINAL/psa/src/main/java/org/example/utils/wallet/Wallet_HL01LTHA13349REO/";
      String DB_USER = "ADMIN";
      String DB_PASSWORD = "Projectpass@123";
      final String CONN_FACTORY_CLASS_NAME = "oracle.jdbc.pool.OracleDataSource";
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
       }catch (SQLException ex) {
            Logger.getLogger(WorkAreaMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }catch (ClassNotFoundException ex) {
            Logger.getLogger(WorkAreaMainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e) {
      System.out.println(e);
    }
         return con;
}
    
    /**
     *
     * @param con
     * @return
     * @throws SQLException
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayBag<Customer> getCustomersFromDB(Connection con){
    
    ArrayBag<Customer> testBag = new ArrayBag<Customer>();
    try {
      String currentDir = System.getProperty("user.dir");
      System.out.println("Current dir using System:" + currentDir);
      
      // Step 3: Create a statement object
      Statement stmt = con.createStatement();

      // Step 4: Execute the query
      ResultSet rs = stmt.executeQuery("SELECT * FROM customer");

      // Step 5: Process the results
      while (rs.next()) {
     
        System.out.println(
            rs.getInt(1)
                + "  "
                + rs.getString(2)
                + "  "
                + rs.getString(3)
                + "  "
                + rs.getString(4)
                + "  "
                + rs.getString(5)
                + "  "
                + rs.getString(6)
                + "  "
                + rs.getString(7) 
                + "  "
                + rs.getString(8));
      
         testBag.add(new Customer(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
      }
      // Step 6: Close the connection
      //con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
          return testBag;
    }
    
    public static ArrayBag<DelPartner> getDPFromDB(Connection con) {

    
    ArrayBag<DelPartner> testBag = new ArrayBag<DelPartner>();
    try {
      String currentDir = System.getProperty("user.dir");
      System.out.println("Current dir using System:" + currentDir);
      
      // Step 3: Create a statement object
      Statement stmt = con.createStatement();

      // Step 4: Execute the query
      ResultSet rs = stmt.executeQuery("SELECT * FROM delivery_partner");

      // Step 5: Process the results
      while (rs.next()) {
     
        System.out.println(
            rs.getInt(1)
                + "  "
                + rs.getString(2)
                + "  "
                + rs.getString(3)
                + "  "
                + rs.getString(4)
                + "  "
                + rs.getString(5));
      
         testBag.add(new DelPartner(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
      }
      // Step 6: Close the connection
      //con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
          return testBag;
    }
     
     
     public static ArrayBag<Location> getLocFromDB(Connection con) {
    
    ArrayBag<Location> testBag = new ArrayBag<Location>();
    try {
      String currentDir = System.getProperty("user.dir");
      System.out.println("Current dir using System:" + currentDir);
      
      // Step 3: Create a statement object
      Statement stmt = con.createStatement();

      // Step 4: Execute the query
      ResultSet rs = stmt.executeQuery("SELECT * FROM location");

      // Step 5: Process the results
      while (rs.next()) {
     
        System.out.println(
            rs.getInt(1)
                + "  "
                + rs.getString(2)
                + "  "
                + rs.getString(3)
                + "  "
                + rs.getString(4)
                + "  "
                + rs.getString(5));
      
         testBag.add(new Location(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
      }
      // Step 6: Close the connection
      //con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
          return testBag;
    }
     
     
     
     public static ArrayBag<Booking> getBookFromDB(Connection con) {
    
    ArrayBag<Booking> testBag = new ArrayBag<>();
    try {
      String currentDir = System.getProperty("user.dir");
      System.out.println("Current dir using System:" + currentDir);
      
      // Step 3: Create a statement object
      Statement stmt = con.createStatement();
      
      
      // Step 4: Execute the query
      ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKING");
      // Step 5: Process the results
      while (rs.next()) {
          
     
        System.out.println(
            rs.getInt(1)
                + "  "
                + rs.getInt(2)
                + "  "
                + rs.getInt(3)
                + "  "
                + rs.getInt(4)
                + "  "
                + rs.getString(5)
                + "  "
                + rs.getString(6)
                + "  "
                + rs.getString(7)
                + "  "
                + rs.getString(8)
                + "  "
                + rs.getString(9)
                
        );
      
         testBag.add(new Booking(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getString(7),rs.getString(8),rs.getString(9)));
      }
      // Step 6: Close the connection
      //con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
          return testBag;
    }
}
