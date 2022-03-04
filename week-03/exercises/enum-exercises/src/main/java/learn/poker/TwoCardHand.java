package src.main.java.learn.poker;

import src.main.java.learn.cards.Card;
//import src.main.java.learn.cards.Rank;

public class TwoCardHand implements Comparable<TwoCardHand> {

    private final Card one;
    private final Card two;

    public TwoCardHand(Card one, Card two) {
        this.one = one;
        this.two = two;
    }

    public Card getOne() {
        return one;
    }

    public Card getTwo() {
        return two;
    }

    @Override
    public int compareTo(TwoCardHand o) {
        int card1 = this.one.getRanks().getIntValue();
        int card2 = this.two.getRanks().getIntValue();
        int cardA = o.getOne().getRanks().getIntValue();
        int cardB = o.getTwo().getRanks().getIntValue();
        if (card1 == card2 && cardA != cardB){
            return 1;
        }
        if (card1 != card2 && cardA == cardB){
            return -1;
        }
        if (card1 == card2){
            if (card1 == cardA){
                return 0;
            }
            else if (card1 > cardA){
                return 1;
            }
            else{
                return -1;
            }

        }
        if (Math.max(card1,card2) > Math.max(cardA,cardB)){
            return 1;
        }
        if (Math.max(card1,card2) == Math.max(cardA,cardB)){
            if (Math.min(card1,card2) == Math.min(cardA,cardB)) {
                return 0;
            }
            else if (Math.min(card1,card2) > Math.min(cardA,cardB)){
                return 1;
            }
            else{ return 0;}
        }

        return -1;

//        System.out.println(this.one.getRanks().getIntValue());
        // 1. Complete the compareTo method.

        // If the current TwoCardHand(`this`) has a lower score than the TwoCardHand parameter, compareTo returns
        // an int less than 0.
        // If `this` has a higher score than the TwoCardHand parameter, compareTo returns an int greater than 0.
        // If `this` and the TwoCardHand parameter have the same score, compareTo returns 0.
        // See Exercise04.md for scoring rules.
        //return 0;
    }
}
