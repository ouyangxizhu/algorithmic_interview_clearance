package _52_54_Find_union;

import util.Union_Find_Set;

/**
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class _53_54_TwoZeroZero {
    /**
     * 染色问题
     *
     * 1.遍历所有节点，如果该节点== 1， count++ ，并将该节点和附近节点都赋值0（与该节点在同一个岛上的点）
     * 可以bfs或者dfs
     * @param grid
     * @return
     */
    int[] dx = new int[] {-1, 1, 0, 0};
    int[] dy = new int[] {0, 0, -1, 1};
    int max_x;
    int max_y;
    int i;
    int j;
    char[][] grid;
    int count;
    //这里可以设置一个同样大小维数的数组，记录是否访问过
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        max_x = grid.length;
        max_y = grid[0].length;
        this.grid = grid;
        for (i = 0; i < max_x; i++) {
            for (j = 0; j < max_y; j++) {
                if (grid[i][j] == '1')
                    count++;
                dfs(i, j);
            }
        }
        return count;
    }

    private void dfs(int i, int j) {
        if (!isValid(i, j)) return;
        grid[i][j] = '0';
        for (int k = 0; k < 4; k++) {
            dfs(i + dx[k], j + dy[k]);
        }
    }

    private boolean isValid(int i, int j) {
        if (i < 0 || i >= max_x || j < 0 || j >= max_y || grid[i][j] == '0') return false;
        return true;
    }


    /**
     * 并查集
     *
     * 初始化  将所有‘1’节点都指向自己
     * 遍历所有节点，将相邻的‘1’节点合并
     * 遍历所有节点，判断有多少个root（可以在上一次遍历时统计）
     *
     * @param grid
     * @return
     */
    public int numIslands1(char[][] grid) {
        int N = grid.length;
        Union_Find_Set set = new Union_Find_Set(N);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == '1' && !set.isInSameSet(i,j)){
                    set.union(i, j);
                }
            }
        }
        return set.NumOfSet();
    }

}
