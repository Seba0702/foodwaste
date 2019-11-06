package foodwastes;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Item {
    
    private String name;
    private String description;
    private boolean spoiled, buyable;
    private int price;
    private boolean isFood;
    

    
    public Item(String name, String description, int price, boolean buyable, boolean isFood)
    {
    
       this.description = description;
       this.name = name;      
       this.price = price;
       this.buyable = buyable;
       this.isFood = isFood;
    }
    
    public boolean isBuyable()
    {
        return buyable;
    }
    
    public void setBuyable(boolean status)
    {
        buyable = status;
    }
    
    public boolean isFood()
    {
        return isFood;
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public boolean getSpoiledStatus()
    {
        return spoiled;
    }
    
    public void setSpoilStatus(boolean status)
    {
        this.spoiled = status;
    }
    
    public int getPrice()
    {
        return price;
    }
    
   
}
