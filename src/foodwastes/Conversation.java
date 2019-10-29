package foodwastes;

import java.util.Scanner;

public class Conversation {
    
    //Fields
    private Scanner reader;
    int progress;
    
    //Constructor
    public Conversation() {
        reader = new Scanner(System.in);
        progress = 0;
    }
    
    //Asks player a question and to give an input value
    public String askQuestionInput (String question) {
        System.out.println(question);
        System.out.println("> ");
        String questionAnswer = reader.nextLine().trim();
        return questionAnswer;
    }
    
    //Asks player to input a value
    public String askInput() {
        System.out.println("> ");
        String questionAnswer = reader.nextLine().trim();
        return questionAnswer;
    }
    

}
