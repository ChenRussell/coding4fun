package org.cr.campusExam.jd.second_2;

/**
 * ��ȫ�ಿͼ
 * ʱ�����ƣ�C/C++���� 2000MS���������� 4000MS
 * �ڴ����ƣ�C/C++���� 65536KB���������� 589824KB
 * ��Ŀ������
 * ����һ�Ű���N���㡢M���ߵ�����ͼ��ÿ��������������ͬ�ĵ㣬��������������ֻ��һ���ߡ�
 * ���������ļ�����ͼ������ܽ����е㻮�ֳ����ɸ����ϣ�ʹ����������ͬһ�����ڵĵ�֮��û�б�������
 * ����������ͬ�����ڵĵ�֮���б���������Ƹ�ͼΪ��ȫ�ಿͼ����������Ҫ�жϸ�����ͼ�Ƿ�Ϊ��ȫ�ಿͼ��
 * <p>
 * ����
 * ��һ������һ������T��ʾ����������1��T��10��
 * <p>
 * ÿ�����ݸ�ʽΪ��
 * <p>
 * ��һ�а�����������N��M��1��N��1000��0��M��N(N-1)/2��
 * <p>
 * ������M�У�ÿ�а�����������X��Y����ʾ��X����͵�Y����֮����һ���ߣ�1��X��Y��N��
 * <p>
 * ���
 * ÿ�����ռһ�У����������ͼΪ��ȫ�ಿͼ�����Yes���������No��
 * <p>
 * <p>
 * ��������
 * 2
 * 5 7
 * 1 3
 * 1 5
 * 2 3
 * 2 5
 * 3 4
 * 4 5
 * 3 5
 * 4 3
 * 1 2
 * 2 3
 * 3 4
 * �������
 * Yes
 * No
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int j = 1; j < n+1; j++) {
                ArrayList<Integer> list;
                list = new ArrayList<>();
                map.put(j, list);
            }
            for (int j = 0; j <= m-1; j++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                ArrayList<Integer> listFirst = map.get(n1);
                listFirst.add(n2);
                ArrayList<Integer> listSec = map.get(n2);
                listSec.add(n1);
            }

            System.out.println(solve(map)?"Yes":"No");
        }
        sc.close();
    }

    public static boolean solve(HashMap<Integer, ArrayList<Integer>> map) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> single = new ArrayList<>();
        for (int i = 1; i <= map.size(); i++) {
            single.add(i);
            ArrayList<Integer> list = map.get(i);
            for (int j = 1; j <= map.size(); j++) {
                if (j != i) {
                    if (!list.contains(j))
                        single.add(j);
                }
            }
            Collections.sort(single);

            if (!res.contains(single))
                res.add(new ArrayList<>(single));
            single.clear();
        }

        for (int i = 0; i < res.size(); i++) {
            for (int j = i + 1; j < res.size(); j++) {
                if (!Collections.disjoint(res.get(i), res.get(j))) {
                    return false;
                }
            }
        }

        return true;

    }
}
