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
public class PercentOffDiscount implements DiscountStrategy{
    private double discountRate ;

    public PercentOffDiscount(double discountRate) {
        setDiscountRate(discountRate);
        
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
