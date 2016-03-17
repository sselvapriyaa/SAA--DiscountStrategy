/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * A simulation of a LineItem on a Receipt.
 * @author  Gladwin
 */
public class LineItem {
    private Product product;
    private int qty;
    
    /**
     * Custom constructor uses required prodId and DatabaseStrategy to lookup
     * Product and store it along with quantity required by customer.
     * @param prodId
     * @param qty
     * @param db 
     */

    public LineItem(String prodId, int qty,DatabaseStrategy db) {
                setQty(qty);
                setProduct(db.findProductById(prodId));
                        
    }
      
    /**
     * Gets the extended price (subtotal) for this line item.
     * @return the quantity * unit cost
     */ 
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
       
    
    public final Product getProduct() {
        return product;
    }
   /**
    * * CAUTION: product is to be validated
    * @param product 
    */

    public final void setProduct(Product product) {
        //needs validation
        this.product = product;
    }

    public final int getQty() {
        return qty;
    }

    public final void setQty(int qty) {
        //needs validation
        this.qty = qty;
    }
    
    
}
