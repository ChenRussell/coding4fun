package com.nowcoder.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 2018/4/5
 * <p>
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4.
 */
public class GetLeastKNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k>input.length) return res;
        int start = 0, end = input.length - 1;
        int index = patition(input, start, end);
        while (index != k) {
            if (index < k) {
                start = index + 1;
                index = patition(input, start, end);
            } else {
                end = index - 1;
                index = patition(input, start, end);
            }
        }

        for (int i = 0; i < index; i++) {
            res.add(input[i]);
        }
        return res;
    }

    int patition(int[] arr, int start, int end) {

        int temp;
        if (start < end)
            temp = arr[start];
        else return start;
        while (start < end) {
            while (start < end && arr[end] > temp) end--;
            if (start < end) arr[start++] = arr[end];
            while (start < end && arr[start] < temp) start++;
            if (start < end) arr[end--] = arr[start];
        }
        arr[start] = temp;
        return start;
    }

    public static void main(String[] args) {
        int input[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> res = new GetLeastKNumbers().GetLeastNumbers_Solution(input, k);
        System.out.println(res);
    }
}
