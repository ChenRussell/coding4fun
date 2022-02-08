package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/08
 *
 * Write a function that reverses a string. The input string is given as an array of characters s.
 *
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 *
 * Example 1:
 *
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 * Accepted
 * 1,390,289
 * Submissions
 * 1,890,100
 */
public class _344ReverseString {

    public void reverseString(char[] s) {
        int low = 0, high = s.length-1;
        while(low < high) {
            char temp = s[low];
            s[low] = s[high];
            s[high] = temp;
            low++;
            high--;
        }
    }
}
