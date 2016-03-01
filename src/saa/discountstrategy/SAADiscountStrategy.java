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
       
       Register register =new Register("Kohls Department Store");
       register.startNewSale("100", db);
       // test so far....
       Customer customer=register.getReceipt().getCustomer();
        System.out.println("Customer " + customer.getCustName()
                +" found and added to the receipt");
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 1);
        register.addItemToSale("33", 3);
        
        register.endSale();
        //test ....
       LineItem[] items = register.getReceipt().getLineItems();
       for(LineItem item : items){
           System.out.println(item.getProduct().getProdName());
           
       }
       for(LineItem item : items){
           System.out.println(item.getProduct().getUnitCost()+"    " + item.getProduct().getDiscount().getDiscountAmt( item.getQty(), item.getProduct().getUnitCost()));
           
       }
       
        //System.out.println(register.getReceipt().getGrandTotal());
        
         for(LineItem item : items){     
         System.out.println(item.getExtPrice()+ "\t" + (item.getExtPrice() - item.getDiscountedTotal())+ " " + item.getDiscountedTotal());
         }
         
         //LineItem[] items = receipt.getLineItems();
       
            
         System.out.println("Grand Totals:");
         System.out.println("Total Before Discount:");
         System.out.println("Total After Discount:");
         System.out.println("Total Savings:");
       
    
    
    }
}

