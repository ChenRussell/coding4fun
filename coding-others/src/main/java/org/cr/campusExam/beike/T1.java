package org.cr.campusExam.beike;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/8/18
 *
 * ���еĶ������£� ���еĵ�һ��Ϊn���Ժ����Ϊǰһ���ƽ�����������е�ǰm��ĺ͡�
 * <p>
 * ����
 * ���������ж��飬ÿ��ռһ�У�����������n��n<10000����m(m<1000)��ɣ�n��m�ĺ�����ǰ������
 * <p>
 * ���
 * ����ÿ���������ݣ���������еĺͣ�ÿ������ʵ��ռһ�У�Ҫ�󾫶ȱ���2λС����
 * <p>
 * <p>
 * ��������
 * 81 4
 * 2 2
 * <p>
 * �������
 * 94.73
 * 3.41
 */
public class T1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            double sum = n;
            double temp = n;
            for (int i = 0; i < m-1; i++) {
                temp = Math.sqrt(temp);
                sum += temp;
            }
            System.out.printf("%.2f", sum);
        }
    }
}
