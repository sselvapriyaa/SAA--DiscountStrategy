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
public class Register {

    private Receipt receipt;
    private String storeName;
    private ReceiptFormatStrategy fmt;
    private OutputStrategy[] outputs;

    public ReceiptFormatStrategy getFmt() {
        return fmt;
    }

    public void setFmt(ReceiptFormatStrategy fmt) {
        this.fmt = fmt;
    }

    public OutputStrategy[] getOutputs() {
        return outputs;
    }

    public void setOutputs(OutputStrategy[] outputs) {
        this.outputs = outputs;
    }

    public Register(String storeName) {
        this.storeName = storeName;
    }

    public final void startNewSale(String custId, DatabaseStrategy db,String storeName) {
        // needs validation
        receipt = new Receipt(custId, db,storeName);
        setReceipt(receipt);

    }

    public final void endSale() {
       receipt = getReceipt();
       String formattedData;
       ReceiptFormatStrategy fmt = new SimpleReceiptFormat();
       formattedData = fmt.format(receipt,storeName);
       OutputStrategy out = new ConsoleOutput();
       out.output(formattedData);
       
    }

    public final void addItemToSale(String prodId, int qty) {
        receipt.addItemToReceipt(prodId, qty);

    }

    public final Receipt getReceipt() {
        return receipt;
    }

    public final String getStoreName() {
        return storeName;
    }

    public final void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    public final void setStoreName(String storeName) {
        this.storeName = storeName;
    }

}
