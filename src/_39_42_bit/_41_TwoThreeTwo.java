package _39_42_bit;

/**
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class _41_TwoThreeTwo {
    /**
     * 位运算
     *
     * 也可以log2是不是整数计算
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n>0){
            return (n & (n-1)) == 0 ;
        }else{
            return false;
        }
    }
}
