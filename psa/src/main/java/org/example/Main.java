package org.example;

import java.io.IOException;
import java.sql.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
    // Press Alt+Enter with your caret at the highlighted text to see how
    // IntelliJ IDEA suggests fixing it.
    System.out.printf("Hello and welcome!");
    
//    // Create a booking directory
//        BookingDirectory bookingDirectory = new BookingDirectory();
//
//        // Generate sample bookings
//        bookingDirectory.generateSampleBookings();
//
//        // Display all bookings
//        bookingDirectory.displayAllBookings();

    // Press Shift+F10 or click the green arrow button in the gutter to run the code.
    for (int i = 1; i <= 5; i++) {

      // Press Shift+F9 to start debugging your code. We have set one breakpoint
      // for you, but you can always add more by pressing Ctrl+F8.
      System.out.println("i = " + i);
    }
    String currentPath = new java.io.File(".").getCanonicalPath();
    System.out.println("Current dir:" + currentPath);
    try {
      String currentDir = System.getProperty("user.dir");
      System.out.println("Current dir using System:" + currentDir);
      // String dbname_high =
      //   "(description=
      // (retry_count=2)(retry_delay=3)(address=(protocol=tcps)(port=1522)(host=adb.us-ashburn-1.oraclecloud.com))(connect_data=(service_name=g6408fde26c4328_hl01ltha13349reo_high.adb.oraclecloud.com))(security=(ssl_server_dn_match=yes)))";

      String DB_URL =
          "jdbc:oracle:thin:@hl01ltha13349reo_high?TNS_ADMIN=wallet/Wallet_HL01LTHA13349REO";
      String DB_USER = "ADMIN";
      String DB_PASSWORD = "Projectpass@123";
      final String CONN_FACTORY_CLASS_NAME = "oracle.jdbc.pool.OracleDataSource";
      Class.forName("oracle.jdbc.driver.OracleDriver");
      Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

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
      }

      // Step 6: Close the connection
      con.close();
      
      
    } catch (Exception e) {
      System.out.println(e);
    }
  }
}
