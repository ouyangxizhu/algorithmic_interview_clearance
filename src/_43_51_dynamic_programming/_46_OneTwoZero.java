package _43_51_dynamic_programming;

import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 */
public class _46_OneTwoZero {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        //加1 可以不用初始化第一层
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0; j < curTr.size(); j ++){
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 因为只需要一层结果，所以一维数组就可以
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        //加1 可以不用初始化第一层
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--){
            List<Integer> curTr = triangle.get(i);
            for(int j = 0; j < curTr.size(); j ++){
                dp[j] = Math.min(dp[j], dp[j + 1]) + curTr.get(j);
            }
        }
        return dp[0];

    }
}
