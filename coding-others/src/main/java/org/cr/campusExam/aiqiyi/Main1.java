package org.cr.campusExam.aiqiyi;

import java.util.Scanner;

/**
 * Created by ChenRui on 2018/9/15
 * <p>
 * СC��һ��Ʊ������Ʊ��ID�ǳ���Ϊ6���ַ�����ÿ���ַ��������֣����������ID�����������ID���������Ϳ�ʼ����ID��ÿһ�β�����������ѡ������һ�����ֲ����滻����
 * <p>
 * ������ID��ǰ��λ����֮�͵��ں���λ����֮�ͣ���ô���ID�������˵ġ����СC��һ�£�������Ҫ�������Σ���ʹID�������ID
 * <p>
 * ����
 * ����ֻ��һ�У���һ������Ϊ6���ַ�����
 * <p>
 * ���
 * ��������С��������
 * <p>
 * <p>
 * ��������
 * 000000
 * �������
 * 0
 * <p>
 * Hint
 * ��������2
 * 000018
 * <p>
 * �������2
 * 1
 * <p>
 * �������ͣ���ǰ��λ����һ����Ϊ9��������������������Ϊ1
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        char[] chars = str.toCharArray();

        int sum1=0, sum2=0;
        for (int i = 0; i < chars.length-3; i++) {
            sum1 += (int) chars[i];
        }

        for (int i = 3; i < chars.length; i++) {
            sum2 += (int) chars[i];
        }

        if (Math.abs(sum1 - sum2) == 0) {
            System.out.println(0);
        }
        else if (Math.abs(sum1 - sum2)<=10) {
            System.out.println(1);
        } else if (Math.abs(sum1 - sum2) <= 20) {
            System.out.println(2);
        } else {
            System.out.println(3);
        }
    }
}
