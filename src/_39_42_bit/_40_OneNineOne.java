package _39_42_bit;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/submissions/
 */
public class _40_OneNineOne {
    /**
     * 一位一位的算，直接枚举
     *
     * @param n
     * @return
     */
    public int hammingWeight1(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    /**
     * 时间复杂度为1的个数
     * @param n
     * @return
     */

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
        return count;
    }
}
