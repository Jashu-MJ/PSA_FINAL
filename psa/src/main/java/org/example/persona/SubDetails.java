/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example.persona;

import java.util.Comparator;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author marri
 */
@Data
@AllArgsConstructor
public class SubDetails {
    
     String sID;
     String cID;
     String subType;
     String SubPrice;
     Date sDate;
     Date eDate;
     String mealsLeft;
     
    public boolean isMatch(String id) {
        if(getSID().equals(id)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return getSID();
    }
}
