package org.cr.leetcode;

import java.util.Arrays;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/26
 *
 * Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
 *
 * Since the result may be very large, so you need to return a string instead of an integer.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 *
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 109
 */
public class _179LargestNumber {

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        //Arrays.sort(arr, (o1, o2) -> (int) (Long.parseLong(o2 + o1) - Long.parseLong(o1 + o2)));
        Arrays.sort(arr, (o1, o2) -> (o2+o1).compareTo(o1+o2));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        if (sb.toString().startsWith("0")) {
            return "0";
        }
        return sb.toString();
    }
}
