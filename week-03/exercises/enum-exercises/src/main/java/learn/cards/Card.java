package src.main.java.learn.cards;

import java.util.Locale;

public class Card {


    // 1. Add a Suit and Rank field the Card class.
    // 2. Add a constructor that accepts a Suit and Rank and sets the appropriate fields.
    // 3. Add getters for both suit and rank.
    Suit cardSuit;
    Rank cardRank;

    public Card(Suit suits, Rank ranks) {
        this.cardSuit = suits;
        this.cardRank = ranks;
    }


    public String getName() {
        String name = "";
        String cardRankf = this.cardRank.name().substring(0,1) + this.cardRank.name().substring(1).toLowerCase();
        for (int i = 1; i <10; i++){
            if (this.cardRank == Rank.values()[i]){
                cardRankf = String.valueOf(i);
            }
        }
        name += cardRankf;
        name += " of ";
        String cardSuitf = this.cardSuit.name().charAt(0) + this.cardSuit.name().substring(1).toLowerCase();
        name += cardSuitf;
        return name;
        // 4. Complete the getName method.
        // Given a card's suit and rank, getName returns a String in the format:
        // "[rank] of [suit]"

        // Examples:
        // Ace of Clubs
        // 5 of Diamonds
        // King of Hearts
        // 9 of Spades

        // Note: it's unlikely you'll be able to use the enum name directly since enum naming conventions
        // don't match the required output.
//        return null;

    }
    public Suit getSuits() {
        return cardSuit;
    }

    public void setSuits(Suit suits) {
        this.cardSuit = suits;
    }

    public Rank getRanks() {
        return cardRank;
    }

    public void setRanks(Rank ranks) {
        this.cardRank = ranks;
    }
}
