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
public class Product {
    private String prodId;
    private String prodName;
    private double unitCost;
    private DiscountStrategy discount;

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

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public final void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public final void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public final void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    
}
