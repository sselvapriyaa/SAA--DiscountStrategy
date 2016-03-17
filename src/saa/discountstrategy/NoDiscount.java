/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * An implementation of the DiscountStrategy contract that represents no
 * discount whatsoever.
 * @author Gladwin
 */
public class NoDiscount implements DiscountStrategy{
    private double discountRate ;
    private final int NO_DISCOUNT=0; // avoid magic numbers!

    public NoDiscount() {
               
    }
    
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
