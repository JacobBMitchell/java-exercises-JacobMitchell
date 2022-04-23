package warmups;

public class Stairs {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }

    public static int climbStairs(int n) {
        int a = 1;
        int b = 1;

        int total = 0;
        for(int j = 0; j < n; j++){
            if (j%2 == 0){
                total += a;
                a = total;
            }
            else {
                total += b;
                b = total;
            }
        }

        return total;
    }
}
