package org.cr.leetcode;

/**
 * Created by ChenRui on 18-4-6
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * <p>
 * Each element in the array represents your maximum jump length at that position.
 * <p>
 * Determine if you are able to reach the last index.
 * <p>
 * For example:
 * A = [2,3,1,1,4], return true.
 * <p>
 * A = [3,2,1,0,4], return false.
 */
public class _55JumpGame {

    /**
     * ��Ŀ��˼�����ˣ�����ߵĲ�����maximum
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
//        int index = 0;
//        int value = nums[index];
//        do {
//            if (index + value > nums.length) {
//                return true;
//            } else {
//                index = index + value;
//                value = nums[index];
//            }
//            if (value == 0 && index<nums.length-1) return false;
//        } while (index+1 != nums.length);
        return true;
    }

    boolean canJump2(int nums[]) {
        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) {return false;}
            max = Math.max(nums[i]+i,max);  // max�������ߵ������λ��, ̰�Ĳ��ԣ���
            if (max > nums.length-1) return true;   // �Ż�ʱ�临�Ӷ�
        }
        return true;
    }

    public static void main(String[] args) {
        int nums[] = {3,2,1,0,4};
        boolean res = new _55JumpGame().canJump2(nums);
        System.out.println(res);
    }
}
