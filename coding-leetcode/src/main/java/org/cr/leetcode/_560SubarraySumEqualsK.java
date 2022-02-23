package org.cr.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/22
 *
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 *
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 */
public class _560SubarraySumEqualsK {

    /**
     * 与{@link _1TowSum} 类似
     *
     * Solution 1. Brute force. We just need two loops (i, j) and test if SUM[i, j] = k.
     * Time complexity O(n^2), Space complexity O(1). I bet this solution will TLE.
     *
     * Solution 2. From solution 1, we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j],
     * then we can easily get SUM[i, j]. To achieve this, we just need to go through the array,
     * calculate the current sum and save number of all seen PreSum to a HashMap. Time complexity O(n), Space complexity O(n).
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> preSum = new HashMap<>();
        int res = 0, sum = 0;
        preSum.put(0, 1); // 应对sum[i, j]中i=0的情况
        for (int num : nums) {
            sum += num;
            if (preSum.containsKey(sum - k)) {
                res += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
