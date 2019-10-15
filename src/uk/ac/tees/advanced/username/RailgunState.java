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
public interface RailgunState {
    public String fire(int ammo, int requestedAmmo, Railgun railgun);
    public String move(Point point, Railgun railgun);
}
