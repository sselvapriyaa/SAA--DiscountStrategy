/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;

/**
 * This is the startup class for the application. It's responsibilities are
 * to configure the application and to create and interact with the Register, and to
 * provide input for a sale. In a real application there would be other ways to
 * provide input (a GUI, e.g.). But for now we'll just hard code the input
 * here. Note that this violates the Single Responsibility Principal because 
 * it is not the job of a startup class to do input. However, we'll allow
 * this now until we learn how to build a proper GUI later. 
 * 
 * The initialization code introduces some unwanted dependencies, but those will 
 * be removed in the future when we learn a new technique called dependency 
 * injection. For now we'll have to accept these dependencies in the spirit of
 * configuration requirements.
 * @author Gladwin
 */
public class SAADiscountStrategy {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /////////////////////////////////////////////////////////////////
        // KLUDGE: do configuration here for strategy options:
        /////////////////////////////////////////////////////////////////
       
       DatabaseStrategy db=new FakeDatabase();
       String storeName="Kohls Department Store";
               
  
        ReceiptFormatStrategy fmt = new SimpleReceiptFormat();
            OutputStrategy[] outputs = {
            new ConsoleOutput(),
            new GuiOutput()
        };
       // Start talking to objects, pass configuraiton data and customer
        // data to start sale. Notice how we do NOT depend on any other
        // classes -- Principal of Least Knowledge
       
       Register register =new Register("Kohls Department Store");
        register.startNewSale("100", db,fmt,outputs);
        register.addItemToSale("11", 2);
        register.addItemToSale("22", 1);
        register.addItemToSale("33", 3);
           
        register.endSale();
    
         
    
    }
}

