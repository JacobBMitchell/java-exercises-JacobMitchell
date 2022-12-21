package warmups;

public class PrimeAverage {
    static int prev = 1;
    public static void main(String[] args) {
        //loop over primes
        //2+3/2 ) + 5)/3 +7)4 ...
        double primeAvg =0;
        for (int i = 1; i < 500; i++) {
            prev = findNextPrime(prev);
            double temp = primeAvg;
            primeAvg = (prev+primeAvg)/i;
            System.out.println(i+": \n    Prime Average: "+ primeAvg +"\n    Prime: " +prev
                    +"\n    Ratio: " +primeAvg/temp);
        }
    }

    private static int findNextPrime(int prev) {
        boolean primeFound = false;
        prev = prev + 1;
        if (prev < 4){
            System.out.println("prev: " + prev);
            return prev ;
        }
        for (int i = prev; !primeFound; i++) {
            double jMax = Math.sqrt(i);
            for (int j = 2; j <= jMax; j++) {
                if (i%j == 0){
                    break;
                }
                if (j + 1 > jMax){
                    primeFound = true;
                }
            }
            if(primeFound){
                prev = i;
            }
        }
        return prev;
    }
}
