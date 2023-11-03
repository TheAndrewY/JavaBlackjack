package Game;
import java.util.Random;

public class Card {
    Random rand = new Random();
    private final Suit suit;
    private final Value value;
    public Card(){
        // Creates a new Card object with a random suit and value.
        suit = Suit.values()[rand.nextInt(Suit.values().length)];
        value = Value.values()[rand.nextInt(Value.values().length)];
    }
    public String toString(){
        return value+" of "+suit;
    }
    public enum Suit {
        Spades,Hearts,Diamonds,Clubs
    }
    public int getValue(){
        return this.value.getVal();
    }
    public enum Value {
        Two(2),Three(3),Four(4),Five(5),Six(6),Seven(7),Eight(8),Nine(9),Ten(10),Jack(10),Queen(10),King(10),Ace(1);
        private final int value;
        Value(int val){
            value = val;
        }
        public int getVal(){
            return value;
        }

    }

}
