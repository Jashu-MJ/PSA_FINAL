/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import java.util.ArrayList;
import java.util.UUID;
import org.example.dsa.ArrayBag;
import org.example.persona.Customer;

/**
 *
 * @author marri
 */
public class CustomerDirectory {
    ArrayBag<Customer> customerList;

    public CustomerDirectory(ArrayBag<Customer> cList) {
        customerList = cList;

    }

    public Customer newCustomer(String loc_id, String name, String dob, String gender, String email, String phone_number, String password) {

    Customer customer = new Customer(UUID.randomUUID().toString(),loc_id, name, dob, gender, email, phone_number,password);
    customerList.add(customer);
        return customer;
    }

    public Customer findCustomer(String id) {
        Customer[] custs = bagToArray();
        for(Customer cust : custs) {
            if (cust.isMatch(id)) {
                return cust;
            }
        }
        return null; //not found after going through the whole list
    }
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
    
    public Customer findCustomerByEmail(String email) {
        Customer[] custs = bagToArray();
        for (Customer p : custs) {
            System.out.println(p.toString()+" = "+ p.getEmail()+ " = "+ email);  
            if (p.getEmail()== null ? email == null : p.getEmail().equals(email)) {
                return p;
            }
        }
        return null; //not found after going through the whole list
    }
   
        public Customer findCustomerByPhone(String phone) {
        Customer[] custs = bagToArray();
        for (Customer p : custs) {
            System.out.println(p.toString()+" = "+ p.getPhone_number()+ " = "+ phone);  
            if (p.getPhone_number()== null ? phone == null : p.getEmail().equals(phone)) {
                return p;
            }
        }
        return null; //not found after going through the whole list
    }

    private Customer[] bagToArray(){
        Customer[] custs =(Customer[]) java.lang.reflect.Array.newInstance(Customer.class, customerList.getCurrentSize());
        System.arraycopy(customerList.toArray(), 0, custs, 0, customerList.getCurrentSize());
        return custs;
    }    
        
}
