package com.nowcoder.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class _41_1_FindNumbersWithSum {

    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        int head = 0, tail = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (head < tail) {
            if (array[head] + array[tail] == sum) {
                list.add(array[head]);
                list.add(array[tail]);
                return list;
            } else if (array[head] + array[tail] < sum) {
                head++;
            } else {
                tail--;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        _41_1_FindNumbersWithSum findNumbersWithSum = new _41_1_FindNumbersWithSum();
        ArrayList<Integer> res = findNumbersWithSum.findNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15);
        System.out.println(res);

    }
}
