package org.cr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/17
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Explanation: [4,9] is also accepted.
 *
 *
 * Constraints:
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class _349IntersectionofTwoArrays {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        int[] hashTable = new int[1001];
        for (int i = 0; i < nums1.length; i++) {
            hashTable[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hashTable[nums2[i]] > 0) {
                list.add(nums2[i]);
                hashTable[nums2[i]] = 0;
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
