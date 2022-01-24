package org.cr.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/10
 *
 * Given a string s, find the longest palindromic subsequence's length in s.
 *
 * A subsequence is a sequence that can be derived from another sequence by deleting some
 * or no elements without changing the order of the remaining elements.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bbbab"
 * Output: 4
 * Explanation: One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: 2
 * Explanation: One possible longest palindromic subsequence is "bb".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists only of lowercase English letters.
 */
public class _516LongestPalindromicSubsequence {

    public int longestPalindromeSubseq(String s) {
        List<List<Character>> resList = new ArrayList<>();
        List<Character> tempList = new ArrayList<>();
        char[] arr = s.toCharArray();
        permutation(resList, tempList, arr, 0);
        return resList.get(0).size();
    }

    private void permutation(List<List<Character>> resList, List<Character> tempList, char[] arr, int start) {
        if (isPalindromic(tempList) && resList.isEmpty()) {
            resList.add(new ArrayList<>(tempList));
        } else if (isPalindromic(tempList) && tempList.size() > resList.get(0).size()) {
            resList.remove(0);
            resList.add(new ArrayList<>(tempList));
        }
        for (int i = start; i < arr.length; i++) {
            tempList.add(arr[i]);
            permutation(resList, tempList, arr, i + 1);
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
}
