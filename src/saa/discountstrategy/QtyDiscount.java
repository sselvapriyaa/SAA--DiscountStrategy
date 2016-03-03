/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * An implementation of the DiscountStrategy contract where a discount is 
 * calculated based on a required minimum quantity.
 * @author Gladwin
 */
public class QtyDiscount implements DiscountStrategy{
    private double discountRate ;
    private int minQty;
    private final int NO_DISCOUNT=0;

    /**
     * A custom constructor requiring mandatory fields
     * @param discountRate - the percent off
     * @param minQty - the minimum quantity to be eligible for the discount
     */
    public QtyDiscount(double discountRate, int minQty) {
        setDiscountRate(discountRate);
        setMinQty(minQty);
    }

    public final void setMinQty(int minQty) {
        //needs validation
        this.minQty = minQty;
    }

    public final int getMinQty() {
        return minQty;
    }

    
    /**
     * Determines whether a discount should be applied based on the quantity.
     * @param qty - quantity of product purchased
     * @param unitCost - original price of one item
     * @return discount amount (qty * unit cost * percent off) or zero if
     * not eligible for discount.
     */
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
