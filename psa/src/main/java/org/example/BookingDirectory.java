/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author srushtyr
 */
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Date;
import org.example.dsa.ArrayBag;
import org.example.persona.Booking;


public class BookingDirectory {
    private ArrayBag<Booking> bookingList; // List to store bookings
    private Booking[] book; // Array to store bookings

    /**
     * Default constructor initializes an empty booking directory.
     */
    public BookingDirectory() {
        bookingList = new ArrayBag<>(); // Initialize bookingList as an empty ArrayBag
    }

    /**
     * Constructor initializes the booking directory with the given ArrayBag of bookings.
     * @param bookFromDB ArrayBag containing the initial bookings.
     */
    public BookingDirectory(ArrayBag<Booking> bookFromDB) {
        // Initialize bookingList with the provided ArrayBag
        bookingList = bookFromDB;

        // Convert the ArrayBag<Booking> to an array of Booking objects
        book = (Booking[]) java.lang.reflect.Array.newInstance(Booking.class, bookFromDB.getCurrentSize());

        // Copy the contents of the ArrayBag to the book array
        System.arraycopy(bookFromDB.toArray(), 0, book, 0, bookFromDB.getCurrentSize());
    }

    /**
     * Creates a new booking and adds it to the booking list.
     * @param customerId Customer ID.
     * @param subscriptionId Subscription ID.
     * @param mealId Meal ID.
     * @param dateOfDelivery Date of delivery.
     * @param timeSlot Time slot for delivery.
     * @param deliveryPersonId Delivery person ID.
     * @param isDelivered Delivery status.
     * @return The created booking.
     */
    public Booking newBooking(String customerId, String subscriptionId, String mealId, Date dateOfDelivery,
                              String timeSlot, String deliveryPersonId, String isDelivered) {
        // Generate a unique ID for the new booking
        String bookId = UUID.randomUUID().toString();

        // Create a new booking with the provided details
        Booking booking = new Booking(bookId, customerId, subscriptionId, mealId, new Date(), dateOfDelivery,
                                      timeSlot, deliveryPersonId, isDelivered);

        // Add the new booking to the booking list
        bookingList.add(booking);
        return booking;
    }

    /**
     * Finds a booking by its booking ID.
     * @param bookId Booking ID.
     * @return The booking with the given ID, or null if not found.
     */
    public Booking findBookingByBookId(String bookId) {
        // Iterate through the bookings array to find a matching booking
        for (Booking booking : book) {
            if (bookId.equals(booking.getBookId())) {
                return booking;
            }
        }
        // Return null if no booking is found with the given ID
        return null;
    }

    /**
     * Finds bookings for a specific customer.
     * @param customerId Customer ID.
     * @return List of bookings for the customer, or an empty list if none found.
     */
    public List<Booking> findBookingsForCustomer(String customerId) {
        List<Booking> customerBookings = new ArrayList<>();
        for (Booking booking : book) {
            // Add bookings that match the customer ID to the list
            if (customerId.equals(booking.getCustomerId())) {
                customerBookings.add(booking);
            }
        }
        return customerBookings;
    }

    /**
     * Adds a booking to the booking list.
     * @param booking The booking to add.
     */
    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    /**
     * Gets a booking by its booking ID.
     * @param bookingId Booking ID.
     * @return The booking with the given ID, or null if not found.
     */
    public Booking getBookingById(String bookingId) {
        for (Booking booking : book) {
            // Return the booking if the booking ID matches
            if (booking.getBookId().equals(bookingId)) {
                return booking;
            }
        }
        return null; // Return null if no booking is found with the given ID
    }

    /**
     * Updates a booking in the booking list.
     * @param updatedBooking The booking to update.
     */
    public void updateBooking(Booking updatedBooking) {
        for (int i = 0; i < book.length; i++) {
            Booking existingBooking = book[i];
            if (existingBooking.getBookId().equals(updatedBooking.getBookId())) {
                book[i] = updatedBooking; // Update the booking in the array
                bookingList.set(i, updatedBooking); // Update the booking in the ArrayBag
                return; // Stop the loop once the booking is updated
            }
        }
    }

    /**
     * Gets the list of all bookings.
     * @return The list of all bookings.
     */
    public List<Booking> getBookingList() {
        // Return a list containing all bookings
        List<Booking> bookings = new ArrayList<>();
        for (Booking booking : book) {
            bookings.add(booking);
        }
        return bookings;
    }

