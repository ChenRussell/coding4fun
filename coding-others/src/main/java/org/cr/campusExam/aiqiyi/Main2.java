package org.cr.campusExam.aiqiyi;

/**
 * Created by ChenRui on 2018/9/15
 * <p>
 * ��Ŀ������
 * �ֳ���N��ʳ�ÿ��ʳ����Ai�ݡ�
 * <p>
 * ÿ��ֳ����һ��ʳ�������һ��ʳ���ÿ��ֻ�ܽ��гԻ������е�һ�ֶ���������������M��
 * <p>
 * ���ھֳ���֪��M����p��ʳ��ķ����������Ӵ�С����ͬ�㲢�У�����3 3 2��������Ϊ1 1 3��
 * <p>
 * N,M,P<=100,Ai<=1000
 * <p>
 * ����
 * ��һ��N M P
 * <p>
 * �ڶ���N����Ai
 * <p>
 * ������M�У�ÿ��A i����B i�ֱ��ʾ��һ��ʳ��i����һ��ʳ��i
 * <p>
 * ���
 * һ����
 * <p>
 * <p>
 * ��������
 * 3 4 2
 * 5 3 1
 * B 1
 * A 2
 * A 2
 * A 3
 * �������
 * 1
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i <= n-1; i++) {
            a[i] = sc.nextInt();
        }
        sc.nextLine();
        String[] food = new String[m];
        for (int i = 0; i <= m-1; i++) {
            food[i] = sc.nextLine();
        }
        for (int i = 0; i <= m-1; i++) {
            String[] inStr = food[i].split(" ");
            int index = Integer.valueOf(inStr[1]) - 1;
            if ("A".equals(inStr[0])) {
                a[index] += 1;
            } else {
                a[index] -= 1;
            }
        }
        int res = 1;
        int has = a[p - 1];
        Arrays.sort(a);
        int i = a.length - 1;
        while (i >= 0) {
            if (has < a[i]) {
                res+=1;
            }else break;
            i--;
        }
        System.out.println(res);
    }
}
