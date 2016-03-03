/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * An implementation of the DiscountStrategy contract representing a flat
 * dollar amount off the regular price.
 * @author Gladwin
 */
public class FlatAmtDiscount implements DiscountStrategy{
    private double discountRate ;

    public FlatAmtDiscount(double discountRate) {
        setDiscountRate(discountRate);
        
    }
    
    /**
     * Gets a flat amount off the regular price regardless of quantity.
     * @param qty - the quantity of product purchased. NOTE: not currently
     * validated
     * @param unitCost - the original price of one product. NOTE: not 
     * currently validated.
     * @return 
     */
    
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        // needs validation
        return discountRate;
        
    }

    public final void setDiscountRate(double discountRate) {
        // needs validation
        this.discountRate = discountRate;
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    
    
}
