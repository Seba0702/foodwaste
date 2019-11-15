package foodwastes;


public class Quests {
    
    private final Room destination;
    private final String description, success;
    private final int day;
    private boolean finished = false;
    private final Item object;
    
    
    public Quests(int day, String description, String success, Room destination, Item object )
    {
        this.day = day;
        this.description = description;
        this.destination = destination;    
        this.object = object;
        this.success = success;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public int getDay()
    {
        return day;
    }
    
    public Room getDestination()
    {
        return destination;
    }
    
    
    public Item getObject()
    {
        return object;
    }
    
    public boolean getFinished()
    {
        return finished;
    }
    
    public void setFinished(boolean status)
    {
        finished = status;
    }
    
    public String getSuccess()
    {
        return success;
    }
    
}
