package org.cr.leetcode.dynamicProgramming;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/24
 * <p>
 * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
 * <p>
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * A subarray is a contiguous subsequence of the array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: nums = [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 2 * 104
 * -10 <= nums[i] <= 10
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */
public class _152MaximumProductSubarray {

    /**
     * Two pointer Approach
     * Explanation :
     * 1.) Through intution explanation we know that if all the elements are positive or the negative elements are even then ur answer will be product of complete array which u will get in variable l and r at the last iteration.
     * 2.) But if negative elements are odd then u have to remove one negative element and it is sure that it will be either right of max prefix product or left of max suffix product. So u need not to modify anything in your code as u are getting prefix product in l and suffix prduxt in r.
     * 3.) If array also contains 0 then your l and r will become 0 at that point...then just update it to 1(or else u will keep multiplying with 0) to get the product ahead making another subarray.
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int l = 1, r = 1;
        int ans = nums[0];

        for (int i = 0; i < n; i++) {

            //if any of l or r become 0 then update it to 1
            l = l == 0 ? 1 : l;
            r = r == 0 ? 1 : r;

            l *= nums[i];   //prefix product
            r *= nums[n - 1 - i];    //suffix product

            ans = Math.max(ans, Math.max(l, r));

        }
        return ans;
    }

    /**
     * 思路与{@link _53MaximumSubarray}类似，只是多记录一个最小值
     * @param A
     * @return
     */
    int maxProduct2(int A[]) {
        // store the result that is the max we have found so far
        int r = A[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < A.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }

    private void swap(int imax, int imin) {
    }
}
