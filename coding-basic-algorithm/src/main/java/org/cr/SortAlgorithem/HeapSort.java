package org.cr.SortAlgorithem;

import java.util.Arrays;

/**
 * Created by ChenRui on 18-3-14
 */
public class HeapSort {

    void makeHeap(int[] arr) {
        // 从第一个非叶子节点开始
//        for (int i = 0; i < arr.length; i++) {
//            heap(arr, i, arr.length-1);
//        }
        int len = arr.length - 1;
        int index = (len - 1) / 2;  // 第一个非叶子节点？
        for (int i = index; i >= 0; i--) {
            heap(arr, i, len);
        }
    }

    // 调整堆
    void heap(int[] arr, int start, int end) {
        if (start >= end) return;
        int leftChild = 2 * start + 1;
        int rightChild = 2 * start + 2;
        // 可能没有右子树，没有右子树时直接用左子树，有右子树时比较一个最大值，得到下标
        if (leftChild > end) return;
        int max = leftChild;
        if (rightChild <= end && arr[rightChild] > arr[max]) max = rightChild;
//        max = arr[leftChild] > arr[rightChild] ? leftChild : rightChild;
//        for (int i = start; i<=end; i++){
//            int max = arr[2*i+1]>arr[2*i+2]?(2*i+1):(2*i+2);
        if (arr[start] < arr[max]) {
            swap(arr, start, max);
            heap(arr, max, end);
        }
//        }
    }

    void swap(int[] arr, int x, int y) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    void heapSort(int[] arr) {
        makeHeap(arr); // make一个大顶堆
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            swap(arr, 0, arr.length - 1 - i);
            heap(arr, 0, arr.length - 2 - i);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] arr = new int[]{3, 5, 3, 0, 8, 6, 1, 5, 8, 6, 2, 4, 9, 4, 7, 0, 1, 8, 9, 7, 3, 1, 2, 5, 9, 7, 4, 0, 2, 6};
        heapSort.heapSort_practice(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void heapSort_practice(int[] arr) {
        makeHeap_practice(arr);
        for (int i = 0; i < arr.length; i++) {
            swap2(arr, 0, arr.length - 1 - i);
            adjustHeap(arr, 0, arr.length - 2 - i);
        }
    }

    private void makeHeap_practice(int[] arr) {
        int lastIndex = arr.length - 1;
        int lastNoLeafIndex = (lastIndex - 1) / 2;
        for (int i = lastNoLeafIndex; i >= 0; i--) {
            adjustHeap(arr, i, lastIndex);
        }
    }

    private void adjustHeap(int[] arr, int start, int end) {
        if (start >= end) return;
        int leftChildIndex = start * 2 + 1;
        int rightChildIndex = start * 2 + 2;
        if (leftChildIndex > end) return;
        int maxIndex = leftChildIndex;
        if (rightChildIndex <= end && arr[rightChildIndex] > arr[maxIndex]) maxIndex = rightChildIndex;
        if (arr[start] < arr[maxIndex]) {
            swap2(arr, start, maxIndex);
            adjustHeap(arr, maxIndex, end);
        }
    }

    private void swap2(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
