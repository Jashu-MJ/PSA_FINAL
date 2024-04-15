/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.persona;

/**
 *
 * @author marri
 */

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DelPartner {
        
    String id;
    String name;
    String phone_number;
    String email;
    String password;
    
    public boolean isMatch(String id) {
        if(getId().equals(id)) {
            return true;
        }
        return false;
    }
    public boolean isEmailMatch(String email) {
        if(getEmail().equals(email)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getId();
    }
    
}
