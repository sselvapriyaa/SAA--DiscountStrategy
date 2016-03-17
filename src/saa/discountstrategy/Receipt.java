/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * This class simulates a receipt without any dependency on how it's output.
 * It also simulates an Order. We could have created a separate order class 
 * but in a simple simulation like this that is not really necessary because 
 * the information in an Order object would be the same as the information in
 * a Receipt. So in this case the Receipt is the Order.
 * 
 * The only advantage to having a separate Order would be in situations, such
 * as an E-Commerce system, where the Order is still being processed (e.g., a
 * shopping cart that has not been finalized). But even then, unless the 
 * Order object or ShoppingCart object do something different, it would just
 * be redundant to have both.
 * @author Gladwin
 */
public class Receipt {
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;
    private static int receiptNo;
    private String storeName; 

  
  
    /**
     * Custom constructor initializes required fields.
     * @param custId - an unique customer id
     * @param db - the persistence solution
     * * @param storeName - name of seller
     */
    public Receipt( String custId, DatabaseStrategy db,String storeName) {
        setStoreName(storeName);
        receiptNo++;
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        lineItems = new LineItem[0];
    }
    
    /**
     * Adds a sale item to the receipt
     * @param prodId - the unique id of a product which simulates what a
     * bar code scanner would capture. NOTE: not currently validated.
     * @param qty - the number of this product being purchased
     */
    public void addItemToReceipt(String prodId,int qty){
       // needs validation for all arguments passed in
       LineItem item = new LineItem(prodId,qty,db);
       addItemToArray(lineItems,item);
       
         /// OTHER OPTIONS NOT CURRENTLY USED ////
         
//       LineItem[] tempArray = new LineItem[lineItems.length +1];
//       
//       System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
//       tempArray[tempArray.length -1] = item;
//       lineItems =tempArray;
        
    }
    
    // proper encapsulation -- hide this helper method because it is not
    // needed anywhere else
    private void addItemToArray(LineItem[] origArray, LineItem item){
         LineItem[] tempArray = new LineItem[origArray.length +1];
         System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
         tempArray[tempArray.length -1] = item;
         origArray =tempArray;
         lineItems=origArray;
    }
  
      ///// GETTERS/SETTERS DON'T NEED DOCS UNTIL VALIDATION CODE ADDED /////
    
    public final DatabaseStrategy getDb() {
        return db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setDb(DatabaseStrategy db) {
        //needs validation
        this.db = db;
    }

    public final void setCustomer(Customer customer) {
         //needs validation
        this.customer = customer;
    }

    public final LineItem[] getLineItems() {
        return lineItems;
    }

    public final void setLineItems(LineItem[] lineItems) {
         //needs validation
        this.lineItems = lineItems;
    }
      public static int getReceiptNo() {
        return receiptNo;
    }


    public final String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
         //needs validation
        this.storeName = storeName;
    }
     
 
    }
   
    

