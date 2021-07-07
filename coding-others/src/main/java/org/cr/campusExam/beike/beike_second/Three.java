package org.cr.campusExam.beike.beike_second;

/**
 * ��Ŀ������
 * С����С���������ã�����һ���˷����Ǽҵ����ף��������Ǽҷǳ��Ӵ��зǳ�����������������档�����л�д���ÿһ���˵ĸ�����˭����Ȼÿ���˶�ֻ����һ�����ס�
 * <p>
 * �������ȵĶ��壬����������ٸ����ӣ����������дС���ĸ�����С����С���ĸ�����С������ôʵ����С������С����үү��Ҳ��С�������ȡ�
 * <p>
 * С���ܴ�����С�����������ǵļ�ͥ��ϵ���ܿ��Ū����ˣ�֪����������ÿһ���˵����ȹ�ϵ��
 * <p>
 * ����С��ȴ���������������˺ܶ����⣬ϣ�����ܹ����
 * <p>
 * С��������ǣ�����A��B�����ȹ�ϵ��ʲô������A�ǲ���B�����ȣ�����˵B��A�����ȣ������B��A���������ȹ�ϵ�ء�
 * <p>
 * ����
 * �����һ�а���һ������n��ʾ�����Ա������
 * <p>
 * ������n��ÿ��һ��������a��b��ʾa��b�ĸ��ף�����b��a�ĸ��ף�����Ҫ�����жϡ�
 * <p>
 * ���b��-1����ôa������������ĸ���Ҳ���Ǳ��������ˣ���ֻ֤��һ����
 * <p>
 * ��n+2����һ������m��ʾС���ѯ�ʸ�����
 * <p>
 * ������m�У�ÿ������������A��B��
 * <p>
 * ��ʾС����֪��A��B�����ȹ�ϵ��
 * <p>
 * n,m��40000��ÿ���ڵ�ı�Ŷ�������40000��
 * <p>
 * ���
 * ����ÿһ��ѯ�ʡ�
 * <p>
 * ���1��ʾA��B�����ȣ����2��ʾB��A�����ȣ����������0
 * <p>
 * <p>
 * ��������
 * 10
 * 1 -1
 * 3 1
 * 4 1
 * 5 1
 * 6 1
 * 7 1
 * 8 1
 * 9 1
 * 10 1
 * 2 10
 * 5
 * 1 2
 * 2 3
 * 2 4
 * 2 5
 * 2 10
 * �������
 * 1
 * 0
 * 0
 * 0
 * 2
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Three {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        Map<Long, Long> relations = new HashMap<>();
        for (int i = 0; i < n; i++) {

            long a = sc.nextInt();
            long b = sc.nextInt();
            if (b == -1) {
                relations.put(a, b);
            } else {
                if (!relations.containsKey(a)) {
                    relations.put(a, b);
                } else {
                    relations.put(b, a);
                }
            }
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (find(relations, a, b)) {
                System.out.println(2);
            } else if (find(relations, b, a)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean find(Map<Long, Long> relations, long a, long b) {
        long anc = relations.get(a);
        while (anc != -1) {
            if (b == anc) {
                return true;
            }
            anc = relations.get(anc);
        }
        return false;
    }
}
