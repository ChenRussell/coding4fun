package org.cr.swordoffer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @auther chenrui
 * @create 2020-12-26 00:44
 *
 *����һ�����������飬����������������ƴ�������ų�һ������
 * ��ӡ��ƴ�ӳ���������������С��һ����������������{3��32��321}��
 * ���ӡ���������������ųɵ���С����Ϊ321323��
 */
public class _33_SortArrayForMinNumber {

    public static void main(String[] args) {
        _33_SortArrayForMinNumber obj = new _33_SortArrayForMinNumber();
        String res = obj.printMinNumber2(new int[]{3, 32, 321});
        System.out.println(res);
    }

    // ���һ���ȽϹ���ÿ���ҵ�һ��"��Сֵ"
    private static Integer getMin(List<Integer> list) {
        int min = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (!compare(min, list.get(i))) {
                min = list.get(i);
            }
        }
        return min;
    }

    private static boolean compare(int i, int j) {
        String a = String.valueOf(i);
        String b = String.valueOf(j);
        if (Integer.parseInt(a + b) < Integer.parseInt(b + a)) {
            return true;
        } else {
            return false;
        }
    }

    public String printMinNumber(int [] numbers) {
        StringBuilder sb = new StringBuilder();
        List<Integer> collect = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        for (int i = 0; i < numbers.length; i++) {
            Integer min = getMin(collect);
            sb.append(min);
            collect.remove(min);
        }
        return sb.toString();
    }

    // ֱ��ʹ�ñȽϹ����������(ȡ���������㷨)��ʱ�临�Ӷȸ��ͣ�O(nlogn)<O(n^2)
    public String printMinNumber2(int [] numbers) {
        Integer[] numbers2 = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers2[i] = numbers[i];
        }
        Arrays.sort(numbers2, (o1, o2) -> {
            String a = String.valueOf(o1);
            String b = String.valueOf(o2);
            return Integer.compare(Integer.parseInt(a + b), Integer.parseInt(b + a));
        });
        StringBuilder sb = new StringBuilder();
        for (Integer number : numbers2) {
            sb.append(number);
        }
        return sb.toString();
    }
}
