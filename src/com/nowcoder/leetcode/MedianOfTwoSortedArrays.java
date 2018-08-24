package com.nowcoder.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeSet;

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
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            set.add(nums2[i]);
        }
        Collections.sort(set);
        int count = 0;
        int result = 0;
        int mode = set.size() % 2;
        int divide = set.size() / 2;
//        for (Integer i :
//                set) {
//            count++;
//
//            if (mode == 0 && count== divide){
//                result += i;
//            }
//            if (mode == 0 && count == divide + 1) {
//                result += i;
//                return result/2.0;
//            }
//            if (mode == 1 && count==divide+1) {
//                return i;
//            }
//        }
        if(mode == 0) return (set.get(divide)+set.get(divide-1))/2.0;
        else return set.get(divide);
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays obj = new MedianOfTwoSortedArrays();
        int[] nums1 = {1, 1};
        int[] nums2 = {2, 2};
        double md = obj.findMedianSortedArrays(nums1, nums2);
        System.out.println(md);

    }
}