package src.test.java.learn.poker;

import org.junit.jupiter.api.Test;
import src.main.java.learn.cards.Card;
import src.main.java.learn.cards.Rank;
import src.main.java.learn.cards.Suit;
import src.main.java.learn.poker.TwoCardHand;

import static org.junit.jupiter.api.Assertions.*;

class TwoCardHandTest {

    // 1. Instantiate hands with the appropriate suit and rank for each test.
    // 2. Run the tests and confirm they pass. Do NOT edit existing tests.
    // 3. Add a couple more tests to confirm everything is working as intended.

    @Test
    void twoQueensShouldBeatTwo10s() {
        // TODO: instantiate Cards and TwoCardHands with appropriate arguments
        TwoCardHand queenQueen = new TwoCardHand(new Card(Suit.CLUBS, Rank.QUEEN), new Card(Suit.CLUBS, Rank.QUEEN));
        TwoCardHand tenTen = new TwoCardHand(new Card(Suit.CLUBS, Rank.TEN), new Card(Suit.CLUBS, Rank.TEN));
        assertTrue(queenQueen.compareTo(tenTen) > 0);
    }

    @Test
    void two9sShouldBeatJack10() {
        // TODO: instantiate Cards and TwoCardHands with appropriate arguments
        TwoCardHand nineNine = new TwoCardHand(new Card(Suit.CLUBS, Rank.NINE), new Card(Suit.CLUBS, Rank.NINE));
        TwoCardHand jackTen = new TwoCardHand(new Card(Suit.CLUBS, Rank.JACK), new Card(Suit.CLUBS, Rank.TEN));
        assertTrue(nineNine.compareTo(jackTen) > 0);
    }

    @Test
    void queen4ShouldBeatJack10() {
        // TODO: instantiate Cards and TwoCardHands with appropriate arguments
        TwoCardHand queenFour = new TwoCardHand(new Card(Suit.CLUBS, Rank.QUEEN), new Card(Suit.CLUBS, Rank.FOUR));
        TwoCardHand jackTen = new TwoCardHand(new Card(Suit.CLUBS, Rank.JACK), new Card(Suit.CLUBS, Rank.TEN));
        assertTrue(queenFour.compareTo(jackTen) > 0);
    }

    @Test
    void queen5ShouldBeatQueen3() {
        // TODO: instantiate Cards and TwoCardHands with appropriate arguments
        TwoCardHand queenFive = new TwoCardHand(new Card(Suit.CLUBS, Rank.QUEEN), new Card(Suit.CLUBS, Rank.FIVE));
        TwoCardHand queenThree = new TwoCardHand(new Card(Suit.CLUBS, Rank.QUEEN), new Card(Suit.CLUBS, Rank.THREE));
        assertTrue(queenFive.compareTo(queenThree) > 0);
    }

    @Test
    void two5sShouldTieTwo5s() {
        // TODO: instantiate Cards and TwoCardHands with appropriate arguments
        TwoCardHand firstFiveFive = new TwoCardHand(new Card(Suit.CLUBS, Rank.FIVE), new Card(Suit.CLUBS, Rank.FIVE));
        TwoCardHand secondFiveFive = new TwoCardHand(new Card(Suit.CLUBS, Rank.FIVE), new Card(Suit.CLUBS, Rank.FIVE));
        assertEquals(0, firstFiveFive.compareTo(secondFiveFive));
    }

    @Test
    void jack4ShouldTieJack4() {
        // TODO: instantiate Cards and TwoCardHands with appropriate arguments
        TwoCardHand firstJackFour = new TwoCardHand(new Card(Suit.CLUBS, Rank.JACK), new Card(Suit.CLUBS, Rank.FOUR));
        TwoCardHand secondJackFour = new TwoCardHand(new Card(Suit.CLUBS, Rank.JACK), new Card(Suit.CLUBS, Rank.FOUR));
        assertEquals(0, firstJackFour.compareTo(secondJackFour));
    }

}