package com.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChenRui on 2018/4/5
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class _28Permutation {

    public ArrayList<String> permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        char[] chars = str.toCharArray();
        ArrayList<Character> tempList = new ArrayList<>();
        boolean used[] = new boolean[chars.length];
        backTracking(res, tempList, chars, used);
        return res;
    }

    private void backTracking(ArrayList<String> res, ArrayList<Character> tempList, char[] chars, boolean used[]) {

        if (tempList.size() == chars.length && !res.contains(String.valueOf(tempList.toString()))) {
            res.add(tempList.toString());
        } else {

            for (int i = 0; i < chars.length; i++) {
                if (used[i]) continue;
                tempList.add(chars[i]);
                used[i] = true;
                backTracking(res, tempList, chars, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }

    static public ArrayList<String> permutation2(String str) {
        ArrayList<String> res = new ArrayList<>();
        permutation2(str.toCharArray(), res, 0);
        return res;
    }

    private static void permutation2(char[] chars, ArrayList<String> res, int begin) {
        if (String.valueOf(chars).length() - 1 == begin) {
            res.add(String.valueOf(chars));
        }

        for (int i = begin; i < chars.length; i++) {
            char temp = chars[begin];
            chars[begin] = chars[i];
            chars[i] = temp;

            permutation2(chars, res, begin + 1);

            temp = chars[begin];
            chars[begin] = chars[i];
            chars[i] = temp;
        }
    }

    public static void main(String[] args) {
        String str = "abc";
//        ArrayList<String> res = new _28Permutation().permutation(str);
        List<String> res = permutation2(str);
//        System.out.println(res);
        for (String re : res) {
            System.out.println(re);
        }
    }
}
