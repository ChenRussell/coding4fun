package org.cr.p20201013;

/**
 * @Description
 * @auther chenrui
 * @create 2020-10-14 17:24
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
        int middle = (low + high) / 2;
        int low1 = low, high1 = middle, low2 = middle + 1, high2 = high;
        int index = low;
        int temp[] = new int[arr.length];
        while (low1 <= high1 && low2 <= high2) {
            temp[index++] = arr[low1] < arr[low2] ? arr[low1++] : arr[low2++];
        }
        while (low1 <= high1) {
            temp[index++] = arr[low1++];
        }
        while (low2 <= high2) {
            temp[index++] = arr[low2++];
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 6, 5, 4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
