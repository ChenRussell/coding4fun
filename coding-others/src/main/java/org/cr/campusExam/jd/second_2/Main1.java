package org.cr.campusExam.jd.second_2;

/**
 * 完全多部图
 * 时间限制：C/C++语言 2000MS；其他语言 4000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 给定一张包含N个点、M条边的无向图，每条边连接两个不同的点，且任意两点间最多只有一条边。
 * 对于这样的简单无向图，如果能将所有点划分成若干个集合，使得任意两个同一集合内的点之间没有边相连，
 * 任意两个不同集合内的点之间有边相连，则称该图为完全多部图。现在你需要判断给定的图是否为完全多部图。
 * <p>
 * 输入
 * 第一行输入一个整数T表示数据组数，1≤T≤10。
 * <p>
 * 每组数据格式为：
 * <p>
 * 第一行包含两个整数N和M，1≤N≤1000，0≤M≤N(N-1)/2；
 * <p>
 * 接下来M行，每行包含两个整数X和Y，表示第X个点和第Y个点之间有一条边，1≤X，Y≤N。
 * <p>
 * 输出
 * 每组输出占一行，如果给定的图为完全多部图，输出Yes，否则输出No。
 * <p>
 * <p>
 * 样例输入
 * 2
 * 5 7
 * 1 3
 * 1 5
 * 2 3
 * 2 5
 * 3 4
 * 4 5
 * 3 5
 * 4 3
 * 1 2
 * 2 3
 * 3 4
 * 样例输出
 * Yes
 * No
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 1; j < n+1; j++) {
                ArrayList<Integer> list;
                list = new ArrayList<>();
                map.put(j, list);
            }
            for (int j = 0; j <= m-1; j++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                ArrayList<Integer> listFirst = map.get(n1);
                listFirst.add(n2);
                ArrayList<Integer> listSec = map.get(n2);
                listSec.add(n1);
            }

            System.out.println(solve(map)?"Yes":"No");
        }
        sc.close();
    }

    public static boolean solve(HashMap<Integer, ArrayList<Integer>> map) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> single = new ArrayList<>();
        for (int i = 1; i <= map.size(); i++) {
            single.add(i);
            ArrayList<Integer> list = map.get(i);
            for (int j = 1; j <= map.size(); j++) {
                if (j != i) {
                    if (!list.contains(j))
                        single.add(j);
                }
            }
            Collections.sort(single);

            if (!res.contains(single))
                res.add(new ArrayList<>(single));
            single.clear();
        }

        for (int i = 0; i < res.size(); i++) {
            for (int j = i + 1; j < res.size(); j++) {
                if (!Collections.disjoint(res.get(i), res.get(j))) {
                    return false;
                }
            }
        }

        return true;

    }
}
