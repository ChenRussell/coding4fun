package org.cr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/09
 * <p>
 * Given a string s, return the number of palindromic substrings in it.
 * <p>
 * A string is a palindrome when it reads the same backward as forward.
 * <p>
 * A substring is a contiguous sequence of characters within the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 * <p>
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 */
public class _647PalindromicSubstrings {

    public int countSubstrings_voted(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            count += countPalindromicSubstr(arr, i, i);// odd length
            count += countPalindromicSubstr(arr, i, i + 1);// even length
        }
        return count;
    }

    private int countPalindromicSubstr(char[] arr, int start, int end) {
        int count = 0;
        while (start >= 0 && end < arr.length && arr[start--] == arr[end++]) {
            count++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        Integer res = 0;
        List<List<Character>> resList = new ArrayList<>();
        List<Character> tempList = new ArrayList<>();
        char[] arr = s.toCharArray();
        permutation(res, resList, tempList, arr, 0);
        System.out.println(resList);
        return res;
    }

    /**
     * 这样求的是子序列
     *
     * @param res
     * @param tempList
     * @param arr
     * @param start
     */
    private void permutation(Integer res, List<List<Character>> resList, List<Character> tempList, char[] arr, int start) {
        if (isPalindromic(tempList)) {
            resList.add(new ArrayList<>(tempList));
            res++;
        }
        for (int i = start; i < arr.length; i++) {
            tempList.add(arr[i]);
            permutation(res, resList, tempList, arr, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    private boolean isPalindromic(List<Character> tempList) {
        int start = 0, end = tempList.size() - 1;
        while (start < end) {
            if (tempList.get(start) != tempList.get(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        _647PalindromicSubstrings obj = new _647PalindromicSubstrings();
        System.out.println(obj.countSubstrings("abca"));
        System.out.println(obj.countSubstrings_voted("aaa"));
    }
}
