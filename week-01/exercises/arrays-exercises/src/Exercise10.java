import java.util.Arrays;
import java.util.Random;

public class Exercise10 {

    public static void main(String[] args) {
        String[] bugs = makeBugArray();
        int[] bugNums = countBugs(bugs);
        // The bugs array elements are either the value "beetle" or "mosquito".
        // 1. Count the number of beetles and mosquitoes.
        // 2. Print the result.
        System.out.printf("There are %d beetles and %d mosquitoes!\n", bugNums[0],bugNums[1]);
        // Results will vary because of randomness.
    }

    private static int[] countBugs(String[] bugs) {
        int i = 0;
        int j = 0;
        for (String bug:bugs){
            if (bug.equals("beetle")){
                i++;
            }
            else if(bug.equals("mosquito")){
                j++;
            }
        }
        return new int[]{i, j};
    }

    public static String[] makeBugArray() {
        String[] bugs = new String[200];
        Arrays.fill(bugs, "beetle");
        Random random = new Random();
        for (int i = 0; i < random.nextInt(150); i++) {
            bugs[random.nextInt(bugs.length)] = "mosquito";
        }
        return bugs;
    }
}
