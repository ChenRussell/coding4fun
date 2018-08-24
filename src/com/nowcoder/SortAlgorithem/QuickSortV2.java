package com.nowcoder.SortAlgorithem;

import java.util.Arrays;

/**
 * Created by ChenRui on 18-3-14
 */
public class QuickSortV2 {

    int sort(int arr[], int i, int j) {
        int temp = arr[i];
//        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[j] > temp) {
                j--;
            }
            if (i < j) {
                arr[i] = arr[j];
                ++i;
            }
            while (i < j && arr[i] < temp) {
                i++;
            }
            if (i < j) {
                arr[j] = arr[i];
                --j;
            }
        }
        arr[i] = temp;
        return i;
    }

    void quickSort(int arr[], int i, int j) {
        if (i < j) {
            int index = sort(arr, i, j);
            quickSort(arr, i, index - 1);
            quickSort(arr, index+1, j);
        }
    }

    public static void main(String[] args) {
        QuickSortV2 quickSortV2 = new QuickSortV2();
        int arr[] = new int[]{3,5,3,0,8,6,1,5,8,6,2,4,9,4,7,0,1,8,9,7,3,1,2,5,9,7,4,0,2,6};
        quickSortV2.quickSort(arr, 0 ,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
