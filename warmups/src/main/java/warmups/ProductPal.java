package warmups;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductPal {
    public static void main(String[] args) {
        List<Integer> pals = new ArrayList<>();
        for(int i = 999; i > 800; i--){
            int j;
            for(j = 999; !isPalindrone(i*j) && j > 800; j --){

            }
            if (j != 800) {
//                System.out.println(i);
//                System.out.println(j);
//                System.out.println(i*j);
                pals.add(i * j);

            }


        }
        System.out.println(pals.stream().max(Comparator.naturalOrder()).orElse(null));
    }


    private static boolean isPalindrone(int i) {
        String toCheck = Integer.toString(i);
        int size = toCheck.length();
        char[] letters = toCheck.toCharArray();
        for (char letter: letters){
            if(letter != letters[size-1]){
                return false;
            }
            size--;
        }
        return true;
    }
}
