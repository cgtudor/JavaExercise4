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
public class NormalState implements RailgunState{

    @Override
    public String move(Point point, Railgun railgun) {
        railgun.setPosition(point);
        if(point.x == 320 && point.y == 43)
            railgun.setAmmo(Railgun.MAX_AMMO);
        return "Move order: Success";
    }

    @Override
    public String fire(int ammo, int requestedAmmo, Railgun railgun) {
        railgun.setAmmo(Math.abs(ammo - requestedAmmo));
        if(ammo > requestedAmmo)
        {
            return "Fire order: Success " + requestedAmmo + "/" + requestedAmmo;
        }
        else if(ammo == requestedAmmo)
        {
            railgun.setState(new NeedAmmoState());
            return "Fire order: Success " + requestedAmmo + "/" + requestedAmmo;
        }
        else
        {
            railgun.setState(new NeedAmmoState());
            return "Fire order: Partial success " + ammo + "/" + requestedAmmo;
        }
    }
    
}
