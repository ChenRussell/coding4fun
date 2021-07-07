package org.cr.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ChenRui on 18-4-15
 *
 * 圆圈中追后剩下的数字
 * 0,1,2,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字
 */
public class _45_LastNumberInCircle {

    // todo 检验正确性，这能行吗，怎么实现转圈？
    private static int LastRemaining_Solution(int n, int m) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            count++;
            if (count == m) {
                iterator.remove();
                count = 0;
            }
            if (list.size() == 1)   break;
        }
        return list.get(0);
    }

    private static int solution(int n, int m) {
        if (m <= 0) return -1;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        int index = 0;
        int sum = 0;
        int count = 0;
        while (true) {
            sum += arr[index];
            if (sum == m) {
                arr[index] = 0;
                sum = 0;
                count++;
            }
            index++;
            if (index == arr.length) {
                index = 0;
            }
            if (count == arr.length - 1) {
                break;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int res = solution(5, 3);
        System.out.println(res);
    }
}
