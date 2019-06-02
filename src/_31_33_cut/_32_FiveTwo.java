package _31_33_cut;

/**
 * https://leetcode-cn.com/problems/n-queens-ii/
 */
public class _32_FiveTwo {
    /**
     * 在建立算法之前，我们来考虑两个有用的细节。
     *
     * 一行只可能有一个皇后且一列也只可能有一个皇后。
     * 这意味着没有必要再棋盘上考虑所有的方格。只需要按列循环即可。
     *
     * 对于所有的主对角线有 行号 + 列号 = 常数，对于所有的次对角线有 行号 - 列号 = 常数.
     * 这可以让我们标记已经在攻击范围下的对角线并且检查一个方格 (行号, 列号) 是否处在攻击位置。
     *
     *
     * 现在已经可以写回溯函数 backtrack(row = 0).
     *
     * 从第一个 row = 0 开始.
     *
     * 循环列并且试图在每个 column 中放置皇后.
     *
     * 如果方格 (row, column) 不在攻击范围内
     *
     * 在 (row, column) 方格上放置皇后。
     * 排除对应行，列和两个对角线的位置。
     * If 所有的行被考虑过，row == N
     * 意味着我们找到了一个解
     * Else
     * 继续考虑接下来的皇后放置 backtrack(row + 1).
     * 回溯：将在 (row, column) 方格的皇后移除.
     * 下面是上述算法的一个直接的实现。
     *
     *
     * 时间复杂度：\mathcalO(N!). 放置第 1 个皇后有 N 种可能的方法，放置两个皇后的方法不超过 N (N - 2) ，放置 3 个皇后的方法不超过 N(N - 2)(N - 4) ，以此类推。总体上，时间复杂度为 \mathcal{O}(N!)O(N!) .
     * 空间复杂度：\mathcalO(N) . 需要保存对角线和行的信息。
     * @param row
     * @param col
     * @param n
     * @param rows
     * @param hills
     * @param dales
     * @return
     */

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
