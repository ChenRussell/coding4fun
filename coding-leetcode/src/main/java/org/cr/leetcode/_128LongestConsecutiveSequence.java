package org.cr.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/12
 *
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * Example 2:
 *
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class _128LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        //if (nums.length == 1) return 1;
        Arrays.sort(nums);
        int maxLen = 1, len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) continue;
            else if (nums[i] == nums[i-1] + 1) {
                len++;
            } else {
                len = 1;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    /**
     * We will use HashMap. The key thing is to keep track of the sequence length and
     * store that in the boundary points of the sequence. For example,
     * as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.
     *
     * Whenever a new element n is inserted into the map, do two things:
     *
     * See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n.
     * Variables left and right will be the length of those two sequences, while 0 means
     * there is no sequence and n will be the boundary point later. Store (left + right + 1)
     * as the associated value to key n into the map.
     * Use left and right to locate the other end of the sequences to the left and right of n respectively,
     * and replace the value with the new length.
     * Everything inside the for loop is O(1) so the total time is O(n).
     * Please comment if you see something wrong. Thanks.
     * @param num
     * @return
     */
    public int longestConsecutive_voted(int[] num) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : num) {
            if (!map.containsKey(n)) {
                int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                // sum: length of the sequence n is in
                int sum = left + right + 1;
                map.put(n, sum);

                // keep track of the max length
                res = Math.max(res, sum);

                // extend the length to the boundary(s)
                // of the sequence
                // will do nothing if n has no neighbors
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                // duplicates
                continue;
            }
        }
        return res;
    }
}
