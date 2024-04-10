/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.persona;

import java.time.LocalDate;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author marri
 */
@Data
@AllArgsConstructor
public class Customer {
    
    String id;
    String loc_id;
    String name;
    String dob;
    String gender;
    String email;
    String phone_number;
    String password;
    

    public boolean isMatch(String id) {
        if(getId().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getId();
    }
}
