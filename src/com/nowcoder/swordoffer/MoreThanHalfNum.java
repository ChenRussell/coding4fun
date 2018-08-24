package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 2018/4/5
 * 目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int[] array) {
        int count = 1;
        int flag = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != flag) {
                count--;
            } else count++;
            if (count == 0) {
                flag = array[i];
                count = 1;
            }
        }
//        System.out.println(count);
        // 再遍历一次
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == flag) count++;
        }
        if (count*2>array.length) return flag;
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int arr2[] = {1, 2, 3, 2, 4, 2, 5, 2, 3};
        int arr3[] = {2,2,2,2,2,1,3,4,5};
        int res = new MoreThanHalfNum().MoreThanHalfNum_Solution(arr3);
        System.out.println(res);
    }
}
