package org.cr.p20201013;

/**
 * @Description
 * @auther chenrui
 * @create 2020-10-13 17:56
 */
public class InsertSort {

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        insertSort(arr);
        for (int i : arr) {
            System.out.print(i + ",");
        }
    }
}
