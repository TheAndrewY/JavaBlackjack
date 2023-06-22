package Game;

public class Player extends Person {
    public String toString(){
        String allCards = "";
        for(Card x : startingHand.CardsList()){
            allCards += ("["+x+"], ");
        }
        return "Your hand has a total value of "+startingHand.getTotalValue()+" with cards "+allCards;
    }
}

