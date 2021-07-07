package org.cr.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 2018/9/22.
 * <p>
 * ��Ŀ����
 * ����һ����������������һ������S���������в�����������ʹ�����ǵĺ�������S��
 * ����ж�����ֵĺ͵���S������������ĳ˻���С�ġ�
 * �������:
 * ��Ӧÿ�����԰����������������С���������
 */
public class _41_1_TwoNumbersWithSum {

    public ArrayList<Integer> findNumbersWithSum(int [] array, int sum) {
        int head = 0, tail = array.length - 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (head < tail) {
            if (array[head] + array[tail] == sum) {
                list.add(array[head]);
                list.add(array[tail]);
                return list;
            } else if (array[head] + array[tail] < sum) {
                head++;
            } else {
                tail--;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        _41_1_TwoNumbersWithSum findNumbersWithSum = new _41_1_TwoNumbersWithSum();
        ArrayList<Integer> res = findNumbersWithSum.findNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15);
        System.out.println(res);

    }
}
