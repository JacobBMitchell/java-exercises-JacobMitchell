public class Exercise02 {


    // 1. Create a method.
    // Name: printAll
    // Inputs: MoneyStorage[]
    // Output: void
    // Description: prints the details for each MoneyStorage in the array.

    public static void main(String[] args) {
        MoneyStorage[] storages = {
                new Wallet(3.25, "Red Wallet"),
                new Mortgage(320000, "1234-dfdf-8790-trtr"),
                new Mortgage(750, "3415-jada-6734-krtt")
                // 2. Declare a third MoneyStorage here.
        };
        printAll(storages);
        depositInAll(storages, 100.00);
        printAll(storages);

        // 3. Pass storages as an argument to printAll.

        // Sample Output
        // Red Wallet: 103.25
        // Mortgage #1234-dfdf-8790-trtr: -319900.0
        // [Some description]: [balance]
    }

    private static void printAll(MoneyStorage[] storages) {
        for(MoneyStorage storage: storages) {
            System.out.printf("%s: %.2f", storage.getDescription(),storage.getBalance());
            System.out.println();
        }
    }


    static void depositInAll(MoneyStorage[] storages, double amount) {
        for (MoneyStorage storage : storages) {
            storage.deposit(amount);
        }
    }

}
