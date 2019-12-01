package foodwastes;

public class Events {
    
    private final String description;
    private boolean isFinished = false;
    private final double minusBalance;
    
    
    public Events(String description, double minusBalance)
    {
        this.description = description;
        this.minusBalance = minusBalance;
        
    }
    
    public void setEventTrue()
    {
        isFinished = true;
    }
    
    public boolean getIsFinished()
    {
        return isFinished;
    }
            
    public void printDescription()
    {
        System.out.println(description);
    }
    
    public double getPenalty()
    {
        return minusBalance;
    }
    
}
