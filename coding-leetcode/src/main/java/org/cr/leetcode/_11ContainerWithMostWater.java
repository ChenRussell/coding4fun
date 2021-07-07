package org.cr.leetcode;

/**
 * Created by ChenRui on 2018/9/15.
 * <p>
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
public class _11ContainerWithMostWater {

    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        int head = 0, tail = height.length - 1;

        while (head < tail) {
            int area = Math.min(height[head], height[tail]) * (tail - head);
            max = Math.max(area, max);
            if (height[head] < height[tail]) head++;
            else tail--;
        }

        return max;
    }

    public static void main(String[] args) {
        _11ContainerWithMostWater containerWithMostWater = new _11ContainerWithMostWater();
        int res = containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        System.out.println(res);
    }
}
