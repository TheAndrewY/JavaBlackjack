package Game;
import java.util.Scanner;

public class Player extends Person {
    Scanner scan = new Scanner(System.in);
    public String toString(){
        String allCards = "";
        for(Card x : startingHand.CardsList()){
            allCards += ("["+x+"], ");
        }
        return "Your hand has a total value of "+startingHand.getTotalValue()+" with cards "+allCards;
    }
}

