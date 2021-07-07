package org.cr.leetcode.backpack;

/**
 * Created by ChenRui on 18-4-7
 *
 * ����������������ֵ+���ظ�ѡ��
 *
 * ��Ŀ����
 *
 *  Given n kind of items with size Ai and value Vi( each item has an infinite number available)
 *  and a backpack with size m.
 *  What's the maximum value can you put into the backpack?
 * ��������
 *
 * 10,[2,3,5,7],[1,5,2,4]
 * �������
 *
 * 15
 */
public class BackPackIII {

    public int backpackIII(int weight[], int value[], int m) {
        // dp[j] ��ʾ������СΪjʱ���ܷŵ�����ֵ��Ԫ�ؿ����ظ�ѡ��
        int[] dp = new int[m + 1];
//        dp[0] = 0;

        for (int i = 0; i < weight.length; i++) {
            for (int j = 1; j < dp.length; j++) {   // left-> right ��ʾ���ظ�ѡ��
                if (j >= weight[i]) dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
            }

            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k] + " ");
            }
            System.out.println();
        }

        return dp[m];
    }

    public static void main(String[] args) {
        int weight[] = {2, 3, 5, 7};
        int value[] = {1,5,2,4};
        int m = 10;
        int res = new BackPackIII().backpackIII(weight, value, m);
        System.out.println(res);
    }
}
