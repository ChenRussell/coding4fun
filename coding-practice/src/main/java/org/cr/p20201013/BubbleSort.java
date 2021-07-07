package org.cr.p20201013;

/**
 * @Description
 * @auther chenrui
 * @create 2020-10-13 17:46
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        boolean flag = true;
        for (int i = 0; i < arr.length && flag; i++) {
            flag = false;
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        bubbleSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
