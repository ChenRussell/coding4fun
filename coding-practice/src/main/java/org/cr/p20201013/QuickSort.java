package org.cr.p20201013;


/**
 * @Description
 * @auther chenrui
 * @create 2020-10-13 17:01
 */
public class QuickSort {

    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int i = start, j = end;
        int pivot = arr[(i + j) / 2]; // 为什么这里用下标结果会有问题？？ int pivot = (i+j)/2
        int pivot2 = (i + j) / 2;
        System.out.println("###" + pivot + " === " + arr[pivot2]);
        while (i <= j) {
            while (arr[i] < arr[pivot2]) {
                i++;
            }
            while (arr[j] > arr[pivot2]) {
                j--;
            }
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else if (i == j) {
                i++;
            }
        }
        quickSort(arr, start, j);
        quickSort(arr, i, end);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        quickSort(arr, 0, arr.length - 1);
//        QuickSort.qSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
