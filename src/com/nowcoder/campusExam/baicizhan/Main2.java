package com.nowcoder.campusExam.baicizhan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 判断数组中子集求和是否能为k
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        int k;
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            if (nums[i] == 0) hasZero = true;
        }
        k = sc.nextInt();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        boolean res = check(nums, k, arr, 0, lists);
//        if (k==0 && hasZero) res = true;
        System.out.println(res);
        System.out.println(lists);
    }

    static boolean f = false;
    private static boolean check(int[] nums, int k, List<Integer> arr, int start, List<List<Integer>> lists) {
        if (k == 0 && arr.size() >= 1) {
            f = true;
            lists.add(new ArrayList<>(arr));
        } else {
            for (int i = start; i < nums.length; i++) {

                arr.add(nums[i]);
                check(nums, k - nums[i], arr, i+1, lists);// 传入i+1，不是start+1！！！！！！！！！！！
                arr.remove(arr.size() - 1);
            }
        }
        return f;
    }
}
