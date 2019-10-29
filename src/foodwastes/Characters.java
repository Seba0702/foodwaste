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
    private int health;
    private int hunger;
    private String name;
    
    public Characters(int health, int hunger) {
        this.health = health;
        this.hunger = hunger;
//        this.name = name;
        
    }
    
    public int getHealth() {
        return health;
    }
    
/*    public void setplayerName(String name) {
        this.name = name;
    }*/
    
    public String getplayerName() {
        return name;
    }
    
    public int getHunger() {
        return hunger;
    }
    
}
