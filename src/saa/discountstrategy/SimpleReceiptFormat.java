/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * This is a strategy implementation of the ReceiptFormatStrategy contract that
 * shows a very verbose line item that includes the discount on each item.
 * @author Gladwin
 */
public class SimpleReceiptFormat implements ReceiptFormatStrategy{
 @Override
    public String format(Receipt receipt, String storeName) {
            
  
        // Grand totals
        double totalBeforeDiscount = 0;
        double totalAfterDiscount = 0;
        double totalDiscount = 0;
        String store = storeName;
        double discount=0;
        
        // StringBuilder is just a more efficient way of doing lots of
        // String concatenation.
       StringBuilder sb = new StringBuilder();

        // NOTE: to avoid many magic number violations we have used constants
        // provided by the interface. This allows easy editing for all
        // implementing classes.

        // Header info on receipt
        sb.append(ReceiptFormatStrategy.RECEIPT_NUM)
                .append(Receipt.getReceiptNo());
        sb.append("\n\n").append(ReceiptFormatStrategy.THANK_YOU)
                .append(receipt.getCustomer().getCustName());
        sb.append("\n").append(SimpleReceiptFormat.FOR_SHOPPING_AT)
                .append(receipt.getStoreName())
                .append("\n");
        // line item info
        sb.append("\n\n").append(ReceiptFormatStrategy.ITEM_ID).append("\t")
                .append(ReceiptFormatStrategy.ITEM_NAME).append("\t\t\t")
                .append(ReceiptFormatStrategy.UNIT_COST).append("\t")
                .append(ReceiptFormatStrategy.QTY).append("\t")
                .append(ReceiptFormatStrategy.EXT_PRICE).append("\t");
                sb.append(ReceiptFormatStrategy.DISCOUNT_AMT);
                sb.append("\n---\t----\t\t\t---------\t---\t----------\t---------");

        LineItem[] items = receipt.getLineItems();
        for (LineItem item : items) {
            totalBeforeDiscount += item.getExtPrice();
            totalAfterDiscount += (item.getExtPrice() - item.getDiscountedTotal());
            totalDiscount += item.getDiscountedTotal();

            sb.append(String.format("\n%-8s",item.getProduct().getProdId()));
            sb.append(String.format("%-25s",item.getProduct().getProdName()));
            sb.append(String.format("%8.2f",item.getProduct().getUnitCost()));
            sb.append(String.format("%10d",item.getQty()));
            sb.append(String.format("%15.2f",item.getExtPrice()));
            sb.append(String.format("%12.2f",item.getDiscountedTotal()));
        }

        // display grand totals
        sb.append("\n\n\t\t\t\t\t\t").append(ReceiptFormatStrategy.GRAND_TOTALS)
                .append("\n");
        sb.append("\n\t\t\t\t\t\t").append(ReceiptFormatStrategy.TOT_BEFORE_DISCOUNT)
                .append(String.format("%9.2f",totalBeforeDiscount));
        sb.append("\n\t\t\t\t\t\t").append(ReceiptFormatStrategy.TOT_AFTER_DISCOUNT)
                .append(String.format("%10.2f",totalAfterDiscount));
        sb.append("\n\t\t\t\t\t\t").append(ReceiptFormatStrategy.AMT_SAVED)
                .append(String.format("%14.2f",totalDiscount));
       // sb.append(String.format("%12.2f",discount));

        return sb.toString();
    }
    
}
             
     

