/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * An implementation of the DatabaseStrategy contract. This fakes database 
 * access by using arrays of hard-code products and customers. There 
 * currently is no way of modifying these.
 * @author Gladwin
 */
public class FakeDatabase implements DatabaseStrategy {
    private Customer[] customers= {
        new Customer("100","Bob James"),
        new Customer("200","Sally Smith"),
        new Customer("300","Peter Piper")
    };
    
    private Product[] products={
        new Product("11","Brewer's Hat",29.95,new PercentOffDiscount(.10)),
        new Product("22","Women's Blouse",49.95,new FlatAmtDiscount(5.00)),
        new Product("33","Men's Black Belt",39.95,new NoDiscount())
        
    };
    /**
     * Finds a product by its unique id.
     * @param prodId
     * @return a Product object or null if not found
     */
   // cannot be null or empty.must be atleast
    // 3 characters but no more than 6 characters
    @Override
    public final Product findProductById(String prodId)throws IllegalArgumentException {
        //needs validation
         if(prodId == null || prodId.isEmpty() ||
                prodId.length() <3 || prodId.length() >6){
            throw new IllegalArgumentException(
            "Sorry prodId is mandatory and must be between 3 and 6 characters in length.");
        }
        
        Product product=null;
        
         for(Product p: products){
            if(p.getProdId().equals(prodId)){
                product=p;
                break;
            }
        }
        return product;
        
    }
    /**
     * Finds a customer by its unique id.
     * @param custId
     * @return a Customer object or null if not found
     */
     
    // cannot be null and cannot be empty and min and max length
    // not more than 15 characters
    @Override
    public final Customer findCustomerById(String custId)throws IllegalArgumentException{
        // needs validation
                          
                 if(custId == null || custId.isEmpty() ||
                custId.length() <3 || custId.length() >15){
            throw new IllegalArgumentException(
            "Sorry cust Id is mandatory and must be between 3 and 15 characters in length.");
        }
        
        Customer customer=null;
        
        for(Customer c: customers){
            if(c.getCustId().equals(custId)){
                customer=c;
                break;
            }
        }
        return customer;
    }


}

