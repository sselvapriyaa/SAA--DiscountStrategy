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
public class Receipt {
    private DatabaseStrategy db;
    private Customer customer;
    private LineItem[] lineItems;
    private static int receiptNo;
    private String storeName;

    public static int getReceiptNo() {
        return receiptNo;
    }

    public static void setReceiptNo(int receiptNo) {
        Receipt.receiptNo = receiptNo;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
     
    public Receipt(String custId,DatabaseStrategy db,String storeName)
    {
        setStoreName(storeName);
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        lineItems=new LineItem[0];
    }
    public Receipt(String storeName, String custId, DatabaseStrategy db) {
        setStoreName(storeName);
        receiptNo++;
        setDb(db);
        setCustomer(db.findCustomerById(custId));
        lineItems = new LineItem[0];
    }
    
    public void addItemToReceipt(String prodId,int qty){
       LineItem item = new LineItem(prodId,qty,db);
       addItemToArray(lineItems,item);
       
//       LineItem[] tempArray = new LineItem[lineItems.length +1];
//       
//       System.arraycopy(lineItems, 0, tempArray, 0, lineItems.length);
//       tempArray[tempArray.length -1] = item;
//       lineItems =tempArray;
        
    }
    
    private void addItemToArray(LineItem[] origArray, LineItem item){
         LineItem[] tempArray = new LineItem[origArray.length +1];
         System.arraycopy(origArray, 0, tempArray, 0, origArray.length);
         tempArray[tempArray.length -1] = item;
         origArray =tempArray;
         lineItems=origArray;
    }
//    public final double getGrandTotal(){
//        for(LineItem item : lineItems){
//             total+=item.getExtPrice(item.getQty() ,item.getProduct().getUnitCost());
//        }
//        return total;
//    }
    
            
    public final DatabaseStrategy getDb() {
        return db;
    }

    public final Customer getCustomer() {
        return customer;
    }

    public final void setDb(DatabaseStrategy db) {
        this.db = db;
    }

    public final void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LineItem[] getLineItems() {
        return lineItems;
    }

    public void setLineItems(LineItem[] lineItems) {
        this.lineItems = lineItems;
    }
    
     
   // public final void endSale(){
  //       LineItem[] items = register.getReceipt().getLineItems();
//       for(LineItem item : items){
//           
//           System.out.println(item.getProduct().getProdName());
//            System.out.println(item.getQty());       
//           
//       }
//       for(LineItem item : items){
//           System.out.println(item.getProduct().getUnitCost()+"    " + item.getProduct().getDiscount().getDiscountAmt( item.getQty(), item.getProduct().getUnitCost()));
//           
//       }
       
        //System.out.println(register.getReceipt().getGrandTotal());
        
//         for(LineItem item : items){     
//         System.out.println(item.getExtPrice()+ "\t" + (item.getExtPrice() - item.getDiscountedTotal())+ " " + item.getDiscountedTotal());
//         }
//         
//         //LineItem[] items = receipt.getLineItems();
//         System.out.println("Grand Total:");
//         System.out.println("Total before Discount:");
//         System.out.println("Total after Discount:");
//         System.out.println("Total savings:");
       
            
    }
   
    

