package Game;

import java.util.ArrayList;

public class Hand {
    private int totalValue;
    private boolean checkedAce = false;
    private final ArrayList<Card> cards = new ArrayList<>();
    public Hand(){
        cards.add(new Card());
        cards.add(new Card());
        totalValue = cards.get(0).getValue() + cards.get(1).getValue();
        this.checkAce();
    }
    public int getTotalValue(){
        return totalValue;
    }
    public void hit(){
        Card newCard = new Card();
        cards.add(newCard);
        totalValue += newCard.getValue();
        this.checkAce();
    }
    public ArrayList<Card> CardsList(){
        return cards;
    }
    public boolean checkBust() {
        return totalValue > 21;
    }
    private void checkAce(){
        if (totalValue+10 < 21 && !checkedAce){
            for(Card x : cards){
                if(x.getValue() == 1) {
                    totalValue +=10;
                    checkedAce = true;
                    break;
                }

            }
        }
    }
    public String cardsListString(){
        String list = "";
        for(Card x : cards){
            list +="["+x+"], ";
        }
        return list;
    }

}
