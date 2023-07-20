package Game;

public class Dealer extends Person {

    private final int firstValue =  startingHand.CardsList().get(0).getValue();
    private final Card card1 = startingHand.CardsList().get(0);
    public void start(){
        while(startingHand.getTotalValue() < 17 && !startingHand.checkBust()){
            startingHand.hit();
        }
        System.out.println("The dealer has "+startingHand+" With a total value of "+ startingHand.getTotalValue());

    }
    public String toString(){
        return "The dealer's first card is a(n) ["+card1+ "] with a value of "+firstValue;
    }
}
