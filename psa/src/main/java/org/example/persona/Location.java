/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.persona;


public class Location {
    
    private int locId;
    private String streetAddress;
    private String city;
    private String state;
    private int zipcode;

    // Default constructor
    public Location() {
        // Default initialization
    }

    // Parameterized constructor
    public Location(int locId, String streetAddress, String city, String state, int zipcode) {
        this.locId = locId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    // Getter and setter methods for each field

    // LOC_ID
    public int getLocId() {
        return locId;
    }

    public void setLocId(int locId) {
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
    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
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
