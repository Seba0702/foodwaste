/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwastes;

import java.util.Timer;
import java.util.TimerTask;



/**
 *
 * @author Cavra
 */
public class Characters {
    public int health;
    public int hunger;
    public int damage;
    public int minHealth;
    
    public Characters() {
        health = 100;
        hunger = 40;
        damage = 50;
        minHealth = 0;
    }
    
    public boolean alive() {
        return health > 0;
    }
    
    public boolean dead() {
        if(health <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getHunger() {
        return hunger;
    }
    
    public void subHealth() {
        health = health - damage;
        
    }

    public void subHunger() {
        hunger = hunger - damage;
    }
    
}
