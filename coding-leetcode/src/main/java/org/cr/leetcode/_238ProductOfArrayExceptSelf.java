package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/08
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * Example 2:
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 105
 * -30 <= nums[i] <= 30
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 *
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)
 */
public class _238ProductOfArrayExceptSelf {

    /**
     * Given numbers [2, 3, 4, 5], regarding the third number 4,
     * the product of array except 4 is 2*3*5 which consists of two parts: left 2*3 and right 5.
     * The product is left*right. We can get lefts and rights:
     *
     * Numbers:     2    3    4     5
     * Lefts:            2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5
     * Let¡¯s fill the empty with 1:
     *
     * Numbers:     2    3    4     5
     * Lefts:       1    2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5     1
     * We can calculate lefts and rights in 2 loops. The time complexity is O(n).
     *
     * We store lefts in result array. If we allocate a new array for rights. The space complexity is O(n).
     * To make it O(1), we just need to store it in a variable which is right in @lycjava3¡¯s code.
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int left = 1, right = 1;
        // Calculate lefts and store in res.
        for(int i = 0; i < nums.length; i++) {
            if(i > 0) left *= nums[i-1];
            res[i] = left;
        }
        // Calculate rights and the product from the end of the array.
        for(int i = nums.length-1; i >= 0; i--) {
            if(i < nums.length-1) right *= nums[i+1];
            res[i] *= right;
        }

        return res;
    }
}
