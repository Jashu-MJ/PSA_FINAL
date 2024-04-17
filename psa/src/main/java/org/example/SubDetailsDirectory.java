/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.dsa.ArrayBag;
import org.example.persona.Booking;
import org.example.persona.Customer;
import org.example.persona.SubDetails;
import org.example.utils.DBConn;

/**
 *
 * @author marri
 */
public class SubDetailsDirectory {
        ArrayBag<SubDetails> subDetailsList;
 private SubDetails[] subscription; 
 public SubDetailsDirectory()
{
 subDetailsList = new ArrayBag<SubDetails>(); 
}

    public SubDetailsDirectory(ArrayBag<SubDetails> sDList) {
        subDetailsList = sDList;
        subscription = (SubDetails[]) java.lang.reflect.Array.newInstance(SubDetails.class, sDList.getCurrentSize());

        // Copy the contents of the ArrayBag to the book array
        System.arraycopy(sDList.toArray(), 0, subscription, 0, sDList.getCurrentSize());
    }
    public void updateSubscription(String subid) {
        for (int i = 0; i < subscription.length; i++) {
            SubDetails existingSub = subscription[i];
            if (existingSub.getSID().equals(subid)) {
                //subscription[i] = updatedBooking; // Update the booking in the array
                //subDetailsList.set(i, updatedBooking); // Update the booking in the ArrayBag  
                int currentMealsLeft = Integer.parseInt(existingSub.getMealsLeft());
                currentMealsLeft--;
                existingSub.setMealsLeft(String.valueOf(currentMealsLeft));
                DBConn.updateSubscriptionMealLeft(DBConn.establishConnection(), subid, String.valueOf(currentMealsLeft));
                return; // Stop the loop once the booking is updated
            }
        }
    }
   public List<SubDetails> getBookingList() {
        // Return a list containing all bookings
        List<SubDetails> bookings = new ArrayList<>();
        for (SubDetails booking : subscription) {
            bookings.add(booking);
        }
        return bookings;
    }
    
    public SubDetails[] bagToArray(){
        SubDetails[] subDetails =(SubDetails[]) java.lang.reflect.Array.newInstance(SubDetails.class, subDetailsList.getCurrentSize());
        System.arraycopy(subDetailsList.toArray(), 0, subDetails, 0, subDetailsList.getCurrentSize());
        return subDetails;
    }   
}
