package _24_25_greedy;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class _25_OneTwoTwo {
    /**
     * 还有一种算法是可以dfs，即递归每天买入或者卖出
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int max = 0;
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            sum = prices[i]-prices[i-1];
            if (sum > 0) {
                max += sum;
            }
        }
        return max;
    }
}
