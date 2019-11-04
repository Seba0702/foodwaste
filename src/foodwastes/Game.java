package foodwastes;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Game 
{
    Time time = new Time();
    private String name;
    private Parser parser;
    private Room currentRoom;
    private Point currentPoints;   
    Characters p1 = new Characters();
    
    
    ArrayList<Item> inventory = new ArrayList();

    public Game() 
    {
        createRooms();       
        createPoints();
        parser = new Parser();
    }


    private void createRooms()
    {
        Room outside, apartment, kitchen, livingroom, bedroom, supermarked, McDonalds, loesMarket;
      
        outside = new Room("in the Streets of Copenhagen");
        apartment = new Room("in the entrance of your apartment");
        kitchen = new Room("in your kitchen");
        livingroom = new Room("in your living room");
        bedroom = new Room("in the bedroom");
        supermarked = new Room("in Fakta");
        McDonalds = new Room("at McDonalds");
        loesMarket = new Room("you have entered Loes-Market");
        
        outside.setExit("east", supermarked);
        outside.setExit("south", apartment);
        outside.setExit("west", McDonalds);
        outside.setExit("north", loesMarket);

        apartment.setExit("west", bedroom);
        apartment.setExit("north", outside);
        apartment.setExit("east", kitchen);
        apartment.setExit("south", livingroom);

        bedroom.setExit("west", apartment);
        bedroom.setExit("south", livingroom);
        
        livingroom.setExit("north", apartment);
        livingroom.setExit("east", bedroom);
        livingroom.setExit("west", kitchen);
        
        kitchen.setExit("west", apartment);
        kitchen.setExit("south", livingroom);
        
        supermarked.setExit("west", outside);
        
        McDonalds.setExit("east", outside);

        loesMarket.setExit("south", outside);

        currentRoom = outside;
        
        
        // Creating all the inventories for the rooms.
        
        ArrayList<Item> outsideItems = new ArrayList();
        ArrayList<Item> supermarkedItems = new ArrayList();
        ArrayList<Item> livingroomItems = new ArrayList();
        ArrayList<Item> kitchenItems = new ArrayList();
        ArrayList<Item> apartmentItems = new ArrayList();
        ArrayList<Item> bedroomItems = new ArrayList();
        ArrayList<Item> mcDonaldsItems = new ArrayList();
        ArrayList<Item> loesMarketItems = new ArrayList();
        
        
        // Adding items to the specific rooms
        
        Item trash, key, meat, milk, cake, rice, ryebread, cheeseburger, rice100g, diamond, gold;
        
        milk = new Item("Milk", "This is milk!", 14, true);
        trash = new Item("Trash", "This is trash!", 0, false);
        key = new Item("Key", "This is a key!", 0, false);
        meat = new Item("Meat", "This is meat!", 35, true);
        cake = new Item("Cake", "This is a whole cake!", 60, true);
        rice = new Item("Rice", "This is 500g of white rice!", 25, true);
        ryebread = new Item("Ryebread", "This is a loaf of ryebread", 25, true);
        cheeseburger = new Item("Cheeseburger", "This is a cheeseburger!", 10, true);
        rice100g = new Item("100g-Rice", "This is 100g of rice", 5, true);
        diamond = new Item("Diamond", "This is a diamond", 5000, true);
        gold = new Item("Gold", "This is 1kg of gold", 5000, true);
        
        outsideItems.add(trash);
        outsideItems.add(key);
        
        supermarkedItems.add(meat);
        supermarkedItems.add(milk);
        supermarkedItems.add(cake);
        supermarkedItems.add(rice);
        supermarkedItems.add(ryebread);
        supermarkedItems.add(milk);
        supermarkedItems.add(diamond);
        supermarkedItems.add(gold);
        
        mcDonaldsItems.add(cheeseburger);
        
        loesMarketItems.add(rice100g);
        
        outside.fillArray(outsideItems);
        supermarked.fillArray(supermarkedItems);
        kitchen.fillArray(kitchenItems);
        livingroom.fillArray(livingroomItems);
        apartment.fillArray(apartmentItems);
        bedroom.fillArray(bedroomItems);
        McDonalds.fillArray(mcDonaldsItems);
        loesMarket.fillArray(loesMarketItems);  
  
    }
    
    private void createPoints()
    {
      Point point = new Point();
      
      currentPoints = point;
      
    }
    public void givePoint()
    {
      Point point = new Point();
      
      
      point.getPoint();
      point.setPointPlusOne();
    }    
    public void play() 
    {            
        printWelcome();

                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private void printWelcome()
    {
        Scanner scan = new Scanner(System.in);
        /*
        System.out.println();
        System.out.println("Welcome to Food Waste!");
        System.out.println("What is your name?");
        name = scan.next();
        
        System.out.println("Hey " + name + ", that is a very cool name!");
        System.out.println("Ready to hear about the game? Yes or no?");
        String input = scan.next();
        
        String commandNo = "no";
        if("no".equals(input)) {
            System.out.println("Thank you for playing. Good bye.");
            System.exit(0);
        } 
        
        System.out.println("This is a  game about food waste as u might have guessed");
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }
        System.out.println("In this game you will try to experience how a common household creates food waste on a daily basis");
       
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }
        
        System.out.println("Seems like fun right?");
        String commandYesToContinue = scan.next();
        
        System.out.println("Type '" + CommandWord.HELP + "' if you need help during the game");
        System.out.println("You will start in the streets of Copenhagen"); 
        
        try {
            Thread.sleep(2000);
        }
        catch (InterruptedException ex)
        {
            // do nothing
        }
        
        System.out.println("Ready to start?");
        String commandYesToBegin = scan.next();
*/
        time.setDate(1, 16);
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
        System.out.println("It is day: "+time.getDateOfDays()+" the clock is "+time.getDateOfHours());
        listRoomItems();
    }

    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        if(commandWord == CommandWord.UNKNOWN) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        if (commandWord == CommandWord.HELP) {
            printHelp();
        }
        else if (commandWord == CommandWord.GO) {
            goRoom(command);
        }
        else if (commandWord == CommandWord.QUIT) {
            wantToQuit = quit(command);
        }
        else if (commandWord == CommandWord.PICKUP) {
            pickUp(command);
        }
        else if (commandWord == CommandWord.DROP) {
            dropItem(command);
        }
        else if (commandWord == CommandWord.INVENTORY) {
            checkInventory(command);
        }
        else if (commandWord == CommandWord.BALANCE) {
            getBalance(command);
        }
        else if (commandWord == CommandWord.STATS) {
            stats();
        }
        else if (commandWord == CommandWord.SLEEP) {
            sleep();
        }
        else if (commandWord == CommandWord.BUY) {
            buy(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    private void pickUp(Command command)
    {

       ArrayList<Item> itemsInCurrentRoom = currentRoom.getArray();

       String item = command.getSecondWord();      
       
       for(int i = 0 ; i < itemsInCurrentRoom.size() ; i++)
       {
           if(itemsInCurrentRoom.get(i).getName().equals(item))
           {
                
                Item currentItem = itemsInCurrentRoom.get(i);
                
                if(!currentItem.isBuyable())
                {
                    itemsInCurrentRoom.remove(currentItem); 
                    
                    inventory.add(currentItem);
                
                    System.out.println("You picked up some " + currentItem.getName());
                    currentRoom.fillArray(itemsInCurrentRoom);   
                    break;
                }
                else
                {
                    System.out.println("Don't try to steal!");
                    break;
                }    
           }
           else
           {
                System.out.println("There is no such item here");
                listRoomItems();
                break;
            }
        }  
    }
    
    private void stats() {

        System.out.println("\tHello " + name);
        //new
        System.out.println("\tYour HP is: " + p1.getHealth());
            
        if (p1.getHunger() > 50) {
            System.out.println("You are full! Your hunger percentage is: " + p1.getHunger());
        } else {
            System.out.println("You are hungry! Get something to eat. Your hunger percentage is: " + p1.getHunger());
        }
            
    }
    
    private void dropItem(Command command)
    {
        
        ArrayList<Item> itemsInCurrentRoom = currentRoom.getArray();
        
        String item = command.getSecondWord();
        
        for(int i = 0 ; i < inventory.size() ; i++)
        {
           if(inventory.get(i).getName().equals(item))
           {
                Item currentItem = inventory.get(i);
                
                inventory.remove(currentItem);
                itemsInCurrentRoom.add(currentItem);
                currentRoom.fillArray(itemsInCurrentRoom);
                System.out.println("You dropped some " + item);
                break;
            }
           else
           {
               System.out.println("No such item was found in your inventory. Check your inventory with 'inventory'.");
               break;
           }
        }
    }
     
    private void buy(Command command)
    {
     
        ArrayList<Item> itemsInCurrentRoom = currentRoom.getArray();
        
        String item = command.getSecondWord();
        
        for(int i = 0 ; i < itemsInCurrentRoom.size() ; i++)
        {
            if(itemsInCurrentRoom.get(i).getName().equals(item))
            {
                Item currentItem = itemsInCurrentRoom.get(i);
                if(currentItem.isBuyable())
                {
                    if(m1.getBalance() >= currentItem.getPrice())
                    {
                    
                        itemsInCurrentRoom.remove(currentItem); 
                        inventory.add(currentItem);
                        m1.Buy(currentItem.getPrice());
                        System.out.println("You just bought: " + item + ". It cost you: "+ currentItem.getPrice() );
                        getBalance(command);
                        currentItem.setBuyable(false);
                    }
                    else
                    {
                        System.out.println("You do not have enough money for this item. The item cost: " + currentItem.getPrice() + "kr. and you only have: "+ m1.getBalance()+"kr.");
                    }          
                }
                else
                {
                    System.out.print("The item is not for sale");
                }
            } 
            else
            {
                System.out.println("There is no such item here!");
                break;
            }
        }
    } 
    
    private void checkInventory(Command command)
    { 
        if(!inventory.isEmpty())
        {
            System.out.println("These items are in your inventory: ");
            System.out.println( "[");
            for(int j=0; j < inventory.size(); j++)
            {
                System.out.println(  inventory.get(j).getName() + "," );
            }
            
            System.out.println( "]");
        }
        else
        {
            System.out.println("Your inventory is emty");
        }
    }
    
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else if(time.getDateOfHours()==0){
            
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription()+"It is day: "+time.getDateOfDays()+" the clock is "+time.getDateOfHours());
            listRoomItems();
            
        } else {  
            
            time.swichHour();
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription()+"It is day: "+time.getDateOfDays()+" the clock is "+time.getDateOfHours());
            listRoomItems();
                    }
        
    }
    
    private void listRoomItems()
    {
        
            ArrayList<Item> itemsInCurrentRoom = currentRoom.getArray();
            
            if(!itemsInCurrentRoom.isEmpty())
            {
                System.out.println( "[");
                for(int j=0; j < itemsInCurrentRoom.size(); j++)
                    {
                        if(itemsInCurrentRoom.get(j).isBuyable() == true)
                        {
                            System.out.println( itemsInCurrentRoom.get(j).getName() + " | " + itemsInCurrentRoom.get(j).getPrice() + "kr." );
                        }
                        else
                        {
                            System.out.println( itemsInCurrentRoom.get(j).getName() );
                        }
                        
                    }
                System.out.println( "]");  
            }
            else
            {
                System.out.println("There are no items in this room");
            }
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;
        }
    }

    private void sleep(){
     if("in the bedroom".equals(currentRoom.getShortDescription()))
     {
      time.swichDayWithBed();
         System.out.println(currentRoom.getLongDescription()+" "+"you had sleep"+"The time is"+"now"+" "+time.getDateOfDays()+" "+"the clock is"+" "+time.getDateOfHours());   
         time.checkForDaysQuitGame();
     }  else if(("in the bedroom"!=(currentRoom.getShortDescription()))) {
        time.swichDayOutsideOfBedroom();
        System.out.println(currentRoom.getLongDescription()+" "+"you had sleep"+"The time is"+"now"+" "+time.getDateOfDays()+" "+"the clock is"+" "+time.getDateOfHours());
        System.out.println("It is better to sleep inside your bedroom");
        time.checkForDaysQuitGame();
     }
                 
         
        
    }
    
    monetarySystem m1 = new monetarySystem();
    
    public void getBalance(Command command) {
        System.out.println("You have " + m1.balance + " kr. left in your account");
    }
}


