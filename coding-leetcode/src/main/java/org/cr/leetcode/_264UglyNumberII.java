package org.cr.leetcode;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/27
 *
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 12
 * Explanation: [1, 2, 3, 4, 5, 6, 8, 9, 10, 12] is the sequence of the first 10 ugly numbers.
 * Example 2:
 *
 * Input: n = 1
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are limited to 2, 3, and 5.
 */
public class _264UglyNumberII {

    public int nthUglyNumber(int n) {
        int p2 = 1, p3 = 1, p5 = 1;
        int count = 1;
        int[] arr = new int[n+1];
        arr[1] = 1;
        while (count < n) {
            count++;
            arr[count] = min(arr[p2] * 2, arr[p3] * 3, arr[p5] * 5);
            while (arr[p2] * 2 <= arr[count]) p2++;
            while (arr[p3] * 3 <= arr[count]) p3++;
            while (arr[p5] * 5 <= arr[count]) p5++;
        }
        return arr[count];
    }

    public int min(int a, int b, int c) {
        return a < b ? (Math.min(a, c)) : (Math.min(b, c));
    }

    public static void main(String[] args) {
        _264UglyNumberII obj = new _264UglyNumberII();
        System.out.println(obj.nthUglyNumber(10));
    }
}
