/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.utils;

import org.example.Ecosystem;
import org.example.persona.Customer;
import org.example.persona.DelPartner;
import org.example.dsa.HashTable;

/**
 *
 * @author marri
 */
public class Utils {
   // Cache for storing user credentials to avoid frequent database access
    private static HashTable<String, String> credentialsCache = new HashTable<>(100);
 
    
    public static boolean authenticateUser(Ecosystem es, String userType, Object user, String password){
        // Storing user email as key 
        String key = "";
        String storedPassword = null;

        if("customer".equals(userType.toLowerCase())){
            Customer customer = (Customer) user;
            if(customer == null) {
                return false;
            }
            key = customer.getEmail(); 
            storedPassword = credentialsCache.get(key);
            // If password is in cache and matches, authenticate successfully
            if(storedPassword != null && storedPassword.equals(password)) {
                System.out.println("Authenticated from cache for user:"+key);
                return true;
            }
            if( !customer.getPassword().equals(password)){
                return false;
            }
         ;
            credentialsCache.put(key, password);
        }
        else if("manager".equals(userType.toLowerCase())){
            String username = (String) user;

            if(!("ManagerAdmin".equals(username) && "password".equals(password))){
                return false;
            }
        }
        else if("dp".equals(userType.toLowerCase())){
            DelPartner dp = (DelPartner) user;
        if(dp == null) {
                return false;
            }
            key = dp.getEmail(); // Assuming DelPartner has a getUsername() method
            storedPassword = credentialsCache.get(key);
         if(storedPassword != null && storedPassword.equals(password)) {
                return true; // Cached credentials match
            }

            if( !dp.getPassword().equals(password)){
                return false;
            }
            credentialsCache.put(key, password); // Cache the credential after verification
        }
        return true;
    }

    
}
