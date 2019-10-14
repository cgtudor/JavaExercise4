/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.basic.username;

/**
 *
 * @author v8002382
 */
public class EuropeanInvoice implements InvoicingAlgorithm{

    @Override
    public String getInvoice(String cur, double amount) {
        String lol = "--------------------------------------\n";
        lol += "TO:	" + cur + "\n";
        lol += "FROM:	Easyflap (UK)\n\n";
        lol += "AMOUNT:	"+'\u20AC' + String.format("%.2f", amount*1.14) + "\n";
        lol += "--------------------------------------";
        return lol;
    }
    
}