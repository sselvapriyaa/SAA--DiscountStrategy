/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 *
 * @author Gladwin
 */
public class SAADiscountStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       // KLUDGE: do configuration here
       
       DatabaseStrategy db=new FakeDatabase();
       
         
       
       // Start talking to objects
       
       Register register =new Register();
       register.startNewSale("100", db);
    }
    
}