    /**
     * Displays all bookings in the booking list.
     */
    public void displayAllBookings() {
        for (Booking booking : book) {
            System.out.println(booking);
        }
    }
}

//public class BookingDirectory {
//    // Create an ArrayBag to store Location objects
//    private ArrayBag<Booking> bookingBag;
//    ArrayBag<Booking> bookingList;
//    Booking[] book;
//
//    public BookingDirectory() {
//        // Initialize bookingList as an empty ArrayList
//        bookingList = new ArrayBag<>();
//    }
//
//    public BookingDirectory(ArrayBag<Booking> bookFromDB) {
//        
//    // Initialize the bookingList with the provided ArrayBag<Booking>
//    bookingList = bookFromDB;
//
//    // Convert the ArrayBag<Booking> to an array of Booking objects
//    book = (Booking[]) java.lang.reflect.Array.newInstance(Booking.class, bookFromDB.getCurrentSize());
//
//    // Copy the contents of the ArrayBag to the book array
//    System.arraycopy(bookFromDB.toArray(), 0, book, 0, bookFromDB.getCurrentSize());
//    }
//
//    public Booking newBooking(String customerId, String subscriptionId, String mealId, Date dateOfDelivery,
//                              String timeSlot, String deliveryPersonId, String isDelivered) {
//        // Generate a unique ID for the new booking using UUID
//        String bookId = UUID.randomUUID().toString();
//
//        // Create a new booking with the provided details
//        Booking booking = new Booking(bookId, customerId, subscriptionId, mealId, new Date(), dateOfDelivery,
//                                      timeSlot, deliveryPersonId, isDelivered);
//
//        // Add the new booking to the bookingList
//        bookingList.add(booking);
//        return booking;
//    }
//
//    public Booking findBookingByBookId(String bookId) {
//        for (Booking booking : book) {
//            // Return the booking if the book ID matches
//            if (bookId.equals(booking.getBookId())) {
//                return booking;
//            }
//        }
//        return null; // Return null if no booking is found with the given ID
//    }
//
//    public List<Booking> findBookingsForCustomer(String customerId) {
//        List<Booking> customerBookings = new ArrayList<>();
//        for (Booking booking : book) {
//            // If the customer ID matches, add the booking to the list
//            if (customerId.equals(booking.getCustomerId())) {
//                customerBookings.add(booking);
//            }
//        }
//        return customerBookings;
//    }
//
//    public void addBooking(Booking booking) {
//        bookingList.add(booking);
//    }
//
//    public Booking getBookingById(String bookingId) {
//        for (Booking booking : book) {
//            // Return the booking if the booking ID matches
//            if (booking.getBookId().equals(bookingId)) {
//                return booking;
//            }
//        }
//        return null; // Return null if no booking is found with the given ID
//    }
//
//    public void updateBooking(Booking updatedBooking) {
//        // Iterate through the bookingList and update the booking if found
//        for (int i = 0; i < book.size(); i++) {
//            Booking existingBooking = book.get(i);
//            if (existingBooking.getBookId().equals(updatedBooking.getBookId())) {
//                bookingList.set(i, updatedBooking);
//                return; // Stop the loop once the booking is updated
//            }
//        }
//    }
//
//    public List<Booking> getBookingList() {
//        return bookingList;
//    }
//
//    public void displayAllBookings() {
//        // Print each booking in the bookingList
//        for (Booking booking : bookingList) {
//            System.out.println(booking);
//        }
//    }
//}


