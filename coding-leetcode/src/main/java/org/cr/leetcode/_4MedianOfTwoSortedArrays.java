package org.cr.leetcode;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ChenRui on 18-3-5
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class _4MedianOfTwoSortedArrays {

    /**
     * 时间复杂度为O(m+n)，不符合题目要求
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int[] nums = new int[m+n];
        int idx1 = 0, idx2 = 0, idx = 0;
        while(idx1 < m && idx2 < n) {
            if(nums1[idx1] < nums2[idx2]) {
                nums[idx++] = nums1[idx1++];
            } else {
                nums[idx++] = nums2[idx2++];
            }
        }
        while(idx1 < m) {
            nums[idx++] = nums1[idx1++];
        }
        while(idx2 < n) {
            nums[idx++] = nums2[idx2++];
        }
        int size = m + n;
        if(size == 0) return 0;
        if((size & 1) == 1) {
            return nums[size / 2] * 1.0;
        } else {
            return (nums[size/2] + nums[size/2-1])/ 2.0;
        }
    }

    public static void main(String[] args) {
        _4MedianOfTwoSortedArrays obj = new _4MedianOfTwoSortedArrays();
        int[] nums1 = {1, 1};
        int[] nums2 = {2, 2};
        double md = obj.findMedianSortedArrays(nums1, nums2);
        System.out.println(md);

    }
}
