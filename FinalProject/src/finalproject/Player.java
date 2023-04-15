/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 * @author Caleb Harrison
 * @date April 12, 2023
 * This is a test revision
 */
package finalproject;

import java.util.*;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {
    private GroupOfCards deck;

    private String name; //the unique name for this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */  
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }

    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    public GroupOfCards getDeck(){
        return deck;
    }
    
    public void setDeck(GroupOfCards deck){
        this.deck = deck;
    }
    
    public void addToDeck(Card card){
        deck.getCards().add(card);
        deck.setSize(deck.getCards().size());
    }
    
    public void removeCard(int index){
        deck.getCards().remove(index);
        deck.setSize(deck.getCards().size());
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     */
    public abstract void play();

}

class User extends Player{
    
    public User(String name){
        super(name);
    }
    
    public void play(){
        System.out.println("It is "+this.getName()+"'s turn");
        System.out.println("What would you like to do:");
        for(int i = 0; i < this.getDeck().getSize(); i++){
            System.out.println("\t"+(i+1)+": "+this.getDeck().getCards().get(i).toString());
        }
        System.out.println("\t"+(this.getDeck().getSize() + 1)+": Draw from the Deck");        
    }
}

class Computer extends Player{
    private String[] computerNames = {"unoMaster22", "c@rdB0t674", "gamerBoi857", "gamerGir443", "wildC@rd999", "player3592", "masterBot3728", "player3333", "player9384"};
    private static int count = 0;
    
    //Add logic in the Game class to prevent more than 10 players from existing
    public Computer(){
        super("");
        super.setName(computerNames[count]);
        count++;
    }
    
    public void play(){
        System.out.println("It is the computer "+this.getName()+"'s turn");
    }
}
