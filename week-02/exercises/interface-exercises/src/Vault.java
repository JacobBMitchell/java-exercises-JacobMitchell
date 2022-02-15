public class Vault implements MoneyStorage{
    private double balance;
    private String description;
    public Vault(double balance, String description){
        this.balance = balance;
        this.description = description;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public boolean deposit(double amount) {
        if(amount >= 0){
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public double withdraw(double amount) {
        if(balance-amount < 0){
            amount = balance;
            balance = 0;
            return amount;
        }
        balance-=amount;
        return amount;
    }
}
