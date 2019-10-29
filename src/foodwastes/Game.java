package foodwastes;

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Point currentPoints;   
    ArrayList<String> inventory = new ArrayList<String>();

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
        apartment.setExit("south", outside);
        apartment.setExit("east", kitchen);
        apartment.setExit("north", livingroom);

        bedroom.setExit("south", apartment);
        bedroom.setExit("east", livingroom);
        
        livingroom.setExit("south", apartment);
        livingroom.setExit("west", bedroom);
        livingroom.setExit("east", kitchen);
        
        kitchen.setExit("south", apartment);
        kitchen.setExit("west", livingroom);
        
        supermarked.setExit("south", outside);
        
        McDonalds.setExit("south", outside);

        loesMarket.setExit("south", outside);
        

        currentRoom = outside;
        
        
        
        // Creating all the inventories for the rooms.
        
        ArrayList<String> outsideItems = new ArrayList<String>();
        ArrayList<String> supermarkedItems = new ArrayList<String>();
        ArrayList<String> livingroomItems = new ArrayList<String>();
        ArrayList<String> kitchenItems = new ArrayList<String>();
        ArrayList<String> apartmentItems = new ArrayList<String>();
        ArrayList<String> bedroomItems = new ArrayList<String>();
        ArrayList<String> mcDonaldsItems = new ArrayList<String>();
        ArrayList<String> loesMarketItems = new ArrayList<String>();
        
        
        // Adding items to the specific rooms
        
        outsideItems.add("trash");
        outsideItems.add("key");
        
        kitchenItems.add("Apple");
        kitchenItems.add("Pie");
        
        
        // Sending those items to all the room instances. 
        
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
        
        System.out.println();
        System.out.println("Welcome to Food Waste!");
        System.out.println("What is your name?");
        String name = scan.next();
        
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
        
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
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
        return wantToQuit;
    }

    private void printHelp() 
    {
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    private void pickUp(Command command)
    {
    
       ArrayList<String> itemsInCurrentRoom = currentRoom.getArray();

       String item = command.getSecondWord();
       
       
       if(itemsInCurrentRoom.contains(item))
       {
            itemsInCurrentRoom.remove(item); 
                    
            inventory.add(item);
            System.out.println("You picked up some " + item);
            currentRoom.fillArray(itemsInCurrentRoom);   
        } 
        else
        {
            listRoomItems();
        } 
       
    }
    
    private void dropItem(Command command)
    {
    
        ArrayList<String> itemsInCurrentRoom = currentRoom.getArray();
        
        String item = command.getSecondWord();
        
        if(inventory.contains(item))
        {
            inventory.remove(item);
            itemsInCurrentRoom.add(item);
            currentRoom.fillArray(itemsInCurrentRoom);
            System.out.println("You dropped some " + item);
        
        }
        else
        {
            System.out.println("No such item was found in your inventory. Check your inventory with 'inventory'.");
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
                        System.out.println(  inventory.get(j) + "," );
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
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
            listRoomItems();
        }
    }
    
    private void listRoomItems()
    {
        
            ArrayList<String> itemsInCurrentRoom = currentRoom.getArray();
            
            if(!itemsInCurrentRoom.isEmpty())
            {
                System.out.println( "[");
                for(int j=0; j < itemsInCurrentRoom.size(); j++)
                    {
                        System.out.println( itemsInCurrentRoom.get(j) );
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

}
