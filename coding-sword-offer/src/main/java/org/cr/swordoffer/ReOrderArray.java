package org.cr.swordoffer;

/**
 * Created by ChenRui on 18-3-9
 * <p>
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��
 * ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�����֤������������ż����ż��֮������λ�ò��䡣
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

    // ����ʾ��
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

    //��ȷʾ��
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
