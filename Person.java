package Game;

public class Person {
    protected Hand startingHand;
    public Person(){
        startingHand = new Hand();
    }
    public boolean greaterThan(Person x){
        return startingHand.getTotalValue() > x.startingHand.getTotalValue();
    }


}
