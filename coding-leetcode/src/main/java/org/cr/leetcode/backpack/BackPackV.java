package org.cr.leetcode.backpack;

/**
 * Created by ChenRui on 18-4-7
 *
 * ���������壨�������+���п��ܽ��+��ͬ���У�
 *
 * ��Ŀ������
 *
 *  Given n items with size nums[i] which an integer array and all positive numbers.
 *  An integer target denotes the size of a backpack. Find the number of possible fill the backpack.
 *  Each item may only be used once
 * �������룺
 *
 * [1,2,3,3,7],7
 * ���������
 *
 * 2
 */
public class BackPackV {

    public int backpack(int weight[], int target) {
        // dp[j]��ʾ������СΪjʱ��װ�����������п��ܽ���������ظ�ʹ�ã�
        int dp[] = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < weight.length; i++) {
            for (int j = target; j > 0; j--) {
                if (j>=weight[i]) dp[j] += dp[j - weight[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int weight[] = {2, 2, 2, 3, 3, 3};
        int weight2[] = {1,2,3};
        int k = 5;
        int res = new BackPackV().backpack(weight2, 4);
        System.out.println(res);
    }
}
