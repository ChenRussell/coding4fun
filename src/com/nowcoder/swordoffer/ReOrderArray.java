package com.nowcoder.swordoffer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenRui on 18-3-9
 * <p>
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOrderArray {
    public void reOrderArray(int[] array) {
        int start = 0, end = array.length-1;
        while (start < end) {
            while (array[start] % 2 != 0) {
                start++;
            }
            while (array[end] % 2 == 0) {
                end--;
            }
            if (start < end) {
                int temp = array[start];
                array[start++] = array[end];
                array[end--] = temp;
            }
        }
    }

    public void bubbleSort(int[] arr) {
        int i, temp, len = arr.length;
        boolean changed;
        do {
            changed = false;
            for (i = 0; i < len - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    changed = true;
                }
            }
        } while (changed);
    }

    // 错误示范
    public void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    //正确示范
    public void bubbleSort3(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
        }
    }

    private void reOrderArray2(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j] % 2 == 0 && arr[j + 1] % 2 == 1) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j+1] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        ReOrderArray obj = new ReOrderArray();
        int[] arr = {2,6,3,4,5,1};
//        obj.reOrderArray(arr);
//        obj.bubbleSort3(arr);
        obj.reOrderArray2(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
