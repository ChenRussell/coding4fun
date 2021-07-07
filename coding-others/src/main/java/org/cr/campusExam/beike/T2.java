package org.cr.campusExam.beike;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/8/18
 * <p>
 * �������ʻ��ļ��ڣ�ˮ�ɻ��������������˵Ĵ�����ѧ���и�ˮ�ɻ�����������������ģ� ��ˮ�ɻ�������ָһ����λ�������ĸ�λ���ֵ������͵����䱾�����磺153=1^3+5^3+3^3�� ����Ҫ�����������m��n��Χ�ڵ�ˮ�ɻ�����
 * <p>
 * ����
 * ���������ж��飬ÿ��ռһ�У�������������m��n��100<=m<=n<=999����
 * <p>
 * ���
 * ����ÿ������ʵ����Ҫ����������ڸ�����Χ�ڵ�ˮ�ɻ���������˵�������ˮ�ɻ���������ڵ���m,����С�ڵ���n������ж������Ҫ���С����������һ���������֮����һ���ո����; ��������ķ�Χ�ڲ�����ˮ�ɻ����������no; ÿ������ʵ�������ռһ�С�
 * <p>
 * <p>
 * ��������
 * 100 120
 * 300 380
 * <p>
 * �������
 * no
 * 370 371
 */
public class T2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            if (m > n || m >= 1000 || m < 100 || n >= 1000 || n < 100) {
                System.out.println("n");
            }
            check(m, n);
        }
    }

    private static void check(int m, int n) {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        for (int i = m; i <= n; i++) {
            int x = i/100;
            int y = i%100/10;
            int z = i%10;
            if (i == x * x * x + y * y * y + z * z * z) {
                flag = true;
                sb.append(i).append(" ");
            }
        }
        if (!flag) System.out.println("no");
        else System.out.println(sb.toString().substring(0, sb.length()-1));
    }
}
