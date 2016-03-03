/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package saa.discountstrategy;
import javax.swing.JOptionPane;
/**
 * An implementation of the OutputStrategy contract which sends output to
 * a GUI which simulates the video terminal on a real Cash Register.
 * @author Gladwin
 */
public  class GuiOutput implements OutputStrategy{
 
    /**
     * Outputs the receipt data to selected destination.
     * @param data - the data to output. NOTE: not currently validated!
     */
    @Override
    public final void output(String data) {
         // needs validation
        JOptionPane.showMessageDialog(null, data);
    }
    

   
}



