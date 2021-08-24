package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/23
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day
 * in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 *
 *
 * Constraints:
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class _121BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                res = Math.max(res, prices[j] - prices[i]);
            }
        }
        return res;
    }

    /**
     * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm.
     * Since no body has mentioned this so far, I thought it's a good thing for everybody to know.
     *
     * All the straight forward solution should work,
     * but if the interviewer twists the question slightly by giving the difference array of prices,
     * Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.
     *
     * Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array,
     *   and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
     * @param prices
     * @return
     */
    public int maxProfit_voted(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        _121BestTimetoBuyandSellStock obj = new _121BestTimetoBuyandSellStock();
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(obj.maxProfit(arr));
    }
}
