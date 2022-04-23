package warmups;

import java.util.Arrays;

public class canJump {
    public static void main(String[] args) {
        int[] nums = {1,2,0,4};

        System.out.println(jumps(nums));
    }

    private static boolean jumps(int[] nums) {
        if(Arrays.stream(nums).noneMatch(i -> i == 0)){
            return true;
        }
        if (nums[0] == 0 && nums.length!=1){
            return false;
        }
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == 0){
                boolean works = true;
                for (int j = i-1; j >=0 ; j--) {
                    int difference = j-i;
                    if(nums[j] + difference >0){
                        works = true;
                        break;
                    }
                    else {
                        works = false;
                    }

                }
                if (!works){
                    return false;
                }
            }
        }
        return true;

    }

}
