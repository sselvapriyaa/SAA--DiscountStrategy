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
    
    public Receipt(String custId,DatabaseStrategy db)
    {
        setDb(db);
        setCustomer(db.findCustomerById(custId));
    }
    
   
    
}
