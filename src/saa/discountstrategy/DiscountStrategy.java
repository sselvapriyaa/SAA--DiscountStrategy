/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * The general contract for all discount strategy implementations.
 * @author Gladwin
 */
public interface DiscountStrategy {
    public abstract double getDiscountAmt(int qty,double unitCost);
    
}
