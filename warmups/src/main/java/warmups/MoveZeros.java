package warmups;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,0,5,7,0,0,3,0,0,0};
        int j=0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                nums[j] = nums[i];
                j++;
            }
        }
        for (int i = j; i<nums.length; i++){
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }
}
