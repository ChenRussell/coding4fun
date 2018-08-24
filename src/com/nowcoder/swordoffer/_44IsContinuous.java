package com.nowcoder.swordoffer;

import java.util.Arrays;

/**
 * Created by ChenRui on 18-4-17
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2~10为数字本身，A为1，J为11，
 * Q为12，K为13，，而大小王可以看成任意数字。
 */
public class _44IsContinuous {

    static public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) return false;
        Arrays.sort(numbers);
        int count0 = 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) count0++;
        }

        // 统计间隔的个数，与大小王的个数相比。如果大于则返回false
        for (int i = count0; i < numbers.length-1; i++) {
            // 如果有重复的元素，直接返回false
            if (numbers[i+1] == numbers[i]) return false;
            count += numbers[i+1]-numbers[i]-1;
        }
        if (count>count0) return false;
        else return true;
    }

    public static void main(String[] args) {
        int num[] = {1,2,3,6,0};
        boolean res = isContinuous(num);
        System.out.println(res);
    }
}
