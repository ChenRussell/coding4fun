package org.cr.campusExam.baicizhan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 给定n个有序整数的集合，求他们的并集，请尽量使用更优的时间复杂度的算法
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(sc.nextInt());
            }
            lists.add(list);
        }

        ArrayList<Integer> res = lists.get(0);
        lists.remove(0);
        for (ArrayList<Integer> list : lists) {
//            res.addAll(0, list);
            int i=0,j=0,k=0;
            ArrayList<Integer> temp = new ArrayList<>();
            while (i < res.size() && j < list.size()) {
                if (res.get(i) <= list.get(j)) {
                    temp.add(res.get(i++));
                } else {
                    temp.add(list.get(j++));
                }
            }
            while (i < res.size()) {
                temp.add(res.get(i++));
            }
            while (j < list.size()) {
                temp.add(list.get(j++));
            }
            res = new ArrayList<>(temp);
        }

//        Collections.sort(res);
        for (Integer re : res) {
            System.out.print(re+" ");
        }
    }
}
