/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * This class simulates the cash register at a department store like Kohls.
 * It's responsibility is to mediate between the startup class (where input 
 * is currently done) and the rest of the system. In the future it will be
 * the GUI that will talk to the Register.
 * 
 * Much of the work done by this class is delegated to other objects, many of
 * which are strategy objects. That makes this class a high-level class in the
 * DIP. Remember, you should delegate work to other objects for several reasons:
 * 1) Single Responsibility Principle, and 2) separate what varies from what
 * stays the same and create separate strategy objects that perform the
 * varying work.
 *
 * @author Gladwin
 */
public class Register {

    private Receipt receipt;
    private String storeName;
    private ReceiptFormatStrategy fmt;
    private OutputStrategy[] outputs;

   
    /**
     * Custom constructor initializes register with store name. 
     * @param storeName 
     */
    public Register(String storeName) {
        this.storeName = storeName;
    }

    /**
     * Start and configure a new sale. NOTE: currently no validation of
     * method arguments.
     * @param custId - the unique id of a customer
     * @param db - the persistence provider
     * @param fmt - the format of the final receipt
     * @param output - the destination of the receipt
     */
   public final void startNewSale(String custId, DatabaseStrategy db,ReceiptFormatStrategy fmt, OutputStrategy[] outputs) {
        // needs validation
        receipt = new Receipt(custId, db,storeName);
        setReceipt(receipt);
         setFmt(fmt);
        setOutputs(outputs);

    }
   
   
   /**
     * End the sale for a customer and causes a receipt to be output, 
     * possibly to multiple destinations.
     */
 public final void endSale() {
        receipt = getReceipt();
        ReceiptFormatStrategy fmt = new SimpleReceiptFormat();
        String formattedData = fmt.format(receipt,storeName);
        for(OutputStrategy out : outputs) {
            out.output(formattedData);
        }
    }
 
    /**
     * Adds an item to a sale order. NOTE: currently no validation of
     * method arguments.
     * @param prodId - the unique id of a product which simulates what a
     * bar code scanner would capture
     * @param qty - the number of this product being purchased
     */
    public final void addItemToSale(String prodId, int qty) {
        receipt.addItemToReceipt(prodId, qty);

    }
 ///// GETTERS/SETTERS DON'T NEED DOCS UNTIL VALIDATION CODE ADDED /////
    
    public final Receipt getReceipt() {
        return receipt;
    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setReceipt(Receipt receipt) {
        //needs validation
        this.receipt = receipt;
    }

    public final void setStoreName(String storeName) {
          //needs validation
        this.storeName = storeName;
    }
 public final ReceiptFormatStrategy getFmt() {
        return fmt;
    }

    public final void setFmt(ReceiptFormatStrategy fmt) {
        //needs validation
        this.fmt = fmt;
    }

    public final OutputStrategy[] getOutputs() {
        return outputs;
    }

    public final void setOutputs(OutputStrategy[] outputs) {
        //needs validation
        this.outputs = outputs;
    }

}
