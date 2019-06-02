package _31_33_cut;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/solution/nhuang-hou-ii-by-leetcode/
 */
public class _32_FiveTwo {
    public boolean is_not_under_attack(int row, int col, int n,
                                       int [] rows,
                                       int [] hills,
                                       int [] dales) {
        int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
        return (res == 0) ? true : false;
    }

    public int backtrack(int row, int count, int n,
                         int [] rows,
                         int [] hills,
                         int [] dales) {
        for (int col = 0; col < n; col++) {
            if (is_not_under_attack(row, col, n, rows, hills, dales)) {
                // place_queen
                rows[col] = 1;
                hills[row - col + 2 * n] = 1;  // "hill" diagonals
                dales[row + col] = 1;   //"dale" diagonals

                // if n queens are already placed
                if (row + 1 == n) count++;
                    // if not proceed to place the rest
                else count = backtrack(row + 1, count, n,
                        rows, hills, dales);

                // remove queen
                rows[col] = 0;
                hills[row - col + 2 * n] = 0;
                dales[row + col] = 0;
            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        int rows[] = new int[n];
        // "hill" diagonals
        int hills[] = new int[4 * n - 1];
        // "dale" diagonals
        int dales[] = new int[2 * n - 1];

        return backtrack(0, 0, n, rows, hills, dales);
    }




    /**
     * 解题思路（回溯算法）：
     * 1.创建一个大小为n的数组，保存摆放皇后的位置
     * 2.从第一位开始尝试，一直取到N，每一次摆放皇后都得判断是否满足条件
     * 3.如摆放过程中发现没有满足条件的位置，则回溯上一位并寻找下一个可放置的位置
     * 4.如n个皇后都正确摆放，则结果+1，回溯上一位寻找下一个可放置的位置
     *
     * @param n
     * @return
     */
    //运算结果
    private int resultCount = 0;
    public int totalNQueens1(int n) {
        int[] positions = new int[n];
        dfs(positions, 0, n);
        return resultCount;
    }

    private void dfs(int[] positions, int index, int n) {
        if (index >= n) return;
        for (int i = 0; i < n; i++) {
            positions[index] = i;
            if (isMatch(positions, index)) {
                if (index == n - 1) {
                    resultCount++;
                } else {
                    dfs(positions, index + 1, n);
                }
            }
        }
    }

    /**
     * 是否满足N皇后的规则，横、竖、斜边不能放
     *
     * @param positions
     * @param index
     * @return
     */
    private boolean isMatch(int[] positions, int index) {
        for (int i = 0; i < index; i++) {
            //判断横向和斜向是否在一条线上即可，因为竖向用一位数组存储就避免了
            if (positions[i] == positions[index] || Math.abs(positions[i] - positions[index]) == index - i) {
                return false;
            }
        }
        return true;
    }
}
