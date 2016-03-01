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
public class LineItem {
    private Product product;
    private int qty;

    public LineItem(String prodId, int qty,DatabaseStrategy db) {
                this.qty = qty;
                setProduct(db.findProductById(prodId));
                        
    }
       
     public final double getExtPrice() {
        return qty * product.getUnitCost();
    }
    
    /**
     * Gets the discounted total for this line item
     * @return discounted total for this line item
     */
    public final double getDiscountedTotal() {
        return product.getDiscount().getDiscountAmt(qty, product.getUnitCost());
    }
       
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    
}
