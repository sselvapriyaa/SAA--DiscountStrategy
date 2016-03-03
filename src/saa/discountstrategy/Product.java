/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * Simulates a real product in a POS system
 * @author Gladwin
 */
public class Product {
    private String prodId;
    private String prodName;
    private double unitCost;
    private DiscountStrategy discount;

    /**
     * Custom constructor validates all required information
     * @param prodId - unique id of product purchased
     * @param prodName - the name of the product
     * @param unitCost - the original price for sale of one item
     * @param discount - the discount strategy used for this product
     */
    public Product(String prodId, String prodName, double unitCost, DiscountStrategy discount) {
        setProdId(prodId);
        setProdName(prodName);
        setUnitCost(unitCost);
        setDiscount(discount);
    }

    public final String getProdId() {
        return prodId;
    }

    public final String getProdName() {
        return prodName;
    }

    public final double getUnitCost() {
        return unitCost;
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setProdId(String prodId) {
        //needs validation
        this.prodId = prodId;
    }

    public final void setProdName(String prodName) {
        //needs validation
        this.prodName = prodName;
    }

    public final void setUnitCost(double unitCost) {
        //needs validation
        this.unitCost = unitCost;
    }

    public final void setDiscount(DiscountStrategy discount) {
        //need validation
        this.discount = discount;
    }
    
}
