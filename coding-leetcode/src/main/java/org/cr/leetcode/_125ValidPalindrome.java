package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/27
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
 *
 * Given a string s, return true if it is a palindrome, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 *
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 *
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
public class _125ValidPalindrome {

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        s = s.toLowerCase();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z' ||
                    s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                sb.append(s.charAt(i));
            }
        }

        String str = sb.toString();
        int i = 0,  j = str.length() - 1;
        while(i < j) {
            if(str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome_voted(String s) {
        int low = 0, high = s.length() - 1;
        s = s.toLowerCase();
        while (low < high) {
            // 关键点在于if else的条件判断
            if (!Character.isLetterOrDigit(s.charAt(low))) {
                low++;
            } else if (!Character.isLetterOrDigit(s.charAt(high))) {
                high--;
            } else {
                if (s.charAt(low) != s.charAt(high)) {
                    return false;
                }
                low++;
                high--;
            }
        }
        return true;
    }
}
