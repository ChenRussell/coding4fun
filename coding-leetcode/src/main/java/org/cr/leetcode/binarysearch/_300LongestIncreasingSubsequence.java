package org.cr.leetcode.binarysearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/18
 *
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Example 2:
 *
 * Input: nums = [0,1,0,3,2,3]
 * Output: 4
 * Example 3:
 *
 * Input: nums = [7,7,7,7,7,7,7]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 *
 *
 * Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */
public class _300LongestIncreasingSubsequence {

    /**
     * This algorithm is actually Patience sorting. It might be easier for you to understand how it works if you think about it as piles of cards instead of tails. The number of piles is the length of the longest subsequence.
     * For more info see Princeton lecture(https://www.cs.princeton.edu/courses/archive/spring13/cos423/lectures/LongestIncreasingSubsequence.pdf).
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            int index = Collections.binarySearch(res, num);
            if (index < 0) index = -index-1;
            if (index == res.size()) {
                res.add(num);
            } else {
                res.set(index, num);
            }
        }
        return res.size();
    }
}
