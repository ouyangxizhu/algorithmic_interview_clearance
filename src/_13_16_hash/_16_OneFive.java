package _13_16_hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/3sum/
 */
public class _16_OneFive {
    /**
     * 直接暴力枚举O(N3)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++){
            for (int j = i + 1; j < nums.length - 1; j++){
                for (int k = j + 1; k < nums.length; k++){
                    if (nums[i] + nums[j] + nums[k] == 0)
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                }
            }
        }
        return res;
    }
    /**
     * 将数据存储进hashset第三次循环可以简化为O(1)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> set;
        HashSet<List<Integer>> resSet = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++){
                //精华
                if (!set.contains(nums[j]))
                    set.add(- nums[j] - nums[i]);
                else
                    resSet.add(Arrays.asList(nums[i], - nums[j] - nums[i], nums[j]));
            }

        }
        res = new ArrayList<>(resSet);

        return res;
    }
    /**
     * 先将数组排序
     * 循环一次之后将使用左右指针查找
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r){
                int s = nums[i] + nums[l] + nums[r];
                if(s < 0) l++;
                else if (s > 0) r--;
                else{
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while(l < r && nums[l] == nums[l + 1])
                        l++;
                    while(l < r && nums[r - 1] == nums[r])
                        r--;
                    l++;
                    r--;
                }
            }
        }
        return res;
    }

}
