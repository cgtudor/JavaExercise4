/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uk.ac.tees.advanced.username;

import java.awt.Point;

/**
 *
 * @author v8002382
 */
public class Railgun {
    RailgunState state;
    int ammo;
    Point position;
    public final static int MAX_AMMO = 10;

    public Point getPosition() {
        return position;
    }
    public Railgun()
    {
        state = new NormalState();
        ammo = MAX_AMMO;
    }
    
    public String fire(Point p, int rounds)
    {
        return state.fire(ammo, rounds, this);
    }
    
    public String move(Point p)
    {
        return state.move(p, this);
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public RailgunState getState() {
        return state;
    }

    public int getAmmo() {
        return ammo;
    }

    public void setAmmo(int ammo) {
        this.ammo = ammo;
    }

    public void setState(RailgunState state) {
        this.state = state;
    }
}
