/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.standard.username;

/**
 *
 * @author v8002382
 */
public class FlightUpgrade extends Flight{
    protected Flight f;
    public FlightUpgrade(Flight f)
    {
        this.f = f;
    }
    
    @Override
    public double getCost()
    {
        return f.getCost() + price;
    }
}
