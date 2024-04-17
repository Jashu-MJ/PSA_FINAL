/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
import org.example.persona.SubDetails;
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
          "jdbc:oracle:thin:@hl01ltha13349reo_high?TNS_ADMIN=wallet/Wallet_HL01LTHA13349REO/";
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
      
         testBag.add(new Location(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)));
      }
      // Step 6: Close the connection
      //con.close();
    } catch (Exception e) {
      System.out.println(e);
    }
          return testBag;
    }
    
    
    public static ArrayBag<SubDetails> getSubDetailsFromDB(Connection con) {

    ArrayBag<SubDetails> testBag = new ArrayBag<SubDetails>();
    try {
      String currentDir = System.getProperty("user.dir");
      System.out.println("Current dir using System:" + currentDir);
      
      // Step 3: Create a statement object
      Statement stmt = con.createStatement();

      // Step 4: Execute the query
      ResultSet rs = stmt.executeQuery("SELECT s.sub_id,s.c_id,st.type,st.price,s.start_date,s.end_date,s.no_of_meals_left FROM subscription s join SUBSCRIPTION_TYPE st on s.sub_type_id=st.sub_type_id");

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
      
         testBag.add(new SubDetails(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5),rs.getDate(6),rs.getString(7)));
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
     
     
     public static void updateDeliveryPerson(Connection con, String bookingIdStr, String newDeliveryPersonIdStr) {
    try {
        // Convert the received String parameters to integers
        int bookingId = Integer.parseInt(bookingIdStr);
        int newDeliveryPersonId = Integer.parseInt(newDeliveryPersonIdStr);
        
        // Step 3: Create a prepared statement
        String query = "UPDATE BOOKING SET dp_id = ? WHERE book_id = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        
        // Step 4: Set parameters for the query
        pstmt.setInt(1, newDeliveryPersonId);
        pstmt.setInt(2, bookingId);
        
        // Step 5: Execute the update
        int rowsUpdated = pstmt.executeUpdate();
        
        // Step 6: Check if the update was successful
        if (rowsUpdated > 0) {
            System.out.println("Successfully updated dp_id for book_id: " + bookingId);
        } else {
            System.out.println("No booking found with book_id: " + bookingId);
        }
    } catch (SQLException e) {
        System.out.println("Error updating dp_id: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error converting parameters to int: " + e.getMessage());
    }
}
     
     public static void updateDeliveryStatus(Connection con, String bookingIdStr, String newIsDeliveredStatusStr) {
    try {
        // Convert the received String bookingId to integer
        int bookingId = Integer.parseInt(bookingIdStr);
        
        // Convert the received String is_delivered status to char
        char newIsDeliveredStatus = newIsDeliveredStatusStr.charAt(0);
        
        // Step 3: Create a prepared statement
        String query = "UPDATE BOOKING SET is_delivered = ? WHERE book_id = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        
        // Step 4: Set parameters for the query
        pstmt.setString(1, String.valueOf(newIsDeliveredStatus)); // Set the new is_delivered status as a char
        pstmt.setInt(2, bookingId); // Set booking_id
        
        // Step 5: Execute the update
        int rowsUpdated = pstmt.executeUpdate();
        
        // Step 6: Check if the update was successful
        if (rowsUpdated > 0) {
            System.out.println("Successfully updated is_delivered for book_id: " + bookingId);
        } else {
            System.out.println("No booking found with book_id: " + bookingId);
        }
    } catch (SQLException e) {
        System.out.println("Error updating is_delivered: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error converting booking_id to int: " + e.getMessage());
    } catch (StringIndexOutOfBoundsException e) {
        System.out.println("Error converting newIsDeliveredStatusStr to char: " + e.getMessage());
    }
}
public static void updateSubscriptionMealLeft(Connection con, String subid, String newMealLeft) {
     try {
        // Convert the received String bookingId to integer
        int subId = Integer.parseInt(subid);
        
        
        // Step 3: Create a prepared statement
        String query = "UPDATE SUBSCRIPTION SET NO_OF_MEALS_LEFT = ? WHERE SUB_ID = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        
        // Step 4: Set parameters for the query
        pstmt.setString(1, newMealLeft); // Set the new is_delivered status as a char
        pstmt.setInt(2, subId); // Set booking_id
        
        // Step 5: Execute the update
        int rowsUpdated = pstmt.executeUpdate();
        
        // Step 6: Check if the update was successful
        if (rowsUpdated > 0) {
            System.out.println("Successfully updated is_delivered for book_id: " + subId);
        } else {
            System.out.println("No booking found with book_id: " + subId);
        }
    } catch (SQLException e) {
        System.out.println("Error updating is_delivered: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error converting booking_id to int: " + e.getMessage());
    } catch (StringIndexOutOfBoundsException e) {
        System.out.println("Error converting newIsDeliveredStatusStr to char: " + e.getMessage());
    }
}
public static void addBooking(Connection con, Booking booking) {
     try {
System.out.println("In the insert booking");
System.out.println("booking"+booking.toString());
System.out.println("booking book id "+booking.getBookId());
       String insertQuery = "INSERT INTO BOOKING (BOOK_ID, C_ID, SUB_ID, MEAL_ID, BOOKING_DATE, DATE_OF_DELIVERY, TIME_SLOT, IS_DELIVERED) " +
                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(insertQuery);

            // Step 4: Set parameters for the insert query
System.out.println("In the insert booking1");
            pstmt.setInt(1,Integer.parseInt( booking.getBookId())); 
System.out.println("In the insert booking2");         // Assuming getBookId() returns an int
            pstmt.setInt(2,Integer.parseInt(  booking.getCustomerId())); 
System.out.println("In the insert booking3");            // Assuming getCId() returns an int
            pstmt.setInt(3, Integer.parseInt( booking.getSubscriptionId())); 
System.out.println("In the insert booking4");          // Assuming getSubId() returns an int
            pstmt.setInt(4, Integer.parseInt(booking.getMealId()));  
System.out.println("In the insert booking5");        // Assuming getMealId() returns an int
            pstmt.setDate(5, new java.sql.Date(booking.getBookingDate().getTime())); // Converting java.util.Date to java.sql.Date
            pstmt.setDate(6, booking.getDateOfDelivery() != null ? new java.sql.Date(booking.getDateOfDelivery().getTime()) : null); // Handling potential nulls
            pstmt.setString(7, booking.getTimeSlot());
            //pstmt.setInt(8, Integer.parseInt(booking.getDeliveryPersonId()));            // Assuming getDpId() returns an int, handling nullable
            pstmt.setString(8, booking.isDelivered());  // Assuming getIsDelivered() returns a String representing 'Y' or 'N'

            // Step 5: Execute the insert
            int rowsInserted = pstmt.executeUpdate();

            // Step 6: Check if the insert was successful
            if (rowsInserted > 0) {
                System.out.println("Successfully added a new booking with book_id: " + booking.getBookId());
                establishConnection();
            } else {
                System.out.println("No new booking was added.");
            }
    } catch (SQLException e) {
        System.out.println("Error updating is_delivered: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Error converting" + e.getMessage());
    } catch (StringIndexOutOfBoundsException e) {
        System.out.println("Error converting newIsDeliveredStatusStr to char: " + e.getMessage());
    }
}

}
