package _43_51_dynamic_programming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class _48_OneTwotwo {
    public int maxProfit(int[] prices) {
        if (prices.length==1) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = prices[i]-prices[i-1];
            if (sum>0) {
                max+=sum;
            }
        }
        return max;
    }
}
