/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.persona;


public class Location {
    
    private String locId;
    private String streetAddress;
    private String city;
    private String state;
    private String zipcode;

    // Default constructor
    public Location() {
        // Default initialization
    }

    // Parameterized constructor
    public Location(String locId, String streetAddress, String city, String state, String zipcode) {
        this.locId = locId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    // Getter and setter methods for each field

    // LOC_ID
    public String getLocId() {
        return locId;
    }

    public void setLocId(String locId) {
        this.locId = locId;
    }

    // STREET_ADDRESS
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    // CITY
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // STATE
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    // ZIPCODE
    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    // Method to represent the Location object as a String
    @Override
    public String toString() {
        return "Location{" +
                "locId=" + locId +
                ", streetAddress='" + streetAddress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
    
}
