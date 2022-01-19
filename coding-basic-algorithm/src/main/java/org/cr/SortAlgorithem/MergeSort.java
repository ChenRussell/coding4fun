package org.cr.SortAlgorithem;

/**
 * Created by ChenRui on 18-3-10
 */
public class MergeSort {

    public void merge(int[] arr, int low, int high) {
        if (low < high) {
            int middle = (low + high) >> 1;
            merge(arr, low, middle);
            merge(arr, middle + 1, high);
            sort(arr, low, high);
        }
    }

    public void sort(int[] arr, int low, int high) {
        int left1 = low;
        int middle = (low + high) >> 1;
        int end1 = middle;
        int left2 = middle + 1;
        int end2 = high;
        int temp[] = new int[arr.length];
        int index = low;
        while (left1 <= end1 && left2 <= end2) {
            temp[index++] = arr[left1] < arr[left2] ? arr[left1++] : arr[left2++];
        }
        while (left1 <= end1) {
            temp[index++] = arr[left1++];
        }
        while (left2 <= end2) {
            temp[index++] = arr[left2++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(result, arr, start1, end1); // 交换顺序，可以不用做后面的操作
        merge_sort_recursive(result, arr, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
//        for (k = start; k <= end; k++)
//            arr[k] = result[k];
    }
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        int[] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[i];
        }
        merge_sort_recursive(arr, result, 0, len - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 5, 4};
        MergeSort mergeSort = new MergeSort();
//        mergeSort.merge(arr,0 ,arr.length-1);
        //MergeSort.mergeSort_practice(arr);
        mergeSort.mergeSortPractice_20220118(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void mergeSort_practice(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        mergeSort_practice(arr, res, 0, arr.length-1);
    }

    public static void mergeSort_practice(int[] arr, int[] res, int start, int end) {
        if (start >= end) return;
        int middle = (start + end) >> 1;
        int start1 = start, end1 = middle, start2 = middle+1, end2 = end;
        mergeSort_practice(res, arr, start1, end1);
        mergeSort_practice(res, arr, start2, end2);

        int index = start;
        while (start1 <= end1 && start2 <= end2) {
            res[index++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            res[index++] = arr[start1++];
        }
        while (start2 <= end2) {
            res[index++] = arr[start2++];
        }
    }

    public void mergeSortPractice_20220118(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        mergeSort_20220118(arr, res, 0, arr.length - 1);
    }

    public void mergeSort_20220118(int[] arr, int[] res, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1;
        mergeSort_20220118(res, arr, start, mid);
        mergeSort_20220118(res, arr, mid + 1, end);

        int start1 = start, start2 = mid + 1, end1 = mid, end2 = end;
        int index = start;
        while (start1 <= end1 && start2 <= end2) {
            res[index++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        }
        while (start1 <= end1) {
            res[index++] = arr[start1++];
        }
        while (start2 <= end2) {
            res[index++] = arr[start2++];
        }
    }
}
