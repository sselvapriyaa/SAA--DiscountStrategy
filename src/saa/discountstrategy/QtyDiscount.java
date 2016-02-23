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
public class QtyDiscount implements DiscountStrategy{
    private double discountRate ;
    private int minQty;
    private final int NO_DISCOUNT=0;

    public QtyDiscount(double discountRate, int minQty) {
        setDiscountRate(discountRate);
        setMinQty(minQty);
    }

    public final void setMinQty(int minQty) {
        this.minQty = minQty;
    }

    public final int getMinQty() {
        return minQty;
    }

    public QtyDiscount(double discountRate) {
        setDiscountRate(discountRate);
        
    }
    
    @Override
    public final double getDiscountAmt(int qty, double unitCost) {
        // needs validation
        if(qty >= minQty){
            return unitCost * qty * discountRate;
             }
        else{
            return NO_DISCOUNT;
        }
               
    }

    public final void setDiscountRate(double discountRate) {
        // needs validation
        this.discountRate = discountRate;
    }

    public final double getDiscountRate() {
        return discountRate;
    }

    
    
}
