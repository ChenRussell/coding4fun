package com.nowcoder.SortAlgorithem;

/**
 * Created by ChenRui on 18-3-12
 */
public class QuickSort {

    /**
     * 麻痹,一样的代码得到的结果竟然不一样,你他妈是在逗我吗??????草
     * @param arr
     * @param start
     * @param end
     */
    public void sort(int arr[], int start, int end) {
        if (start >= end) return;
        int low = start, high = end;
        int pivot = (low + high) / 2;
        while (low <= high) {
            while (arr[high] > arr[pivot]) {
                high--;
            }
            while (arr[low] < arr[pivot]) {
                low++;
            }
            if (low < high) {
                int temp = arr[low];
                arr[low++] = arr[high];
                arr[high--] = temp;
            } else if (low == high) {
                low++;
            }
        }
        sort(arr, start, high);
        sort(arr, low, end);
    }

    public void quickSort(int arr[], int low, int high) {
        if (low >= high) return;
//        int index = sort(arr, low, high);
        int middle = (low + high) / 2;    // 此处不能用middle, 因为一趟排序得到的结果不一定是中间,这就是为什么应该放在一个函数里
        quickSort(arr, low, middle - 1);
        quickSort(arr, middle + 1, high);
    }

    public static void qSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
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
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    public static void main(String[] args) {
//        int[] arr = {1, 3, 4, 6, 5, 4};
        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        QuickSort mergeSort = new QuickSort();
        mergeSort.sort(arr, 0, arr.length - 1);
//        QuickSort.qSort(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println((5 - 3) >> 1);
        System.out.println(3 + (5 - 3) >> 1);   // 结果为2, 算术运算符 优先级 大于位运算符
    }
}
