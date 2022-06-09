package org.cr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/08
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 * Example 2:
 *
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * Example 3:
 *
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 *
 *
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */
public class _1TowSum {

    public int[] twoSum_voted(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int[] numsBak = new int[nums.length];
        for(int i=0; i < nums.length; i++){
            numsBak[i] = nums[i];
        }
        Arrays.sort(nums);
        int i = 0, j = nums.length-1;
        while(i < j) {
            if(nums[i] + nums[j] > target) j--;
            else if(nums[i] + nums[j] < target) i++;
            else return findIndex(numsBak,nums[i], nums[j]);
        }
        return res;
    }

    public int[] findIndex(int[] nums, int first, int second){
        int x=0,y=0;
        int i = 0, j = 0;
        for(i = 0, j=nums.length-1; i < nums.length && j>=0; i++,j--){
            if(nums[i] == first) x=i;
            if(nums[j] == second) y=j;
        }
        return new int[]{x,y};
    }

    public static void main(String[] args) {
        int[] res = new _1TowSum().twoSum(new int[]{3, 3}, 6);
        Arrays.stream(res).forEach(System.out::println);
    }
}
