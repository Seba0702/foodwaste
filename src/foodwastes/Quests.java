package foodwastes;


public class Quests {
    
    private final Room roomOne, roomTwo;
    private final String description;
    private final int day;
    private boolean finished = false;
    
    
    public Quests(int day, String description, Room roomOne, Room roomTwo )
    {
        this.day = day;
        this.description = description;
        this.roomOne = roomOne;
        this.roomTwo = roomTwo;         
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public int getDay()
    {
        return day;
    }
    
    public Room getRoomOne()
    {
        return roomOne;
    }
    
    public Room getRoomTwo()
    {
        return roomTwo;
    }
    
    public boolean getFinished()
    {
        return finished;
    }
    
    public void setFinished(boolean status)
    {
        finished = status;
    }
    
    
}
