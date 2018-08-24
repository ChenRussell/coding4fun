package com.nowcoder.campusExam.huawei;

import java.util.Scanner;

import static java.lang.Math.max;

public class Ttwo2 {

    /**
     * BFS, 广度优先搜索
     * @param nums
     * @param len
     * @return
     */
    static int jump(int nums[], int len) {
        if (len < 2) return 0;
        int level = 0;
        int now = 0;
        int i = 0;
        int next = 0;

        while (i <= now) {
            level++;
            for (; i <= now; i++) {
                next = max(next, nums[i] + i);
                if (len - 1 <= next) return level;
            }
            now = next;
        }
        return 0;
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
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int res = jump(nums, n);
        System.out.println(res);
    }
}
