/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * An implementation of the DiscountStrategy contract that uses a percent off
 * of the regular price as the discount.
 * @author Gladwin
 */
public class PercentOffDiscount implements DiscountStrategy{
    private double discountRate ;
    
    /**
     * Custom constructor requires a discount rate which is the percent off
     * used for this discount.
     * @param discountRate 
     */

    public PercentOffDiscount(double discountRate) {
        setDiscountRate(discountRate);
        
    }
     /**
     * Calculates the discount based on the quantity of product purchased and 
     * the unit cost of that product and the percent off
     * @param qty
     * @param unitCost
     * @return qty * unitCost * discount percentage
     */
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        // needs validation
        return unitCost * qty * discountRate;
        
    }

    public final void setDiscountRate(double discountRate) {
        // needs validation
        this.discountRate = discountRate;
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    
    
}
