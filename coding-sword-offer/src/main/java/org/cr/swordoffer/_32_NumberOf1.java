package org.cr.swordoffer;

import java.util.Arrays;

/**
 * @Description
 * @auther chenrui
 * @create 2020-12-25 23:45
 *
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class _32_NumberOf1 {

    public static void main(String[] args) {
//        int[] arr = new int[]{2,1,3,4,5};
        int[] arr = new int[]{1};
//        int res = numberOf1(arr);
        System.out.println(convertArr2Int(arr));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 1, arr.length)));
        System.out.println(numberOf1Between1AndN(55));
    }

    private static int numberOf1Between1AndN(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - 48;
        }
        return numberOf1(ints);
    }

    private static int convertArr2Int(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            res += arr[i];
            res *= 10;
        }
        return res / 10;
    }

    private static int numberOf1(int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        int first = arr[0];
        if (arr.length == 1 && first == 0) {
            return 0;
        }
        if (arr.length == 1 && first > 0) {
            return 1;
        }

        int numFirstDigit = 0;
        if (first > 1) {
            numFirstDigit = (int)  Math.pow(10, arr.length - 1);
        } else if (first == 1) {
            numFirstDigit = convertArr2Int(arr) + 1;
        }

        int numOtherDigits = (int) (first * (arr.length - 1) * Math.pow(10, arr.length - 2));

        return numFirstDigit + numOtherDigits + numberOf1(Arrays.copyOfRange(arr, 1, arr.length));
    }
}
