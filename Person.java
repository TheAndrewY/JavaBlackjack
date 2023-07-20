package Game;

public class Person {
    protected Hand startingHand;

    // Creates a hand initially for both Dealer and Player
    public Person(){
        startingHand = new Hand();
    }
    public boolean greaterThan(Person x){
        return startingHand.getTotalValue() > x.startingHand.getTotalValue();
    }
    public boolean equalTo(Person x ){
        return startingHand.getTotalValue() == x.startingHand.getTotalValue();
    }
    public int BJchecker(Person p2){
        boolean result1 = this.startingHand.checkBlackjack();
        boolean result2 = p2.startingHand.checkBlackjack();
        if (result1 && !result2){
            return 1;
        }else if(!result1 && result2){
            return -1;
        }else if(result1 && result2)
            return 2;
        else{
            return 0;
        }
    }

}
