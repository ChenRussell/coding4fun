package org.cr.leetcode;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/04
 *
 * Given an integer x, return true if x is palindrome integer.
 *
 * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * Example 3:
 *
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Example 4:
 *
 * Input: x = -101
 * Output: false
 *
 *
 * Constraints:
 *
 * -231 <= x <= 231 - 1
 *
 *
 * Follow up: Could you solve it without converting the integer to a string?
 */
public class _9PalindromeNumber {

    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        if(x ==0) return true;
        int x1 = x;
        int[] arr = new int[String.valueOf(x).length()];
        int index = 0;
        while(x1 != 0 ){
            arr[index++] = x1%10;
            x1 = x1 / 10;
        }

        int x2 = 0;
        for(int i = 0; i < arr.length; i++){
            x2 = x2*10 + arr[i];
        }

        return x == x2;
    }

    public boolean isPalindrome_voted(int x) {
        if (x<0 || (x!=0 && x%10==0)) return false;
        int rev = 0;
        while (x>rev){
            rev = rev*10 + x%10;
            x = x/10;
        }
        return (x==rev || x==rev/10);
    }

    public static void main(String[] args) {
        int x = 121;
        boolean res = new _9PalindromeNumber().isPalindrome(x);
        System.out.println(res);
    }
}
