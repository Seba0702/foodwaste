/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwastes;

/**
 *
 * @author Cavra
 */
public class Characters {
    public int health;
    public int hunger;
    public int loseHealth;
    
    public Characters() {
        health = 100;
        hunger = 100;
        loseHealth = 10;
    }
    
    public int getHealth() {
        return health;
    }
    
    public int getHunger() {
        return hunger;
    }
    
    public void whenHungry() {
        while(hunger < 50) {
            System.out.println("You are hungry! Make sure to get something to eat");
            
        }
    }
    
    public void subHealth() {
        health = health - loseHealth;
        while(1 > health) {
            System.out.println("You died.");
            break;
        }
        
    }

    public void subHunger() {
        hunger = hunger - loseHealth;
    }
    
/*    public void dead() {
        while(0 > health) {
            System.out.println("\tYou died.");
            break;
            
        }
    }*/
}
