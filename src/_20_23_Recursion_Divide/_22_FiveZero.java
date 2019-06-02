package _20_23_Recursion_Divide;

public class _22_FiveZero {
    /**
     * 递归
     * @param x
     * @param n
     * @return
     */
    public static double myPow(double x, int n) {

        if (n == 0) return 1.0;
        //有一个算例n为Integer.MIN_VALUE,-Integer.MIN_VALUE = Integer.MIN_VALUE会导致栈溢出
        //这句话要放在前面
        if ((n & 1) != 1) return myPow(1.0 * x * x, n/2);
        if(n < 0) return 1.0/myPow(x, -n);
        else return 1.0 * myPow(x, n - 1) * x;

    }

    /**
     * 循环
     * @param x
     * @param n
     * @return
     */
    public static double myPow2(double x, int n) {

        if (n == 0) return 1.0;
        if (n < 0){
            x = 1.0/x;
            n = - n;
        }
        double res = 1;
        while (n != 0){
            if((n & 1) ==1){
                res *= x;
            }
            x *= x;
            n /= 2;//n >>= 2不行，会栈溢出
        }
        return res;

    }

}
