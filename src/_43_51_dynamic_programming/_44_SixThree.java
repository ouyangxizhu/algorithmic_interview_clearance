package _43_51_dynamic_programming;

/**
 *https://leetcode-cn.com/problems/unique-paths-ii/
 */
public class _44_SixThree {
    /**
     * 递归
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int [][] ways = new int [obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < ways.length; i++) {
            for (int j = 0; j < ways[0].length; j++) {
                if (obstacleGrid[i][j]==1) {
                    ways[i][j]=0;
                }else if (i==0&j==0) {
                    ways[i][j]=1;
                }else if (i==0&j>0) {
                    ways[i][j]=ways[i][j-1];
                }else if (j==0&i>0) {
                    ways[i][j]=ways[i-1][j];
                }else {
                    ways[i][j]=ways[i][j-1]+ways[i-1][j];
                }
            }
        }
        return ways[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
