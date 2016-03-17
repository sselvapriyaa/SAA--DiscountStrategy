/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * A simulation of a Customer.
 * @author Gladwin
 */
public class Customer {
    private String custId;
    private String custName;


    public Customer(String custId, String custName) {
        setCustId(custId);
        setCustName(custName);
        
    }

    public final String getCustId() {
        return custId;
    }

    public final String getCustName() {
        return custName;
    }
 // cannot be null and cannot be empty and min and max length
    // not more than 15 characters
    public final void setCustId(String custId)throws IllegalArgumentException {
        // needs validation
                   
                 if(custId == null || custId.isEmpty() ||
                custId.length() <3 || custId.length() >15){
            throw new IllegalArgumentException(
            "Sorry cust Id is mandatory and must be between 3 and 15 characters in length.");
        }
        
        this.custId = custId;
    }
    
  
   // cannot be null and cannot be empty and min and max length
    // not more than 15 characters
    public final void setCustName(String custName) throws IllegalArgumentException{
        // needs validation
                     if(custName == null || custName.isEmpty() ||
                custName.length() <3 || custName.length() >15){
            throw new IllegalArgumentException(
            "Sorry cust Name is mandatory and must be between 3 and 15 characters in length.");
        }
        this.custName = custName;
    }

}
