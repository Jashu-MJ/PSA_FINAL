/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.example;

import org.example.dsa.ArrayBag;
import org.example.persona.Customer;
import org.example.persona.SubDetails;

/**
 *
 * @author marri
 */
public class SubDetailsDirectory {
        ArrayBag<SubDetails> subDetailsList;

    public SubDetailsDirectory(ArrayBag<SubDetails> sDList) {
        subDetailsList = sDList;
    }
    
    public SubDetails[] bagToArray(){
        SubDetails[] subDetails =(SubDetails[]) java.lang.reflect.Array.newInstance(SubDetails.class, subDetailsList.getCurrentSize());
        System.arraycopy(subDetailsList.toArray(), 0, subDetails, 0, subDetailsList.getCurrentSize());
        return subDetails;
    }   
}
