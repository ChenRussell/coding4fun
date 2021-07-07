package org.cr.leetcode.Bfs;

import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

/**
 * Created by ChenRui on 18-4-8
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * For example:
 * Given array A = [2,3,1,1,4]
 *
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * Note:
 * You can assume that you can always reach the last index.
 */
public class _45JumpGameII {

    /**
     * ����д���ˣ�����
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int count = 0; // ��Ҫ������ʲôʱ��count����, ����������ӵ�ʱ����count��������ôʵ��
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);     // �����д洢Ԫ���±�
        int max = 0;
        if (nums.length == 1) return 0;
        int tag = 0;    // ������¼ÿһ�����һ��Ԫ��

        while(!queue.isEmpty()){
            Integer pop = queue.poll();
            if (pop == max) count++;
            Integer last = ((LinkedList<Integer>) queue).pollLast();
            max = pop + nums[pop];

//            count++;
            if (pop == nums.length-1) return count;
            boolean flag = false;
            // ѭ�������
            for (int i = pop + 1; i <= pop + nums[pop]; i++) {
                if (i >= nums.length) break;
                if (!queue.contains(i)) {   // ����������Ѿ����ڸ�Ԫ�أ�������
//                    if (!flag) count++; // ��������ʱ���������һ��ֻ������һ��
//                    flag = true;
                    queue.offer(i); // �������в��������±������
                }
                if (i == nums.length-1) return count;
            }

        }
        return count;
    }

    /**
     * Explanation
     *
     * The main idea is based on greedy. Let��s say the range of the current jump is
     * [curBegin, curEnd], curFarthest is the farthest point that all points in [curBegin, curEnd]
     * can reach. Once the current point reaches curEnd, then trigger another jump,
     * and set the new curEnd with curFarthest, then keep the above steps, as the following:
     * @param A
     * @return
     */
    int jump2(int A[]) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < A.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + A[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    int jumpV_official(int A[], int n) {
        if(n<2)return 0;
        int level=0,currentMax=0,i=0,nextMax=0;

        while(i<=currentMax){		//nodes count of current level>0
            level++;
            for(;i<=currentMax;i++){	//traverse current level , and update the max reach of next level
                nextMax=max(nextMax,A[i]+i);
                if(nextMax>=n-1)return level;   // if last element is in level+1,  then the min jump=level
            }
            currentMax=nextMax;
        }
        return 0;
    }

    public static void main(String[] args) {
        int nums[] = {2,3,1,1,4};
        int nums2[] = {1, 2,1,1,1};
        int nums3[] = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};
        int res = new _45JumpGameII().jump2(nums);
        System.out.println(res);
    }
}
