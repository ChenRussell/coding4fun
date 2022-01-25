package org.cr.leetcode;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/25
 *
 * Given an integer n, return the number of prime numbers that are strictly less than n.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 10
 * Output: 4
 * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 * Example 2:
 *
 * Input: n = 0
 * Output: 0
 * Example 3:
 *
 * Input: n = 1
 * Output: 0
 *
 *
 * Constraints:
 *
 * 0 <= n <= 5 * 106
 */
public class _204CountPrimes {

    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        int count = 0;
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i <= n / i; i++) {
            if (!isPrime[i]) continue;
            // In fact, we can mark off multiples of 5 starting at 5 ¡Á 5 = 25,
            // because 5 ¡Á 2 = 10 was already marked off by multiple of 2,
            // similarly 5 ¡Á 3 = 15 was already marked off by multiple of 3.
            // Therefore, if the current number is p, we can always mark off multiples of p starting at p2,
            // then in increments of p: p2 + p, p2 + 2p
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
        }
        return count;
    }

    public int countPrimes_voted(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
