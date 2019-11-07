package foodwastes;

public enum CommandWord
{
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), PICKUP("pickup"), BALANCE("balance"),
    DROP("drop"), INVENTORY("inventory"), SLEEP("sleep"), STATS("stats"), BUY("buy"), THROWOUT("throwout"),
    DONATE("donate"), EAT("eat");
    
    private String commandString;
    
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    public String toString()
    {
        return commandString;
    }
}
