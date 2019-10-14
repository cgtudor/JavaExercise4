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
public class Customer {
    public String name;
    public double amount;
    public InvoicingAlgorithm algor;

    public Customer(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }
    
    public void setInvoicingAlgorithm(InvoicingAlgorithm alg)
    {
        this.algor = alg;
    }
    
    public String getInvoice()
    {
        return algor.getInvoice(name, amount);
    }
}
