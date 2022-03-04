package src.main.java.learn.cards;

public enum Rank {
    TWO,THREE,FOUR,FIVE,SIX,SEVEN,
    EIGHT,NINE,TEN,JACK,QUEEN,KING,ACE;

    public int getIntValue(){
        for (int i = 0; i < Rank.values().length; i++) {
            if (Rank.values()[i] == Rank.this){
                return i+2;
            }
        }
        return 0;
    }
}
