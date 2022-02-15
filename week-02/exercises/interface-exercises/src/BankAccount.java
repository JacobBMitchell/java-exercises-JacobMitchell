public class BankAccount implements MoneyStorage{
    private double balance;
    private String description;
    public BankAccount(double balance, String description){
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
        if (amount >= 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    @Override
    public double withdraw(double amount) {
        if(balance-amount < -25){
            amount = balance;
            balance = -25;
            return amount;
        }
        balance-=amount;
        return amount;
    }
}
