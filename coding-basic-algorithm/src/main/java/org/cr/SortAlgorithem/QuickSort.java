package org.cr.SortAlgorithem;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by ChenRui on 18-3-12
 */
public class QuickSort {

    /**
     * 麻痹,一样的代码得到的结果竟然不一样,你他妈是在逗我吗??????草
     * -- 问题出在arr[pivot], 下标对应的值可能发生了变化
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
        while (i <= j) {  // 这里需要加等于号，否则会无限递归
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
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        qSort(arr, head, j);
        qSort(arr, i, tail);
    }

    public static void qSortV2(int[] arr, int head, int tail) {
        if (head >= tail) return;
        int index = partition(arr, head, tail);
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        qSortV2(arr, head, index-1);
        qSortV2(arr, index+1, tail);
    }

    static int partition(int[] arr, int start, int end) {
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
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
//        int[] arr = new int[]{1, 4, 8, 2, 55, 3, 4, 8, 6, 4, 0, 11, 34, 90, 23, 54, 77, 9, 2, 9, 4, 10};
        QuickSort mergeSort = new QuickSort();
//        mergeSort.sort(arr, 0, arr.length - 1);
        QuickSort.qSortV2(arr, 0, arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println((5 - 3) >> 1);
        System.out.println(3 + (5 - 3) >> 1);   // 结果为2, 算术运算符 优先级 大于位运算符
    }
}
