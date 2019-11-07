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
    Point point = new Point();  
    
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
        
        milk = new Item("milk", "This is milk!", 14, true, true);
        trash = new Item("trash", "This is trash!", 0, false, false);
        key = new Item("key", "This is a key!", 0, false, false);
        meat = new Item("meat", "This is meat!", 35, true, true);
        cake = new Item("cake", "This is a whole cake!", 60, true, true);
        rice = new Item("rice", "This is 500g of white rice!", 25, true, true);
        ryebread = new Item("ryebread", "This is a loaf of ryebread", 25, true, true);
        cheeseburger = new Item("cheeseburger", "This is a cheeseburger!", 10, true, true);
        rice100g = new Item("100g-Rice", "This is 100g of rice", 5, true, true);
        diamond = new Item("diamond", "This is a diamond", 5000, true, false);
        gold = new Item("gold", "This is 1kg of gold", 5000, true, false);
        
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
        else if (commandWord == CommandWord.THROWOUT) {
            throwout(command);
        }
        else if (commandWord == CommandWord.DONATE) {
            donate(command);
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    private void throwout(Command command) {
        
        String item = command.getSecondWord();

        for (Item var : inventory) {
            
            if (!var.getName().equals(item)) continue;

            if (!currentRoom.getShortDescription().equals("in your kitchen")) 
            {
                System.out.println("You are not in your kitchen");
                return;
            }
            
            if (!var.isFood())
            {
                System.out.println("You just threw some " + var.getName() + " out");
                return;    
            }
            
            if (var.getSpoiledStatus())
            {
                point.setMinusPoint(5);
                System.out.println("You just lost 10 points, because you threw something spoiled in the trash.");
                inventory.remove(var);
                return;
            } 
            else 
            {
                point.setMinusPoint(10);
                System.out.println("You just lost 10 points, because you threw something ediable in the trash.");
                inventory.remove(var);
                return;
            } 
        }
        System.out.println("There is no such item in your inventory");
    }
    
    private void donate(Command command) {
        
        String item = command.getSecondWord();

        for (Item var : inventory) 
        {
            
            if (!var.getName().equals(item)) continue;
            
            if (!var.isFood())
            {
                System.out.println("This is not food!");
                return;
            }

            if (var.getSpoiledStatus()) 
            {
                System.out.println("You can't donate spoiled food.. You should just throw the spoiled food in the trash.");
                inventory.remove(var);
                return;
            } 
            else 
            {
                point.setPlusPoint(10);
                System.out.println("Thanks! You just donated some " + var.getName() + " to the foodbank. The food will now be used to feed people in need!");
                inventory.remove(var);
                return;
            }
        }
        
        System.out.println("There is no such item here");
    }
    
    private void pickUp(Command command)
    {
        String item = command.getSecondWord();      

        for (Item var : currentRoom.items)
        {
            if(!var.getName().equals(item)) continue;
            
            if(!var.isBuyable())
            {
                inventory.add(var);
                currentRoom.items.remove(var);
                System.out.println("You picked up some "+ var.getName());
                return;
            }
            else
            {
                System.out.println("Do not try to steal!");
                return;
            }
        } 
        System.out.println("There is no such item here");       
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
        String item = command.getSecondWord();
        
        for (Item var : inventory)
        {
        
            if(!var.getName().equals(item)) continue;
            
            inventory.remove(var);
            currentRoom.items.add(var);
            System.out.println("You dropped some " + item);
            return;
        }
        
        System.out.println("No such item was found in your inventory. Check your inventory with 'inventory'."); 
    }
     
    
    
    private void buy(Command command)
    {
        String item = command.getSecondWord();
        
        for (Item var : currentRoom.items) {
            if (!var.getName().equals(item)) continue;
            
            if (!var.isBuyable()) {
                System.out.print("The item is not for sale");
                return;
            }
            
            if (m1.getBalance() < var.getPrice()) {
                System.out.println("You do not have enough money for this item. The item cost: " + var.getPrice()
                        + "kr. and you only have: "+ m1.getBalance()+"kr.");
                return;
            }
            
            currentRoom.items.remove(var);
            m1.Buy(var.getPrice());
            inventory.add(var);
            var.setBuyable(false); 
            System.out.println("You just bought: " + item + ". It cost you: "+ var.getPrice() );
            getBalance(command);
            
            return;
        }
   
        System.out.println("This item could not be found");
    } 
    
    private void checkInventory(Command command)
    { 
 
        if(inventory.isEmpty())
        {
            System.out.println("Your inventory is empty");
            return;
        }
       
        System.out.println("These items are in your inventory: ");
        System.out.println( "[");
            
        for (Item var : inventory)
        {
            if (var.isFood() & var.getSpoiledStatus()) 
            {
                System.out.println(var.getName() + " | Spoiled");
                continue;
            } 
            else if (var.isFood() & !var.getSpoiledStatus())
            {
                System.out.println(var.getName() + " | Not Spoiled");
                continue;
            }
            
            System.out.println(var.getName());        
        }
        
        System.out.println( "]"); 
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
            p1.subHealth();
            
        } else {  
            
            time.swichHour();
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription()+"It is day: "+time.getDateOfDays()+" the clock is "+time.getDateOfHours());
            listRoomItems();
            p1.subHealth();
            
        }
        
        if(0 >= p1.health) 
        {
            System.out.println("You died");
            System.out.println("HP: " + p1.getHealth());
            System.out.println("Hunger: " + p1.getHunger());
            System.exit(0);
            
        }
        
    }
    
    private void listRoomItems() {

        if (currentRoom.items.isEmpty())
        {
            System.out.println("This room has no items");
            return;
        }
        
        System.out.println("[");

        for (Item var : currentRoom.items) 
        {
            if (var.isBuyable()) 
            {
                System.out.println(var.getName() + " | " + var.getPrice() + "kr.");
                continue;
            }

            if (var.isFood() & var.getSpoiledStatus()) 
            {
                System.out.println(var.getName() + " | Spoiled");
                continue;
            } 
            else if (var.isFood() & !var.getSpoiledStatus())
            {
                System.out.println(var.getName() + " | Not Spoiled");
                continue;
            }
            
            System.out.println(var.getName());
        }

        System.out.println("]");
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

    private void sleep() {
        if ("in the bedroom".equals(currentRoom.getShortDescription()))
        {
            time.swichDayWithBed();
            System.out.println(currentRoom.getLongDescription() + " " + "you had sleep" + "The time is" + "now" + " " + time.getDateOfDays() + " " + "the clock is" + " " + time.getDateOfHours());
            time.checkForDaysQuitGame();
        } 
        else if (("in the bedroom" != (currentRoom.getShortDescription()))) 
        {
            time.swichDayOutsideOfBedroom();
            System.out.println(currentRoom.getLongDescription() + " " + "you had sleep" + "The time is" + "now" + " " + time.getDateOfDays() + " " + "the clock is" + " " + time.getDateOfHours());
            System.out.println("It is better to sleep inside your bedroom");
            time.checkForDaysQuitGame();
        }
                 
         
        
    }
    
    monetarySystem m1 = new monetarySystem();
    
    public void getBalance(Command command) {
        System.out.println("You have " + m1.getBalance() + " kr. left in your account");
    }
}


