package _43_51_dynamic_programming;

/**
 *https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class _47_OneFiveTwo {
    /**
     * 解题思路：
     * 最暴力的方式当然是遍历到i，都和i之前的再循环一遍，找到最大值，双重遍历
     * 上面的解题时间会超，所以得考虑利用之前的遍历结果，==>动态规划
     * <p>
     * 求积的最大值，最麻烦的就是
     * 当遇到0的时候，整个乘积会变成0；当遇到负数的时候，当前的最大乘积会变成最小乘积，最小乘积会变成最大乘积
     * <p>
     * 所以用两个数组进行保存最大值和最小值
     * <p>
     * 当前的最大值等于已知的最大值、最小值和当前值的乘积，当前值，这三个数的最大值。
     * 当前的最小值等于已知的最大值、最小值和当前值的乘积，当前值，这三个数的最小值。
     * 结果是最大值数组中的最大值。
     * <p>
     * 数组可以进一步优化成int，空间复杂度从O(n)->O(1)
     * min其实可以看成负的最大值，或者把max和min合并成二维数组
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int retVal;
        retVal = max[0] = min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]));
            min[i] = Math.min(nums[i], Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]));
            retVal = Math.max(retVal, max[i]);
        }

        return retVal;
    }

    public int maxProduct2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int max, min, retVal, preMax, preMin;
        retVal = max = min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = max;
            preMin = min;
            max = Math.max(nums[i], Math.max(nums[i] * preMax, nums[i] * preMin));
            min = Math.min(nums[i], Math.min(nums[i] * preMax, nums[i] * preMin));
            retVal = Math.max(retVal, max);
        }

        return retVal;
    }
}
