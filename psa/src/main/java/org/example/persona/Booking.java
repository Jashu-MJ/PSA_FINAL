/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.persona;

/**
 *
 * @author srushtyr
 */
import java.util.Date;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Booking implements Comparable<Booking> {
    private String bookId;
    private String customerId;
    private String subscriptionId;
    private String mealId;
    private Date bookingDate;
    private Date dateOfDelivery;
    private String timeSlot;
    private String deliveryPersonId;
    private String isDelivered;

    // Constructor
    public Booking(String bookId, String customerId, String subscriptionId, String mealId, Date bookingDate,
                   Date dateOfDelivery, String timeSlot, String deliveryPersonId, String isDelivered) {
        this.bookId = bookId;
        this.customerId = customerId;
        this.subscriptionId = subscriptionId;
        this.mealId = mealId;
        this.bookingDate = bookingDate;
        this.dateOfDelivery = dateOfDelivery;
        this.timeSlot = timeSlot;
        this.deliveryPersonId = deliveryPersonId;
        this.isDelivered = isDelivered;
    }

    // Getter and setter methods for each field
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getMealId() {
        return mealId;
    }

    public void setMealId(String mealId) {
        this.mealId = mealId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getDeliveryPersonId() {
        return deliveryPersonId;
    }

    public void setDeliveryPersonId(String deliveryPersonId) {
        this.deliveryPersonId = deliveryPersonId;
    }

    public String isDelivered() {
        return isDelivered;
    }

    public void setIsDelivered(String isDelivered) {
        this.isDelivered = isDelivered;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookId='" + bookId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", mealId='" + mealId + '\'' +
                ", bookingDate=" + bookingDate +
                ", dateOfDelivery=" + dateOfDelivery +
                ", timeSlot='" + timeSlot + '\'' +
                ", deliveryPersonId='" + deliveryPersonId + '\'' +
                ", isDelivered=" + isDelivered +
                '}';
    }
    
    @Override
    public int compareTo(Booking otherBooking) {
    // Compare based on dateOfDelivery first
    int dateComparison = otherBooking.dateOfDelivery.compareTo(this.dateOfDelivery);

    if (dateComparison != 0) {
        // Return the result of the date comparison
        return dateComparison;
    } else {
        // If the dates are the same, compare based on timeSlot
        // Define a mapping for time slot comparison
        int thisTimeSlotOrder = getTimeSlotOrder(this.timeSlot);
        int otherTimeSlotOrder = getTimeSlotOrder(otherBooking.timeSlot);
        
        // Compare time slots based on their defined order
        return Integer.compare(thisTimeSlotOrder, otherTimeSlotOrder);
    }
}

// Define a helper method to assign an order to each time slot
private int getTimeSlotOrder(String timeSlot) {
    switch (timeSlot) {
        case "AFTERNOON":
            return 1; // Afternoon comes before Night
        case "NIGHT":
            return 2; // Night comes after Afternoon
        default:
            throw new IllegalArgumentException("Unknown time slot: " + timeSlot);
    }
}
}

