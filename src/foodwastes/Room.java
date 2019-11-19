package foodwastes;

import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ArrayList;

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;
    private boolean unlocked;
    ArrayList<Item> items = new ArrayList();

    public Room(String description, boolean unlocked) 
    {
        this.description = description;
        this.unlocked = unlocked;
        
        exits = new HashMap<String, Room>();
        
        
    }
    
   public boolean isUnlocked()
   {
       return unlocked;
   }
   
    public void setUnlocked(boolean status)
    {
       unlocked = status;
    }
    
    public void fillArray(ArrayList<Item> items)
    {
        this.items = items;    
    }
    
    public ArrayList<Item> getArray()
    {
        return items;  
    }
    
    public void removeItem(Item item)
    {
        items.remove(item);
        
        
    }

    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    public String getShortDescription()
    {
        return description;
    }

    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
}

