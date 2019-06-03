package _43_51_dynamic_programming;

/**
 * 递归+记忆化--->递推
 */
public class FIb {
    /**
     * 递归
     * 最原始的算法，复杂度2^n
     * 因为重复计算了好多数字，可以用一个数字记录，之后直接取出就行了
     * @param n
     * @return
     */
    public int fib(int n){
        return n < 1 ? n : fib(n - 1) + fib(n -2);
    }

    /**
     * 递归 + 记忆化
     * @param n
     * @param memo
     * @return
     */
    public int fib (int n, int[] memo){
        if (n <= 1) return n;
        if (memo[n] == 0){
            memo[n] = fib(n - 1, memo) + fib(n - 2, memo);
        }
        return memo[n];
    }
    /**
     * 递归 + 记忆化
     * 上面是递归，但是可以从下往上，迭代->递推
     * @param n
     * @param memo
     * @return
     */
    public int fib2 (int n, int[] memo){
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < memo.length; i++){
            //状态转移方程
            memo[i] = memo[i - 1] + memo[ i - 2];
        }
        return memo[memo.length - 1];
    }

}