//public class BookingDirectory {
//    private ArrayBag<Booking> bookingBag;
//    ArrayBag<Booking> bookingList;
//    Booking[] book;
//
//    /**
//     * Constructor initializes an empty booking directory.
//     */
//    public BookingDirectory() {
//        bookingBag = new ArrayBag<>();
//    }
//    
//    BookingDirectory(ArrayBag<Booking> bookFromDB) {
//         // Initialize the bookingList as an ArrayList
//        bookingList = bookFromDB;
//
//        book = (Booking[]) java.lang.reflect.Array.newInstance(Booking.class, bookFromDB.getCurrentSize());
//        System.arraycopy(bookFromDB.toArray(), 0, book, 0, bookFromDB.getCurrentSize());
//    }
//
//    /**
//     * Creates a new booking and adds it to the directory.
//     * @param customerId The ID of the customer.
//     * @param subscriptionId The ID of the subscription.
//     * @param mealId The ID of the meal.
//     * @param dateOfDelivery The date of delivery.
//     * @param timeSlot The time slot for delivery.
//     * @param deliveryPersonId The ID of the delivery person.
//     * @param isDelivered Indicates whether the booking has been delivered.
//     * @return The created booking.
//     */
//    public Booking newBooking(String customerId, String subscriptionId, String mealId, Date dateOfDelivery,
//                              String timeSlot, String deliveryPersonId, String isDelivered) {
//        // Generate a unique ID for the new booking using UUID
//        String bookId = UUID.randomUUID().toString();
//
//        // Create a new booking with the provided details
//        Booking booking = new Booking(bookId, customerId, subscriptionId, mealId, new Date(), dateOfDelivery,
//                                      timeSlot, deliveryPersonId, isDelivered);
//
//        // Add the new booking to the list
//        bookingList.add(booking);
//        return booking;
//    }
//
//    /**
//     * Finds a booking by its book ID.
//     * @param bookId The ID of the booking to find.
//     * @return The booking with the given ID, or null if not found.
//     */
//    public Booking findBookingByBookId(String bookId) {
//        // Iterate through the list of bookings
//        for (Booking booking : bookingList.toArray()) {
//            // If the book ID matches, return the booking
//            if (bookId.equals(booking.getBookId())) {
//                return booking;
//            }
//        }
//        // Return null if no booking is found with the given ID
//        return null;
//    }
//
//    /**
//     * Finds bookings for a specific customer.
//     * @param customerId The ID of the customer.
//     * @return A list of bookings for the customer, or an empty list if none are found.
//     */
//    public List<Booking> findBookingsForCustomer(String customerId) {
//        List<Booking> customerBookings = new ArrayList<>();
//        // Iterate through the list of bookings
//        for (Booking booking : book) {
//            // If the customer ID matches, add the booking to the list
//            if (customerId.equals(booking.getCustomerId())) {
//                customerBookings.add(booking);
//            }
//        }
//        // Return the list of bookings for the customer
//        return customerBookings;
//    }
//    
//    // Method to add a booking to the directory
//    public void addBooking(Booking booking) {
//        bookingList.add(booking);
//    }
//    
//    // Method to retrieve a booking by its booking ID
//    public Booking getBookingById(String bookingId) {
//        for (Booking booking : book) {
//            if (booking.getBookId().equals(bookingId)) {
//                return booking;
//            }
//        }
//        return null; // Return null if no booking is found with the given ID
//    }
//
//    // Method to update an existing booking in the directory
//    public void updateBooking(Booking updatedBooking) {
//        for (int i = 0; i < book.size(); i++) {
//            Booking existingBooking = book.get(i);
//            if (existingBooking.getBookId().equals(updatedBooking.getBookId())) {
//                // Update the booking at the current index with the updated booking
//                book.set(i, updatedBooking);
//                return; // Stop the loop once the booking is updated
//            }
//        }
//    }
//    
//    /**
//     * Retrieves the list of all bookings in the directory.
//     * @return A list of all bookings.
//     */
//    public List<Booking> getBookingList() {
//        return book;
//    }
//
//    // Method to display all bookings in the directory
//    public void displayAllBookings() {
//        for (Booking booking : book) {
//            System.out.println(booking);
//        }
//    }
//
////    // Method to generate sample booking data and add to the directory
////    public void generateSampleBookings() {
////        // Sample data for bookings
////        Booking booking1 = new Booking(
////            "777001", "555001", "666001", "444001",
////            new Date(1701379200000L), new Date(1701465600000L), "12:00-14:00",
////            "333001", "N"
////        );
////
////        Booking booking2 = new Booking(
////            "777002", "555002", "666002", "444002",
////            new Date(1701465600000L), new Date(1701552000000L), "12:00-14:00",
////            "333002", "N"
////        );
////
////        Booking booking3 = new Booking(
////            "777003", "555003", "666003", "444003",
////            new Date(1701552000000L), new Date(1701638400000L), "08:00-10:00",
////            "333003", "N"
////        );
////        
////         Booking booking4 = new Booking(
////            "777004", "555001", "666001", "444001",
////            new Date(1701379200000L), new Date(1701465600000L), "08:00-10:00",
////            "333001", "N"
////        );
////
////        // Add bookings to the directory
////        addBooking(booking1);
////        addBooking(booking2);
////        addBooking(booking3);
////        addBooking(booking4);
////    }
//    
//}

