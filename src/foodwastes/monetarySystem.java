package foodwastes;

public class monetarySystem {
    public double balance;
    
    public monetarySystem() {
        balance = 8000;
    }
    
    public void Buy (double price) { 
        balance = balance-price;
    }
        
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double amount)
    {
        balance += amount;
    }
    
}
