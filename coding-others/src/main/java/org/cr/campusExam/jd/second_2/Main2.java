package org.cr.campusExam.jd.second_2;

/**
 * �Ա�
 * ʱ�����ƣ�C/C++���� 1000MS���������� 3000MS
 * �ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
 * ��Ŀ������
 * ����n����Ʒ��ÿ����Ʒ���������� ai , bi , ci ������i��Ʒ���ϸ�Ʒ�������� : ��������Ʒ j , ��aj>ai , bj>bi , cj>ci�����i��ƷΪ���ϸ�Ʒ��
 * <p>
 * �ָ���n����Ʒ��a,b,c����������������ϸ�Ʒ��������
 * <p>
 * ����
 * ��һ�а���һ������n(1<=n<=500000),��ʾ��Ʒ����������������n�У�ÿ��������������
 * ai,bi,ci��ʾ��i����Ʒ������������1��ai,bi,ci��109��
 * <p>
 * ���
 * �������һ����������ʾ���ϸ�Ʒ��������
 * <p>
 * <p>
 * ��������
 * 3
 * 1 4 2
 * 4 3 2
 * 2 5 3
 * �������
 * 1
 * <p>
 * Hint
 * ��������
 * ��Ʒ1��a,b,c��С����Ʒ3��a,b,c,���1Ϊ���ϸ�Ʒ��
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    static class Prop {
        int value1;
        int value2;
        int value3;
    }

    static boolean f(Prop o1, Prop o2) {
        if (o2.value1 > o1.value1 && o2.value2 > o1.value2 && o2.value3 > o1.value3) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Prop> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Prop ob = new Prop();
            ob.value1 = sc.nextInt();
            ob.value2 = sc.nextInt();
            ob.value3 = sc.nextInt();
            arr.add(ob);
        }
        sc.close();

        arr.sort((o1, o2) -> {
            if (o1.value1 > o2.value1) {
                return 1;
            } else if (o1.value1 < o2.value1)
                return -1;
            else {
                if (o1.value2 > o2.value2) {
                    return 1;
                } else if (o1.value2 < o2.value2)
                    return -1;
                else {
                    return Integer.compare(o1.value3, o2.value3);
                }
            }
        });

        int count = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (f(arr.get(i), arr.get(j))) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
