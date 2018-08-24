package com.nowcoder.campusExam.ctrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 交换数组中为0的元素到前面，非零的元素相对顺序不变
 */
public class Main1 {

    public static void swap(List<Integer> arr, int j) {
        Integer temp = arr.get(j);
        arr.set(j, arr.get(j - 1));
        arr.set(j - 1, temp);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
//        ArrayList<Integer> arr2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            arr.add(x);
        }

        for (int i = 0; i < arr.size(); i++) {
            for (int j = arr.size()-1; j >i ; j--) {
                if (arr.get(j) != 0 && arr.get(j-1) == 0) {
                    swap(arr,j);
                }

            }
        }

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
