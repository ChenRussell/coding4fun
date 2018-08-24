package com.nowcoder.campusExam.byteDance;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/3/24
 *
 * 已知空中有N个高度互不相同的跳板，刚开始在高度为0的地方，每次跳跃可以选择与自己当前高度绝对值小于等于H的跳板，
 * 跳跃过后到达  以跳板为轴的镜像  位置，问在最多跳K次的情况下最高能跳多高？（任意时刻高度不能为负）
 */
public class Tfive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int H = sc.nextInt();
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int he = 0;
        // 最多跳K次
        for (int i = 0; i < K; i++) {
            int fit = -1;   // 最大且满足条件的跳板，肯定不选低于高度的跳板
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] - he > 0) && (arr[j] - he <= H) && (fit < arr[j])) {
                    fit = arr[j];
                    flag = true;    // 找到了能用的跳板
                }

            }
            if (flag) {
                he = he + (fit-he)*2;
//                System.out.println(he);
            }
        }

        System.out.println(he);
    }
}
