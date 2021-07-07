package org.cr.campusExam.xiaomi;

import java.util.*;

/**
 * Created by ChenRui on 2018/9/20.
 * <p>
 * 找”异数“
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 定义：数值序列中包含2~16进制整数，如果序列中有一个数，与序列中其他任何一个数大小都不相等，则这个数叫做“异数”。
 * 请找出给定数值序列中所有的“异数”.
 * <p>
 * 输入
 * 输入数值序列i行(0<i)，每一行分别是进制和数值，以“#”分割。如：n#m, n是整数，代表n进制（1<n<17）,m是n进制下的数值.
 * <p>
 * 输入序列以结束符”END”结束.
 * <p>
 * 输出
 * 输出j行(0<j<=i),每一行都是输入序列的“异数”。要求：
 * <p>
 * 1.按照输入序列的原序输出;
 * <p>
 * 2.如果没有”异数”,输出字符串”None”
 * <p>
 * 3.结束符“END”不用输出
 * <p>
 * <p>
 * 样例输入
 * 10#15
 * 4#32
 * 4#33
 * 8#17
 * END
 * 样例输出
 * 4#32
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("END")) break;
            String[] split = str.split("#");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);

//            System.out.println(f(n, m));
            int f = f(n, m);
            map2.put(f, str);
            if (map.containsKey(f)) {
                map.put(f, map.get(f) + 1);
            } else {
                map.put(f, 1);
            }
        }
        if (map.size() != 2) {
            System.out.println("None");
        } else {
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() == 1) {
                    String res = map2.get(entry.getKey());
                    System.out.println(res);
                    break;
                }
            }
        }
    }

    static int f(int n, int m) {
        if (n == 10) return m;
        int sum = 0;
        int count = 0;
        while (m != 0) {
            int i = m % 10;
            sum += i * Math.pow(n, count);
            m = m / 10;
            count++;
        }
        return sum;
    }
}
