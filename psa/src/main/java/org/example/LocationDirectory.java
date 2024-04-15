/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

/**
 *
 * @author srushtyr
 */
import org.example.persona.Location;
import org.example.dsa.ArrayBag;
import org.example.persona.Customer;

public class LocationDirectory {
    // Create an ArrayBag to store Location objects
    private ArrayBag<Location> locationBag;
    ArrayBag<Location> locationList;
    Location[] locs;

    // Constructor
    public LocationDirectory() {
        locationBag = new ArrayBag<>();
    }

    LocationDirectory(ArrayBag<Location> lList) {
        locationList = lList;
        locs = (Location[]) java.lang.reflect.Array.newInstance(Location.class, lList.getCurrentSize());
        System.arraycopy(lList.toArray(), 0, locs, 0, lList.getCurrentSize());
    }

    // Method to add a new location
    public void addLocation(Location location) {
        locationBag.add(location);
    }

    // Method to find a location by its LOC_ID
    public Location findLocationById(int locId) {
        for (Location location : locationBag.toArray()) {
            if (location.getLocId() == locId) {
                return location;
            }
        }
        return null; // Return null if not found
    }

    // Method to get all locations as a list
    public Location[] getAllLocations() {
        return locationBag.toArray();
    }

    // Method to remove a location by its LOC_ID
    public void removeLocationById(int locId) {
        for (Location location : locationBag.toArray()) {
            if (location.getLocId() == locId) {
                locationBag.remove(location);
                break;
            }
        }
    }

    // Optional method to clear the bag of all locations
    public void clearAllLocations() {
        locationBag.clear();
    }
    
}
