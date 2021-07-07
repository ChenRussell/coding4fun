package org.cr.campusExam.jd.second_2;

/**
 * 对比
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 现有n个物品，每个物品有三个参数 ai , bi , ci ，定义i物品不合格品的依据是 : 若存在物品 j , 且aj>ai , bj>bi , cj>ci，则称i物品为不合格品。
 * <p>
 * 现给出n个物品的a,b,c参数，请你求出不合格品的数量。
 * <p>
 * 输入
 * 第一行包含一个整数n(1<=n<=500000),表示物品的数量。接下来有n行，每行有三个整数，
 * ai,bi,ci表示第i个物品的三个参数，1≤ai,bi,ci≤109。
 * <p>
 * 输出
 * 输出包含一个整数，表示不合格品的数量。
 * <p>
 * <p>
 * 样例输入
 * 3
 * 1 4 2
 * 4 3 2
 * 2 5 3
 * 样例输出
 * 1
 * <p>
 * Hint
 * 样例解释
 * 物品1的a,b,c均小于物品3的a,b,c,因此1为不合格品。
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static class Prop {
        int value1;
        int value2;
        int value3;
    }

    static boolean f(Prop o1, Prop o2) {
        if (o2.value1 > o1.value1 && o2.value2 > o1.value2 && o2.value3 > o1.value3) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Prop> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Prop ob = new Prop();
            ob.value1 = sc.nextInt();
            ob.value2 = sc.nextInt();
            ob.value3 = sc.nextInt();
            arr.add(ob);
        }
        sc.close();

        arr.sort((o1, o2) -> {
            if (o1.value1 > o2.value1) {
                return 1;
            } else if (o1.value1 < o2.value1)
                return -1;
            else {
                if (o1.value2 > o2.value2) {
                    return 1;
                } else if (o1.value2 < o2.value2)
                    return -1;
                else {
                    return Integer.compare(o1.value3, o2.value3);
                }
            }
        });

        int count = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (f(arr.get(i), arr.get(j))) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
