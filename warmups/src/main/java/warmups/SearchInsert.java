package warmups;

public class SearchInsert {
    public int SI (int[] nums, int target){
        int i = 0;
        for (i = 0; i<nums.length; i++){ //4
            if(nums[i] >= target){ // {1,3,4,5,7,9}
                return i;
            }
        }
        return i;
    }
}
