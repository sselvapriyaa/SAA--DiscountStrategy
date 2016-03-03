/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;


/**
 * An implementation of the the OutputStrategy contract which simulates the 
 * printed paper receipt that comes out of a real Cash Register.
 *
 * @author Gladwin
 */
public class ConsoleOutput implements OutputStrategy {
 /**
     * Outputs the receipt data to selected destination.
     * @param data - the data to output. NOTE: not currently validated!
     */
    @Override
    public final void output(String data) {
        // needs validation
        System.out.println(data);
    

}
}