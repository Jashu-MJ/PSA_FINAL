/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.utils;

import org.example.Ecosystem;
import org.example.persona.Customer;
import org.example.persona.DelPartner;

/**
 *
 * @author marri
 */
public class Utils {
    
    public static boolean authenticateUser(Ecosystem es, String userType, String username, String password){
        if("customer".equals(userType.toLowerCase())){
            Customer customer = es.getCustomerDirectory().findCustomerByEmail(username);
            //System.out.print(customer.toString());
            if(customer == null || !customer.getPassword().equals(password)){
                return false;
            }
            System.out.print(customer.toString());
        }
        else if("manager".equals(userType.toLowerCase())){
            if(!("ManagerAdmin".equals(username) && "password".equals(password))){
                return false;
            }
        }
        else if("dp".equals(userType.toLowerCase())){
            DelPartner dp = es.getDPDirectory().findDPByEmail(username);
            if(dp == null || !dp.getPassword().equals(password)){
                return false;
            }
        }
        return true;
    }
    
}
