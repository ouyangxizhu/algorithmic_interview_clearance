package _39_42_bit;

/**
 * https://leetcode-cn.com/problems/counting-bits/
 */
public class _41_ThreeThreeEight {
    /**
     * 方法1：找规律，第i组（2^(i-1)-(2^i-1)）为前i-1组所有数字+1（首位1）
     * 数字	     \	\	\	\	\	\	\	\
     * 0								    0
     * 1								    1
     * 2 - 3							1	2
     * 4 - 7					1	2	2	3
     * 8 - 15	1	2	2	3	2	3	3	4
     *
     *
     * @param num
     * @return
     */
    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        int i = 1, j = 0, len = 1;
        while (i <= num) {
            while (i <= num && j < len) {
                result[i++] = result[j++] + 1;
            }
            j = 0;
            len <<= 1;
        }
        return result;
    }
    /**
     * 方法2：i & (i - 1)去掉i最右边的一个1；
     * 因i & (i - 1）< i，故result[i & (i - 1)]已计算，所以i中1的个数为result[i & (i - 1)] + 1
     *
     * @param num
     * @return
     */
    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }
    /**
     * 方法3：i >> 1去掉i的最低位；
     * 因(i >> 1) < i，故result[i >> 1]已计算，因此i中1的个数为i >> 1中1的个数加最后一位1的个数，
     * 即为result[i >> 1] + (i & 1)
     *
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i <= num; ++i) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
