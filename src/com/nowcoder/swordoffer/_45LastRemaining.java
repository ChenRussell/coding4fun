package com.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ChenRui on 18-4-15
 *
 * 圆圈中追后剩下的数字
 * 0,1,2,...,n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字
 */
public class _45LastRemaining {

    static public int LastRemaining_Solution(int n, int m) {
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

    public static void main(String[] args) {
        int res = LastRemaining_Solution(3, 1);
        System.out.println(res);
    }
}
