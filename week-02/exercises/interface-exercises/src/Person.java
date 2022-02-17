public class Person{

    private final String firstName;
    private final String lastName;
//    private Wallet personalWallet;
    // this is has-a like a person has-a name
    private MoneyStorage myMoneyStorage;
    // we can use interfaces as a catch all for any MoneyStorage item.

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
