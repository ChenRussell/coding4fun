package org.cr.leetcode.backpack;

/**
 * Created by ChenRui on 18-4-6
 * <p>
 * Given a non-empty array containing only positive integers, find if the array can be partitioned
 * into two subsets such that the sum of elements in both subsets is equal.
 * <p>
 * Note:
 * Each of the array element will not exceed 100.
 * The array size will not exceed 200.
 * Example 1:
 * <p>
 * Input: [1, 5, 11, 5]
 * <p>
 * Output: true
 * <p>
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: [1, 2, 3, 5]
 * <p>
 * Output: false
 * <p>
 * Explanation: The array cannot be partitioned into equal sum subsets.
 */
public class _416PartitionEqualSubsetSum {

    /**
     * This problem is essentially let us to find whether there are several numbers
     * in a set which are able to sum to a specific value (in this problem, the value is sum/2).
     * <p>
     * Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not.
     * Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers.
     * If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true,
     * otherwise it is false.
     * <p>
     * Base case: dp[0][0] is true; (zero number consists of sum 0 is true)
     * <p>
     * Transition function: For each number, if we don��t pick it, dp[i][j] = dp[i-1][j],
     * which means if the first i-1 elements has made it to j, dp[i][j] would also make it to j
     * (we can just ignore nums[i]). If we pick nums[i]. dp[i][j] = dp[i-1][j-nums[i]],
     * which represents that j is composed of the current value nums[i] and the remaining
     * composed of other previous numbers.
     * Thus, the transition function is dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]]
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        // �ж��Ƿ�Ϊ����
        if ((sum & 1) != 0) return false;
        int volumn = sum / 2;   // �����Ĵ�С

        boolean dp[][] = new boolean[nums.length][volumn + 1]; // ��һ�в���

        // ��ʼ��dp����
//        for (int j = 0; j < volumn+1; j++) {
////            dp[0][j] = false;
//            if (j >= nums[0]) dp[0][j] = true;
//        }

        // Ϊʲô��ô��ʼ��
        // ��һ�и�ֵtrue
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        // ��һ�и�ֵfalse
//        for (int j = 1; j < volumn+1; j++) {
//            dp[0][j] = false;
//        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= volumn; j++) {
                if (j < nums[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
            }
        }

        for (boolean[] aDp : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(aDp[j] + "\t");
            }
            System.out.println();
        }
        return dp[nums.length - 1][volumn];
    }

    // ʹ��һά����
    public boolean canPartition_1d(int nums[]) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) return false;

        // ������С
        int volumn = sum / 2;

        // dp[j]��ʾ������СΪjʱ���ܲ���װ��
        boolean dp[] = new boolean[volumn + 1];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = volumn; j > 0; j--) {  // ����ѭ��Ӧ�������棬ÿ�θ���dp����
                if (j >= nums[i]) dp[j] = dp[j] || dp[j - nums[i]]; // �±�
            }

            for (int k = 0; k < dp.length; k++) {
                System.out.print(dp[k] +"\t");
            }
            System.out.println();
        }
        return dp[volumn];
    }


    public static void main(String[] args) {
        int nums[] = {1, 5, 11, 5};
        int nums2[] = {1, 2, 5,6,4};
        boolean res = new _416PartitionEqualSubsetSum().canPartition(nums2);
        System.out.println("res: " + res);
    }
}
