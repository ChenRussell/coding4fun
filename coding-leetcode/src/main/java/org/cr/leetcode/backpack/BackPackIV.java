package org.cr.leetcode.backpack;

/**
 * Created by ChenRui on 18-4-7
 *
 *���������ģ��������+���п��ܽ����
 *
 * ��Ŀ������
 *
 *  Given an integer array nums with all positive numbers and no duplicates,
 *  find the number of possible combinations that add up to a positive integer target.
 * ��������
 *
 * [1,2,4],4
 * �������
 *
 * 6
 */
public class BackPackIV {

    public int backpack(int weight[], int target) {
        // dp[j]��ʾ������СΪjʱ��װ�����������п��ܽ������
        int dp[] = new int[target + 1];
        dp[0] = 1;

        for (int i = 0; i < weight.length; i++) {
            for (int j = 1; j < dp.length; j++) {   // ���ظ�ʹ��Ԫ��
                if (j>=weight[i]) dp[j] += dp[j - weight[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int weight[] = {1,2,3};
        int target = 5;
        int res = new BackPackIV().backpack(weight, target);
        System.out.println(res);
    }
}
