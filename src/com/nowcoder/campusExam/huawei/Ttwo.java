package com.nowcoder.campusExam.huawei;

import java.util.Scanner;

/**
 * 给出一组正整数，你从第一个数向最后一个数方向跳跃，每次至少跳跃1格，每个数的值表示你从这个位置可以跳跃的最大长度。计算如何以最少的跳跃次数跳到最后一个数。
 * <p>
 * 输入描述:
 * 第一行表示有多少个数n
 * 第二行开始依次是1到n个数，一个数一行
 * 输出描述:
 * 输出一行，表示最少跳跃的次数。
 * 示例1
 * 输入
 * 7
 * 2
 * 3
 * 2
 * 1
 * 2
 * 1
 * 5
 * 输出
 * 3
 * 说明
 * 7表示接下来要输入7个正整数，从2开始。数字本身代表可以跳跃的最大步长，此时有2种跳法，为2-2-2-5和2-3-2-5都为3步
 */
public class Ttwo {

    static boolean canJump(int nums[]) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);  // max代表能走到的最大位置
            if (max > nums.length - 1) return true;   // 优化时间复杂度
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }

        boolean bool = canJump(nums);
        if (bool) {
            int max = Integer.MIN_VALUE;
            int end = 0;
            int res = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                max = Math.max(nums[i], max);

                if (i == end) {
                    res++;
                    end = max;
                }
            }

            System.out.println(res);
        } else System.out.println(0);


    }
}
