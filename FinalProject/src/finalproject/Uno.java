/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject;

import java.util.*;

/**
 *
 * @author Inven
 */
public class Uno extends Game{
    private GroupOfCards mainDeck = new GroupOfCards(108);
    private GroupOfCards discardPile;
    private Player winner;
    
    public Uno(){
        super("Uno");
    }
    
    private void initialize(int size){
        //Zero Number Cards
        for(int i = 0; i < 4; i++){
            NumberCard zero = new NumberCard(Card.Colour.values()[i], Card.Value.ZERO);
            mainDeck.getCards().add(zero);
        }
        
        //All other Number Cards
        for(int i = 0; i < 4; i++){
            for(int j = 1; j < 10; j++){
                for(int k = 0; k < 2; k++){
                    NumberCard num = new NumberCard(Card.Colour.values()[i], Card.Value.values()[j]);
                    mainDeck.getCards().add(num);
                }
            }
        }
        
        //Coloured Action Cards
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 2; k++){
                    ColouredActionCard cac = new ColouredActionCard(Card.Action.values()[j], Card.Colour.values()[i]);
                    mainDeck.getCards().add(cac);
                }
            }
        }
        
        //Wild Cards
        for(int i = 3; i < 5; i++){
            for(int j = 0; j < 4; j++){
                WildActionCard wild = new WildActionCard(Card.Action.values()[i]);
                mainDeck.getCards().add(wild);
            }
        }
        
        //Shuffle main deck
        mainDeck.shuffle();
        for(int i = 0; i < size; i++){
            for(int j = 0; j < 7; j++){
                players.get(i).addToDeck(mainDeck.getCards().remove(0));
            }
        }
    }
    
    public void resetDeck(){
        discardPile.shuffle();
        mainDeck = discardPile;
    }
    
    public void play(){
        System.out.println("Welcome to UNO!\n");
        Scanner input = new Scanner(System.in);
        System.out.print("How many players are there?: ");
        //Add code to prevent more than 10 players and less than 2
        int amountOfPlayers = input.nextInt();
        //Add code to ensure an integer is entered
        for(int i = 0; i < amountOfPlayers; i++){
            System.out.print("Is the player a human or a computer (H/C)?: ");
            //Add code to ensure that no more than 10 players total are created
            if(input.next().equals("H")){
            //Add code to ensure an appropriate string is entered
                System.out.println("What is your name?: ");
                String name = input.next();
                User user = new User(name);
                this.getPlayers().add(user);
            }
            else{
                Computer computer = new Computer();
                this.getPlayers().add(computer);
                System.out.println("Computer player "+computer.getName()+" is created!");
            }
        }
    }
    
    public void declareWinner(){
        
    }

}
