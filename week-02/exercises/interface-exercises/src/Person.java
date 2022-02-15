public class Person{

    private final String firstName;
    private final String lastName;
//    private Wallet personalWallet;
    private MoneyStorage myMoneyStorage;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }

    public MoneyStorage getMyMoneyStorage() {
        return myMoneyStorage;
    }

    public void setMyMoneyStorage(MoneyStorage myMoneyStorage) {
        this.myMoneyStorage = myMoneyStorage;
    }

    public void deposit(double deposit) {
        myMoneyStorage.deposit(deposit);
    }

    public String getDescription() {
        return myMoneyStorage.getDescription();
    }

    public double getBalance() {
        return myMoneyStorage.getBalance();
    }
}
