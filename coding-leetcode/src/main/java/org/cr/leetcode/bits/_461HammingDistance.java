package org.cr.leetcode.bits;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/03/31
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *
 * Given two integers x and y, return the Hamming distance between them.
 *
 *
 *
 * Example 1:
 *
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ¡ü   ¡ü
 * The above arrows point to positions where the corresponding bits are different.
 * Example 2:
 *
 * Input: x = 3, y = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 0 <= x, y <= 231 - 1
 */
public class _461HammingDistance {

    public int hammingDistance(int x, int y) {
        int a = x ^ y;
        int count = 0;
        while(a != 0) {
            count++;
            a = a & (a-1);
        }
        return count;
    }
}
