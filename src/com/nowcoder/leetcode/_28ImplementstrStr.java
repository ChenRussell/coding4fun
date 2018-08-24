package com.nowcoder.leetcode;

/**
 * Created by ChenRui on 2018/4/
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class _28ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int len = needle.length();
        for (int i = 0; i < haystack.length()-len+1; i++) {
            if (haystack.substring(i,i+len).equals(needle)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "lw";
        int res = new _28ImplementstrStr().strStr(haystack, needle);
        System.out.println(res);
    }
}
