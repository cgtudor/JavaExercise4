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
public interface InvoicingAlgorithm {
    
    public String getInvoice(String cur, double amount);
    
}
