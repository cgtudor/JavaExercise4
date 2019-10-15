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
public class DamagedState implements RailgunState{

    @Override
    public String fire(int ammo, int requestedAmmo, Railgun railgun) {
        railgun.setAmmo(Math.abs(ammo - (requestedAmmo/2)));
        if(ammo > requestedAmmo/2)
        {
            return "Fire order: Partial success " + requestedAmmo/2 + "/" + requestedAmmo;
        }
        else if(ammo == requestedAmmo/2)
        {
            railgun.setState(new NeedAmmoState());
            return "Fire order: Partial success " + requestedAmmo/2 + "/" + requestedAmmo;
        }
        else
        {
            railgun.setState(new NeedAmmoState());
            return "Fire order: Partial success " + ammo + "/" + requestedAmmo;
        }
    }

    @Override
    public String move(Point point, Railgun railgun) {
        return "Move order: Failure";
    }
    
}
