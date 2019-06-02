package _20_23_Recursion_Divide;

public class _23_OneSixNine {
    public int majorityElement(int[] nums) {
        if (nums.length==1) {
            return nums[0];
        }else {
            int count = 1;
            int value = nums[0];
            for (int i = 0; i < nums.length-1; i++) {
                if (value==nums[i+1]) {
                    count++;
                }else {
                    if (count>=1) {
                        count--;
                    }
                }
                if (count<1) {

                    value = nums[i+1];
                    count = 1;
                }
            }
            return value;
        }
    }
}
