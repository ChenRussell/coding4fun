package org.cr.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 2018/4/5
 * <p>
 * 题目描述
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4.
 */
public class _30_KLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (k > input.length) return res;
        int start = 0, end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k) {
            if (index < k) {
                start = index + 1;
                index = partition(input, start, end);
            } else {
                end = index - 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < index; i++) {
            res.add(input[i]);
        }
        return res;
    }

    int partition(int[] arr, int start, int end) {

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

    //不能用这种
    int partition2(int[] arr, int head, int tail) {
        if (head >= tail) return head;
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int input[] = {4, 5, 1, 6, 2, 7, 3, 8};
        int k = 4;
        ArrayList<Integer> res = new _30_KLeastNumbers().GetLeastNumbers_Solution(input, k);
        System.out.println(res);
    }
    // 4,5,1,3,2, 7,6,8
    // 1, 5,4,3,2, 6,7,8
    // 1, 2,3,4,5, 6,7,8
}
