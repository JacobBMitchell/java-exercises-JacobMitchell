package warmups;

public class Primes {
    public static void main(String[] args) {
        int primeCount = 0;
        int toTest = 2;
        boolean isPrime = true;

        while (primeCount <= 10001){
            for (int i = 2; i < toTest/2; i++) {
                if (toTest%i == 0){
                    isPrime = false;
                    break;
                }

            }
            if (isPrime){
                primeCount ++;
            }
            toTest ++;
            isPrime = true;
        }

        System.out.println(toTest-1);
    }
}
