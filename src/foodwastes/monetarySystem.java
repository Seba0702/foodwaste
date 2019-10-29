/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodwastes;

/**
 *
 * @author svane
 */
public class monetarySystem {
    public String name;
    public double balance;
    
    public monetarySystem() {
        balance = 8000;
    }
    
    public void Buy (double price) { 
        balance = price-balance;
    }
        
    public double getBalance() {
        return balance;
    }
    
}
