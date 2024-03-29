package org.cr.campusExam.huawei;

import java.util.*;

/**
 * 给你一个原始字符串，根据该字符串内每个字符出现的次数，按照ASCII码递增顺序重新调整输出。
 举例！假设原始字符串为：
 eeefgghhh
 则每种字符出现的次数分别是：
 (1).eee        3次
 (2).f          1次
 (3).gg         2次
 (4).hhh        3次
 重排输出后的字符串如下：
 efghegheh
 编写程序，实现上述功能。
 【温馨提示】
 (1).原始字符串中仅可能出现“数字”和“字母”；
 (2).请注意区分字母大小写。

 输入描述:
 eeefgghhh
 输出描述:
 efghegheh
 */
public class Tone {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        System.out.println(chars);
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (!map.containsKey(chars[i])) {
                map.put(chars[i], 1);
            } else {
                map.put(chars[i], map.get(chars[i]) + 1);
            }
        }

        Set<Map.Entry<Character, Integer>> set = map.entrySet();
//        for (Map.Entry<Character, Integer> entry : set) {
//            System.out.println(entry.getKey()+": "+entry.getValue());
//        }
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while (true) {
            flag = true;
            for (Map.Entry<Character, Integer> entry : set) {
                if (entry.getValue() >= 1) {
                    flag = false;
                    sb.append(entry.getKey());
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            if (flag) break;
        }
        System.out.println(sb.toString());
    }
}
