package _34_35_bineary_search;

/**
 * https://leetcode-cn.com/problems/sqrtx/
 */
public class _35_SixNine {
    /**
     * 数学方法
     *
     * @param x
     * @return
     */
    public int mySqrt1(int x) {
        // write your code here
        if (x < 0)
        {
            return 0;
        }
        double err = 1e-15;
        double t = x;
        while (Math.abs(t - x/t) > err * t)
            t = (x/t + t) / 2.0;
        return (int)t;

    }

    /**
     * 二分
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int left = 1;
        int right = (x / 2) + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == x / mid) return mid;
            else if (mid < x / mid) left = mid + 1;
            else right = mid - 1;
        }
        return right;
    }

}
