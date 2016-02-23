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
public class Register {
    private Receipt receipt;
    private String storeName;

    public Receipt getReceipt() {
        return receipt;
    }

    public String getStoreName() {
        return storeName;
    }

    public final void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public final void setStoreName(String storeName) {
        this.storeName = storeName;
    }
    
    public final void startNewSale(String custId,DatabaseStrategy db ){
        // needs validation
        receipt = new Receipt(custId, db);
        
    }
    
    public final void endSale(){
        
    }
    
    public final void addItemToSale(String prodId,int qty){
        
    }
}
