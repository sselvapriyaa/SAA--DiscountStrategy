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
public interface ReceiptFormatStrategy {
    public final static String RECEIPT_NUM = "Receipt No.: ";
    public final static String THANK_YOU = "Thank you ";
    public final static String FOR_SHOPPING_AT = "for Shopping at ";
    public final static String ITEM_ID = "ID";
    public final static String ITEM_NAME = "Item";
    public final static String UNIT_COST = "Unit Cost";
    public final static String QTY = "Qty";
    public final static String EXT_PRICE = "Ext. Price";
    public final static String DISCOUNT_AMT = "Discount";
    public final static String GRAND_TOTALS = "Grand Totals:";
    public final static String TOT_BEFORE_DISCOUNT = "Total Before Discount: ";
    public final static String TOT_AFTER_DISCOUNT = "Total After Discount: ";
    public final static String AMT_SAVED = "Total Saved Today: ";
    public String store = null;
    
    
    public abstract String format(Receipt receipt,String storeName);
}
