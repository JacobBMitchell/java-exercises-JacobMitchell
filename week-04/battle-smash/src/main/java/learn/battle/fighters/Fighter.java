package learn.battle.fighters;

public class Fighter {

    private final String name;
    private int balance = 100;
    private int innitiative;

    public Fighter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isOut() {
        return balance <= 0;
    }

    public void reduceBalance(int amount) {
        balance -= amount;
    }

    public void setInnitiative(int innitiative) {
        this.innitiative = innitiative;
    }

    public int getInnitiative() {
        return innitiative;
    }
}
