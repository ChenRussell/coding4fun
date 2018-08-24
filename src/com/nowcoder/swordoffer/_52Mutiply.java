package com.nowcoder.swordoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ChenRui on 18-4-15
 */
public class _52Mutiply {

    public int[] multiply(int[] A) {

        int B[] = new int[A.length];
        int len = A.length;
        if (len ==0) return B;

        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp = temp * A[i + 1];
            B[i] = temp * B[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        int[] res = new _52Mutiply().multiply(a);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
