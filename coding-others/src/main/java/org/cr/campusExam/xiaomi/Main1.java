package org.cr.campusExam.xiaomi;

import java.util.*;

/**
 * Created by ChenRui on 2018/9/20.
 * <p>
 * �ҡ�������
 * ʱ�����ƣ�C/C++���� 1000MS���������� 3000MS
 * �ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
 * ��Ŀ������
 * ���壺��ֵ�����а���2~16���������������������һ�������������������κ�һ������С������ȣ����������������������
 * ���ҳ�������ֵ���������еġ�������.
 * <p>
 * ����
 * ������ֵ����i��(0<i)��ÿһ�зֱ��ǽ��ƺ���ֵ���ԡ�#���ָ�磺n#m, n������������n���ƣ�1<n<17��,m��n�����µ���ֵ.
 * <p>
 * ���������Խ�������END������.
 * <p>
 * ���
 * ���j��(0<j<=i),ÿһ�ж����������еġ���������Ҫ��
 * <p>
 * 1.�����������е�ԭ�����;
 * <p>
 * 2.���û�С�������,����ַ�����None��
 * <p>
 * 3.��������END���������
 * <p>
 * <p>
 * ��������
 * 10#15
 * 4#32
 * 4#33
 * 8#17
 * END
 * �������
 * 4#32
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        while (true) {
            String str = sc.nextLine();
            if (str.equals("END")) break;
            String[] split = str.split("#");
            int n = Integer.parseInt(split[0]);
            int m = Integer.parseInt(split[1]);

//            System.out.println(f(n, m));
            int f = f(n, m);
            map2.put(f, str);
            if (map.containsKey(f)) {
                map.put(f, map.get(f) + 1);
            } else {
                map.put(f, 1);
            }
        }
        if (map.size() != 2) {
            System.out.println("None");
        } else {
            Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                if (entry.getValue() == 1) {
                    String res = map2.get(entry.getKey());
                    System.out.println(res);
                    break;
                }
            }
        }
    }

    static int f(int n, int m) {
        if (n == 10) return m;
        int sum = 0;
        int count = 0;
        while (m != 0) {
            int i = m % 10;
            sum += i * Math.pow(n, count);
            m = m / 10;
            count++;
        }
        return sum;
    }
}
