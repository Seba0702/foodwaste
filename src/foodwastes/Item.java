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
    

    
    public Item(String name, String description, int price, boolean buyable)
    {
    
       this.description = description;
       this.name = name;      
       this.price = price;
       this.buyable = buyable;
    }
    
    public boolean isBuyable()
    {
        return buyable;
    }
    
    public void setBuyable(boolean status)
    {
        buyable = status;
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
