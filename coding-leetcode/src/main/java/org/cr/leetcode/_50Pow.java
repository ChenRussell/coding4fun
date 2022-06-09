package org.cr.leetcode;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/01/20
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 */
public class _50Pow {

    // 0^0 = 1
    public double myPow(double x, int n) {
        double res = 1;
        int absN = Math.abs(n);
        for (int i = 1; i <= absN; i++) {
            res *= x;
        }
        //if (x == 0) return 0;
        if (n < 0) return 1 / res;
        return res;
    }

    /**
     * public double pow(double x, int n) {
     *         if(n == 0)
     *             return 1;
     *         if(n<0){
     *             n = -n;
     *             x = 1/x;
     *         }
     *         return (n%2 == 0) ? pow(x*x, n/2) : x*pow(x*x, n/2);
     *     }
     * @param x
     * @param n
     * @return
     */
    // avoid integer overflow
    public double myPow_voted(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            return 1/x * myPow(1/x, -(n + 1));
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}
