package foodwastes;

import java.util.Scanner;
import java.util.ArrayList;

public class Game 
{
    Time time = new Time();
    private String name;
    private Parser parser;
    private Room currentRoom;
    
    Characters p1 = new Characters();
    Point point = new Point();
    Smartphone ph = new Smartphone();
    monetarySystem m1 = new monetarySystem();
    
    
    ArrayList<Item> inventory = new ArrayList();
    ArrayList<Quests> questList = new ArrayList();

    public Game() 
    {
        createRooms();       
        createPoints();
        parser = new Parser();
    }
    

    private void createRooms()
    {
        Room outside, apartment, kitchen, livingroom, bedroom, supermarked, McDonalds, loesMarket;
      
        outside = new Room("in the Streets of Copenhagen", true);
        apartment = new Room("in the entrance of your apartment", false);
        kitchen = new Room("in your kitchen", true);
        livingroom = new Room("in your living room", true);
        bedroom = new Room("in the bedroom", true);
        supermarked = new Room("in Fakta", true);
        McDonalds = new Room("at McDonalds", true);
        loesMarket = new Room("you have entered Loes-Market", true);
        
        outside.setExit("fakta", supermarked);
        outside.setExit("apartment", apartment);
        outside.setExit("mcdonalds", McDonalds);
        outside.setExit("naturmarket", loesMarket);

        apartment.setExit("bedroom", bedroom);
        apartment.setExit("outside", outside);
        apartment.setExit("kitchen", kitchen);
        apartment.setExit("livingroom", livingroom);

        bedroom.setExit("apartment", apartment);
        bedroom.setExit("livingroom", livingroom);
        
        livingroom.setExit("apartment", apartment);
        livingroom.setExit("bedroom", bedroom);
        livingroom.setExit("Kitchen", kitchen);
        
        kitchen.setExit("apartment", apartment);
        kitchen.setExit("livingroom", livingroom);
        
        supermarked.setExit("outside", outside);
        
        McDonalds.setExit("outside", outside);

        loesMarket.setExit("outside", outside);

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
        
        Item meat, milk, cake, rice, ryebread, cheeseburger, rice100g, burger, chickennuggets, key;
        
        milk = new Item("milk", "This is milk!", 14, true, true, 20);
        meat = new Item("meat", "This is meat!", 35, true, true, 30);
        cake = new Item("cake", "This is a whole cake!", 60, true, true, 50);
        rice = new Item("rice", "This is 500g of white rice!", 25, true, true, 50);
        ryebread = new Item("ryebread", "This is a loaf of ryebread", 25, true, true, 25);
        cheeseburger = new Item("cheeseburger", "This is a cheeseburger!", 10, true, true, 30);
        rice100g = new Item("100g-Rice", "This is 100g of rice", 5, true, true, 10 );
        burger = new Item("burger", "This is a burger!", 10, true, true, 28);
        chickennuggets = new Item("chickennuggets", "These are chicken nuggets", 25, true, true, 40);
        
        key = new Item("key", "This is your apartment key", 0, false, false, 0);

        outsideItems.add(key);
       
        supermarkedItems.add(meat);
        supermarkedItems.add(milk);
        supermarkedItems.add(cake);
        supermarkedItems.add(rice);
        supermarkedItems.add(ryebread);

        
        mcDonaldsItems.add(cheeseburger);
        mcDonaldsItems.add(burger);
        mcDonaldsItems.add(chickennuggets);
        
        loesMarketItems.add(rice100g);
        
        outside.fillArray(outsideItems);
        supermarked.fillArray(supermarkedItems);
        kitchen.fillArray(kitchenItems);
        livingroom.fillArray(livingroomItems);
        apartment.fillArray(apartmentItems);
        bedroom.fillArray(bedroomItems);
        McDonalds.fillArray(mcDonaldsItems);
        loesMarket.fillArray(loesMarketItems);  
        
        // Create Quests
        
        Quests questOne = new Quests( 1, "You need to pickup the key outside your apartment, and unlock your house door!", "You just unlocked your front door ", outside, key);
       
        questList.add(questOne);
         
    }
    
    
    
