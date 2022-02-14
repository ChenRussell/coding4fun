package org.cr.leetcode;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/12
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Example 2:
 *
 * Input: height = [4,2,0,3,2,5]
 * Output: 9
 *
 *
 * Constraints:
 *
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 * Accepted
 * 1,022,779
 * Submissions
 * 1,839,000
 */
public class _42TrappingRainWater {

    /**
     * Here is my idea: instead of calculating area by height*width, we can think it in a cumulative way.
     * In other words, sum water amount of each bin(width=1).
     * Search from left to right and maintain a max height of left and right separately,
     * which is like a one-side wall of partial container.
     * Fix the higher one and flow water from the lower part.
     * For example, if current height of left is lower, we fill water in the left bin.
     * Until left meets right, we filled the whole container.
     */
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = 0, maxRight = 0, res = 0;
        while(left <= right) {
            if(height[left] <= height[right]) {
                if(height[left] >= maxLeft) maxLeft = height[left];
                else res += maxLeft - height[left];
                left++;
            } else {
                if(height[right] >= maxRight) maxRight = height[right];
                else res += maxRight - height[right];
                right--;
            }
        }
        return res;
    }
}
