package _43_51_dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class _49_ThreeZeroZero {
    /**
     * dp
     * O（n2）
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1;
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++){
            for (int j = 0; j < i; j++){
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }

    /**
     * 维护一个数组，查找的时候用二分查找，O（nlogn）
     * @param nums
     * @return
     */
    public int lengthOfLIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        List<Integer> res = new ArrayList<>();
        for (int i  = 0; i < nums.length; i++){
            int index = binarySearch(nums[i], res);
            if (index >= res.size())
                res.add(nums[i]);
            else
                res.set(index,nums[i]);
        }
        return res.size();

    }

    /**
     * 二分查找
     * @param n
     * @param res
     * @return
     */

    private int binarySearch(int num, List<Integer> res) {
        if(res == null || res.size() == 0) return 0;
        int l = 0;
        int r = res.size() - 1;
        int mid;
        while(l <= r){
            mid = (l + r) >> 1;
            int tmp = res.get(mid);
            if (num > tmp){
                l = mid + 1;
            }else if(num < tmp){
                r = mid - 1;
            }else
                return mid;
        }
        return l;
    }
}
