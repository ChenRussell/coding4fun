package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-4-18
 *
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，
 * 打印出s所有可能的值出现的概率
 *
 * 思路：
 * 应用动态规划。
 * 本题的最优子结构为:F(k,n)表示k个骰子点数和为n的种数，k表示骰子个数，n表示k个骰子的点数和
 * F(k,n) = F(k-1,n-1)+F(k-1,n-2)+F(k-1,n-3)+F(k-1,n-4)+F(k-1,n-5)+F(k-1,n-6), 对于k>0,k<=n<=6*k
 * F(k,n) = 0, 对于n<k or n>6*k
 * 当k=1, F(1,1)=F(1,2)=F(1,3)=F(1,4)=F(1,5)=F(1,6)=1
 *
 * 从上面公式可以看出，k个骰子点数和为n的种数只与k-1个骰子的和有关。这就可以用到备忘录的方法，
 * 用一张表格保存已解决的子问题的解，然后自底向上填表。考虑到当前层的计算只与下一层有关，因此只需保存一行。
 */
public class _43PrintProbability {

    static final int FACE_NUMBER = 6; // 骰子的面数

    /**
     * 函数功能：n个骰子的点数
     * 函数参数：number is number of touzi
     * @param number
     */
    static void printProbability(int number) {

        if(number <= 0) return;

        int dp[] = new int[number * FACE_NUMBER + 1]; // dp[j]表示和为j的种类数

        double total = Math.pow(6.0, number);
        int size = number * FACE_NUMBER;

        // initialize
        dp[0] = 0;
        for (int i = 1; i <= FACE_NUMBER; i++) {
            dp[i] = 1;
        }
        for (int i = FACE_NUMBER + 1; i <= size; i++) {
            dp[i] = 0;
        }

        for (int i = 2; i <= number; i++) { // 骰子的个数从2到number
            // 从后往前赋值，避免将上一层的元素覆盖掉，从而只需要使用一个数组
            for (int j = i * FACE_NUMBER; j >= i; j--) { // i个骰子和的范围为 [i, i*FACE_NUMBER]
                dp[j] = 0;
                for (int k = 1; k <= 6 && j >= k; k++) {
                    dp[j] += dp[j - k];
                }
            }

            // for impossible cases:点数小于骰子的个数
            for (int j = i - 1; j >= 0; j--) {
                dp[j] = 0;
            }
        }

        for (int i = 0; i <= size; i++) {
            System.out.println("sum= "+i +" ,p=" + String.format("%.8f", dp[i]/total));
        }
    }

    public static void main(String[] args) {
        printProbability(8);
    }
}
