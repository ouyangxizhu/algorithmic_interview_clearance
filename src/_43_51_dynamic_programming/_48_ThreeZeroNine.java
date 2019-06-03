package _43_51_dynamic_programming;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 */
public class _48_ThreeZeroNine {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0)
            return 0;
        int[] dp1 = new int[len];//第i天以及以前 持有股票的最大收益
        int[] dp2 = new int[len];//第i天以及以前 不存在股票的最大收益
        int[] dp3 = new int[len];//第i天 为冷冻期的最大收益
        dp1[0] = - prices[0];
        dp2[0] = 0;
        dp3[0] = 0;
        for (int i = 1; i < len; i++){

            dp1[i] = Math.max(dp1[ i - 1], dp3[i - 1] - prices[i]);
            dp2[i] = Math.max(dp2[ i - 1], dp1[i - 1] + prices[i]);
            dp3[i] = Math.max(dp2[ i - 1], dp3[i - 1]);

        }
        return Math.max(dp2[len-1],dp3[len-1]);
    }
}
