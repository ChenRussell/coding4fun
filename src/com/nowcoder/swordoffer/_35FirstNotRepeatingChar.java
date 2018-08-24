package com.nowcoder.swordoffer;

/**
 * Created by ChenRui on 18-4-23
 *
 * 题目描述
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */

public class _35FirstNotRepeatingChar {

    public static int firstNotRepeatingChar(String str) {
        char[] arr = str.toCharArray();
        int hashTable[] = new int[200];
        for (int i = 0; i < arr.length; i++) {
            hashTable[arr[i]]++;
        }

//        for (int i = 0; i < hashTable.length; i++) {
//            if (hashTable[i] == 1) {
//                return i;
//            }
//        }
        // 按字符数组顺序遍历
        for (int i = 0; i < arr.length; i++) {
            if (hashTable[arr[i]] == 1) {
                return arr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "google";
        int res = firstNotRepeatingChar(str);
        System.out.println((char)res);
        System.out.println(str.indexOf(res));
    }
}
