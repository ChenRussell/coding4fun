package org.cr.campusExam.beike;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ChenRui on 2018/8/18
 * <p>
 * ��Ŀ������
 * ɽ������N����ׯ����i����ׯ�ĺ��θ߶�ΪAi������Ҫ�ڴ�ׯ֮���޽���·��ʹ�ô�ÿ����ׯ���������ܵ����������д�ׯ���ڵ�i�͵�j����ׯ֮���޽���·�ķ���ȡ���ں��νϸߵĴ�ׯ�ĸ߶ȣ�������Ϊmax{Ai��Aj}����ô�޽���·���ܷ��������Ƕ��٣�
 * <p>
 * ����
 * ��һ�а���һ������N��2��N��105��
 * <p>
 * �ڶ��а���N���ո����������A1��AN��0��Ai��104��
 * <p>
 * ���
 * ����޽���·����С���á�
 * <p>
 * <p>
 * ��������
 * 5
 * 4 1 8 2 5
 * �������
 * 19
 */
public class Ttwo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
