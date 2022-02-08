package org.cr.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/28
 *
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 *
 * A palindrome string is a string that reads the same backward as forward.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 16
 * s contains only lowercase English letters.
 */
public class _131PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        backTracking(s, res, tempList, 0);
        return res;
    }

    private void backTracking(String s, List<List<String>> res, List<String> tempList, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (int i = pos; i < s.length(); i++) {
                if (isPalindrome(s, pos, i)) {
                    tempList.add(s.substring(pos, i + 1));
                    backTracking(s, res, tempList, i + 1);
                    tempList.remove(tempList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low++) != s.charAt(high--)) {
                return false;
            }
        }
        return true;
    }
}
