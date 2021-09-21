package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/06
 *
 * Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ?n / 2? times.
 * You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 5 * 104
 * -231 <= nums[i] <= 231 - 1
 *
 *
 * Follow-up: Could you solve the problem in linear time and in O(1) space?
 */
public class _169MajorityElement {

    public int majorityElement(int[] nums) {
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
                if (count < 0) {
                    res = nums[i];
                    count = 1;
                }
            }
        }
        return res;
    }
}
