/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package finalproject;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author dancye
 */
public abstract class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();
    
    protected enum Colour{
        BLUE, GREEN, RED, YELLOW;
    }
    protected enum Value{
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE;
    }

    protected enum Action{
        SKIP, REVERSE, PLUS_TWO, WILD, PLUS_FOUR;
    }
}

class NumberCard extends Card{
    private final Colour colour;
    private final Value value;
    
    public NumberCard(Colour colour, Value value){
        this.colour = colour;
        this.value = value;
    }
    
    public String getColour(){
        return colour.toString();
    }
    
    public String getValue(){
        return value.toString();
    }

    @Override
    public String toString(){
        return colour.toString() + "-" + value.toString();
    }
}

abstract class ActionCard extends Card{
    protected Action action;
    
    @Override
    public abstract String toString();
}

class ColouredActionCard extends ActionCard{
    private Colour colour;
    
    public ColouredActionCard(Action action, Colour colour){
        this.action = action;
        this.colour = colour;
    }
    
    public String getColour(){
        return colour.toString();
    }
    
    public String getAction(){
        return action.toString();
    }
    
    @Override
    public String toString(){
        return colour.toString() + "-" + action.toString();
    }
}

class WildActionCard extends ActionCard{
    private Colour colour;
    
    public WildActionCard(Action action){
        this.action = action;
    }
    
    public String getColour(){
        return colour.toString();
    }
    
    public void setColour(Colour colour){
        this.colour = colour;
    }
    
    @Override
    public String toString(){
        return colour.toString() + "-" + action.toString();
    }
}

