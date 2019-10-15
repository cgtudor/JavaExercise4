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
public class NeedAmmoState implements RailgunState{

    @Override
    public String fire(int ammo, int requestedAmmo, Railgun railgun) {
        return "Fire order: Failure 0/" + requestedAmmo;
    }

    @Override
    public String move(Point point, Railgun railgun) {
        railgun.setPosition(point);
        if(point.x == 320 && point.y == 43)
        {
            railgun.setAmmo(Railgun.MAX_AMMO);
            railgun.setState(new NormalState());
        }
        return "Move order: Success";
    }
    
}
