package _43_51_dynamic_programming;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 */
public class _50_ThreeTwoTwo {
    /**
     * 其实就是跳台阶
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length;
        if (n == 0 || amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int j = 0; j < n; j++) {
            for (int i = coins[j]; i <= amount; i++) {
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
