/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.example.dsa.ArrayBag;
import org.example.persona.Customer;
import org.example.persona.DelPartner;


public class DPDirectory {
    ArrayBag<DelPartner> dpList;
    DelPartner[] dps;
    public DPDirectory(){
        dpList = new ArrayBag();
    }
    
    public DPDirectory(ArrayBag<DelPartner> dpList){
        this.dpList = dpList;
        dps = (DelPartner[]) java.lang.reflect.Array.newInstance(DelPartner.class, dpList.getCurrentSize());
        System.arraycopy(dpList.toArray(), 0, dps, 0, dpList.getCurrentSize());
    }

    public DelPartner newDP(String loc_id, String name, String dob, String gender, String email, String phone_number, String password) {
    DelPartner dp = new DelPartner(UUID.randomUUID().toString(), name, email, phone_number,password);
    dpList.add(dp);
        return dp;
    }

    /*public Customer findCustomer(String id) {

        for(Customer cust : customerList.toArray()) {

            if (cust.isMatch(id)) {
                return cust;
            }
        }
        return null; //not found after going through the whole list
    }*/
     /*public String[] getList() {
        String[] hospName = new String[hospitallist.size()];
        ArrayList<String> hosps = new ArrayList<String>();
        hospitallist.forEach((hosp) -> {
            hosps.add(hosp.getName());

        });
        for (int i = 0; i < hospitallist.size(); i++) {
            hospName[i] = hosps.get(i);
        }
        return hospName;
    }*/
    
    public DelPartner findDPByEmail(String email) {

        for (DelPartner p : dps) {
            System.out.println(p.getEmail()+" = "+email);
            if (p.getEmail()== null ? email == null : p.getEmail().equals(email)) {
                return p;
            }
        }
        return null; //not found after going through the whole list
    }
    
    // Method to retrieve a list of delivery partner names
    public List<String> getAllDPNames() {
        List<String> dpNames = new ArrayList<>();
    
    // Iterate through the array of DelPartner objects (dps)
    for (DelPartner dp : dps) {
        dpNames.add(dp.getName()+" - "+dp.getId());
        
    }
    
    // Return the list of delivery partner names
    return dpNames;
    }
    
}
