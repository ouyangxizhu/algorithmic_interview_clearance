package _43_51_dynamic_programming;

/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 */
public class _45_SevenZero {
    /**
     *
     * 方法一：暴力法
     *
     * 算法
     *
     * 在暴力法中，我们将会把所有可能爬的阶数进行组合，也就是 1 和 2 。而在每一步中我们都会继续调用 climbStairsclimbStairs 这个函数模拟爬 11 阶和 22 阶的情形，并返回两个函数的返回值之和。
     *
     * climbStairs(i,n)=(i + 1, n) + climbStairs(i + 2, n)
     * climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n)
     *
     * 其中 ii 定义了当前阶数，而 nn 定义了目标阶数。
     *
     * 时间复杂度：O(2^n)
     * 空间复杂度：O(n)，递归树的深度可以达到 nn 。
     *   。
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        return climb_Stairs(0, n);
    }
    public int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }

    /**
     * 方法二：记忆化递归
     *
     * 算法
     *
     * 在上一种方法中，我们计算每一步的结果时出现了冗余。另一种思路是，我们可以把每一步的结果存储在 memomemo 数组之中，每当函数再次被调用，我们就直接从 memomemo 数组返回结果。
     *
     * 在 memomemo 数组的帮助下，我们得到了一个修复的递归树，其大小减少到 nn。
     *
     * 时间复杂度：O(n)，树形递归的大小可以达到 nn。
     * 空间复杂度：O(n)，递归树的深度可以达到 nn。
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs1(0, n, memo);
    }
    public int climb_Stairs1(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs1(i + 1, n, memo) + climb_Stairs1(i + 2, n, memo);
        return memo[i];
    }

    /**
     * 方法三：动态规划
     *
     * 算法
     *
     * 不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     *
     * 第 ii 阶可以由以下两种方法得到：
     *
     * 在第 (i-1)(i−1) 阶后向上爬一阶。
     *
     * 在第 (i-2)(i−2) 阶后向上爬 22 阶。
     *
     * 所以到达第 ii 阶的方法总数就是到第 (i-1)(i−1) 阶和第 (i-2)(i−2) 阶的方法数之和。
     *
     * 令 dp[i]dp[i] 表示能到达第 ii 阶的方法总数：
     *
     * dp[i]=dp[i-1]+dp[i-2]
     * dp[i]=dp[i−1]+dp[i−2]
     *
     * 时间复杂度：O(n)，单循环到 nn 。
     *
     * 空间复杂度：O(n)，dpdp 数组用了 n 的空间。
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 方法四：斐波那契数
     *
     * 算法
     *
     * 在上述方法中，我们使用 dpdp 数组，其中 dp[i]=dp[i-1]+dp[i-2]。可以很容易通过分析得出 dp[i]dp[i] 其实就是第 ii 个斐波那契数。
     *
     * Fib(n)=Fib(n-1)+Fib(n-2)
     * Fib(n)=Fib(n−1)+Fib(n−2)
     *
     * 现在我们必须找出以 1 和 22作为第一项和第二项的斐波那契数列中的第 n个数，
     * 也就是说 Fib(1)=1Fib(1)=1 且 Fib(2)=2Fib(2)=2。
     *
     *
     * 时间复杂度：O(n)O(n)，单循环到 nn，需要计算第 nn 个斐波那契数。
     *
     * 空间复杂度：O(1)O(1)，使用常量级空间。
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * Binets 方法
     * https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
     * @param n
     * @return
     */

    public int climbStairs4(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * 方法六：斐波那契公式
     * https://leetcode-cn.com/problems/climbing-stairs/solution/pa-lou-ti-by-leetcode/
     * @param n
     * @return
     */
    public int climbStairs5(int n) {
        double sqrt5=Math.sqrt(5);
        double fibN=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibN/sqrt5);
    }


}
