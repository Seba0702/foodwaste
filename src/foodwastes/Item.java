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
    private double rottenHours=5;
    private boolean isRottenFood;

    public Item(String name, String description, int price, boolean buyable, boolean isFood)
    {
    
       this.description = description;
       this.name = name;      
       this.price = price;
       this.buyable = buyable;
       this.isFood = isFood;
       this.spoiled = spoiled;
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
    
    public void SetRottenHours()
    {
    if(this.isFood==true){
     
    }
    else{
       this.rottenHours=Double.POSITIVE_INFINITY;
    }   
    }
    public double getRottenHours()
    {
    return this.rottenHours;  
    }        

    public void setRottenHoursToMinusOne()
    {
      this.rottenHours-=1;
      
    }
    public void setStatusOfRottenHours()
    {
    this.isRottenFood=true;
    }
    
    public boolean getIsRottenFood()
    {
    return this.isRottenFood;
    }
    public void setRottenHoursToZero()
    {
    if(this.rottenHours==Double.POSITIVE_INFINITY)
    {
        
    }
     else
    {
     this.rottenHours=0;   
    }
    }
    
    @Override
    public String toString()
    {
    return name+" "+ "has "+this.rottenHours+" "+"hours"+" "+ "left"+" and the food is rotten if value is true"+" "+"("+this.isRottenFood+")";
    }     
}