    private void createPoints()
    {
      Point point = new Point();
      
      
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
        /*
        Scanner scan = new Scanner(System.in);
        
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
        else if (commandWord == CommandWord.EAT) {
            eat(command);
        }
        else if (commandWord == CommandWord.DRINK) {
            eat(command);
        }
        else if (commandWord == CommandWord.USE) {
            useItem(command);
        } 
        else if (commandWord == CommandWord.PHONE) {
            phone();
        }
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    private void eat(Command command) 
    {
        String item = command.getSecondWord();
        
        for (Item var : inventory)
        {

            
            if (var.getName().equals(item) && var.isFood())
            {
                
                if (var.getSpoiledStatus())
                {
                    System.out.println("");
                    System.out.println("You just ate spoiled food, and lost 10 hp");
                    System.out.println("");
                    p1.setHealth(10);
                    inventory.remove(var);
                    return;
                }
                else
                {
                    if ((p1.hunger + var.getNutrition()) >= 100 )
                    {
                        inventory.remove(var);   
                        System.out.println("");
                        System.out.println("You just ate a " + var.getName() + " and refilled your hunger by " + var.getNutrition());
                        System.out.println("You are now more than full, and wasted " + (p1.hunger + var.getNutrition() - 100) + " nutrition" );
                        p1.hunger = 100;
                        System.out.println("Your hunger is now at: " + p1.getHunger());
                        System.out.println("");
                        System.out.println("Over eating is one of the leading causes of food waste. Try to only eat as much food as you need.");
                        
                        return;
                    }
                    else
                    {
                        inventory.remove(var);
                        p1.hunger += var.getNutrition();
                        System.out.println("You just ate a " + var.getName() + " and refilled your hunger by " + var.getNutrition());
                        System.out.println("Your hunger is now at: " + p1.getHunger());
                        return;
                    }
                   
                }    
            }
        }
        
        System.out.print("This item is not in your inventory.");
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
     
    private void useItem(Command command)
    {
        String item = command.getSecondWord();
        
        if (inventory.isEmpty())
        {
            System.out.print("Your inventory is empty.");
            return;
        }
        
        for (Item var : inventory )
        {
            if (!var.getName().equals(item)) continue;
          
            for (Quests quest : questList)
            {
                if (!quest.getObject().equals(var) || quest.getDay() != time.getDateOfDays() )
                {
                    System.out.println("This item cannot be used");
                    continue;
                }
    
                if (quest.getDestination() == currentRoom)
                {
                    System.out.println(quest.getSuccess());
                    inventory.remove(var);
                    quest.setFinished(true);
                   
                    
                    switch (quest.getDay())
                    {
                        case 1:
                            unlockApartment();
                            break;
                        case 2:
                            
                            break;
                        case 3:
                            
                            break;
                        case 4:
                            
                            break;
                        case 5:
                            
                            break;
                        case 6:
                            
                            break;
                        case 7:
                            
                            break;
                        default:
                            
                            break;
                    }
                   
                    return;                  
                } 
            }   
        }     
    }
    
    private void unlockApartment()
    {
        Room nextRoom = currentRoom.getExit("apartment");
        nextRoom.setUnlocked(true);
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
                System.out.println(var.getName() + " | " + var.getHoursToRot() + " Hours left to spoil.");
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
            return;
        }
        
        if (nextRoom.isUnlocked() == false)
        {
            System.out.println("The door is locked. You need to find a way to open it");
            return;
        }
        
        if(time.getDateOfHours()==0)
        {
            System.out.print("You should use 'sleep' as you are too tired to go anywhere.");   
            return;
        } 
        else 
        {   
            for (Item p : inventory) {
                
                if (!p.isFood()) continue;
               
                
                if (p.getHoursToRot() == 0)
                {
                    p.setSpoilStatus(true);
                } 
                else
                {
                    p.setRotHoursMinus(1.00);
                } 
            }
            
            for (Item p : currentRoom.items) {
                
                if (!p.isFood()) continue;
               
                
                if (p.getHoursToRot() == 0)
                {
                    p.setSpoilStatus(true);
                } 
                else
                {
                    p.setRotHoursMinus(1.00);
                } 
            }
            
            
            
            time.swichHour();
            currentRoom = nextRoom;
            System.out.println("");
            System.out.println(currentRoom.getLongDescription());
            System.out.println("It is day: "+time.getDateOfDays()+" the clock is "+time.getDateOfHours());
            listRoomItems();
            System.out.println("");
            p1.subHunger();  
            
            for (Quests var : questList)
            {
                if (var.getDay() != time.getDateOfDays() || var.getFinished()) continue;
                
                ph.setNotifications(var.getDescription());
                //System.out.println("Quest: " + var.getDescription());    
            }
            
            
            if(p1.getHunger() <= 30)
            {
                System.out.println("You are now starting to take damage because you are very hungry");
                p1.subHealth();
            }
        }
        
        if(0 >= p1.health) 
        {          
            System.out.println("You died");
            System.out.println("HP: " + p1.getHealth());
            System.out.println("Hunger: " + p1.getHunger());
            System.out.println("Score: " + point.getPoint());
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
                System.out.println(var.getName() + " | " + var.getHoursToRot() + " Hours left to spoil.");
                continue;
            }
            
            System.out.println(var.getName());
        }

        System.out.println("]");
    }

    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("Quit what?");
            return false;
        }
        else 
        {
            return true;
        }
    }

    private void sleep() {
        if ("in the bedroom".equals(currentRoom.getShortDescription()))
        {       
            time.swichDayWithBed();
            System.out.println("You just slept " + currentRoom.getShortDescription() + ". You had 6 hours of sleep. It is now day: " + time.getDateOfDays() + " and the clock is " + time.getDateOfHours());
            time.checkForDaysQuitGame();
        } 
        else  
        {
            time.swichDayOutsideOfBedroom();
            System.out.println("You just slept " + currentRoom.getShortDescription() + ". You had 16 hours of sleep. It is now day: " + time.getDateOfDays() + " and the clock is " + time.getDateOfHours());
            System.out.println("It is better to sleep inside your bedroom");
            time.checkForDaysQuitGame();
        }
   
    }
    private void phone() {
        ph.phoneMode = true;
        ph.onPhone();
    }
    public void getBalance(Command command) {
        
        System.out.println("You have " + m1.getBalance() + " kr. left in your account");
    }
}


