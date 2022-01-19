package org.cr.leetcode;

/**
 * Created by ChenRui on 18-3-11
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output:  321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only hold integers
 * within the 32-bit signed integer range. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class _7ReverseInteger {

    public int reverse(int x) {
        StringBuffer sb = new StringBuffer();
        if (x < 0) {
            x = Math.abs(x);
            sb.append("-");
        }

        while (x > 0) {
            sb.append(x % 10);
            x = x / 10;
        }
        int res = 0;
        try {
            res = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            res = 0;
        } finally {
            return res;
        }
    }

    public int reverse2(int x) {
        int result = 0;

        while (x != 0) {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            //If overflow exists, the new result will not equal previous one.
            //No flags needed. No hard code like 0x7fffffff needed.
            if ((newResult - tail) / 10 != result) {
                return 0;
            }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        _7ReverseInteger obj = new _7ReverseInteger();
        int res = obj.reverse2(-120);
        System.out.println(res);
        System.out.println(Integer.MAX_VALUE);
    }
}
