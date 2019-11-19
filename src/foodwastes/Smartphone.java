package foodwastes;

import java.util.Scanner;

public class Smartphone {
    
    Scanner phoneinput = new Scanner(System.in);
    
    
    public boolean phoneMode;
    public boolean frontScreen;
    public boolean smsMode;
    public int notifications;
    
    
    private static String SMS = "1";
    private static String EXIT = "2";
    private static String BACK = "3";
    
    public Smartphone() {
        
    }
    

    public void onPhone() {
        frontScreen = true;
        while(frontScreen == true) {
            System.out.println("\t\nYou are currently on your phone (phone mode) what would you like to do?");
            System.out.println("\t1. Enter SMS"); 
            System.out.println("\t2. Exit"); 
            String maininput = phoneinput.nextLine();
            
            if(maininput.equals(SMS)) {
                frontScreen = false;
                smsMode = true;
                while(smsMode == true) {
                    System.out.println("You are in SMS mode");
                    System.out.println("You have " + notifications + " notifications");
                    System.out.println("\t\nWhat would you like to do?");
//                    System.out.println("\t1. Go to ");
                    System.out.println("\t3. Go back");
                    String smsinput = phoneinput.nextLine();
                    
                    if (smsinput.equals(BACK)) {
                        smsMode = false;
                        frontScreen = true;
                    }
                    
                }
            } else if (maininput.equals(EXIT)) {
                break;
            }
            
        }
    }
}
