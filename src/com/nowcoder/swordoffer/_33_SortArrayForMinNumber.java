package com.nowcoder.swordoffer;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @auther chenrui
 * @create 2020-12-26 00:44
 *
 *输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 */
public class _33_SortArrayForMinNumber {

    public static void main(String[] args) {
        _33_SortArrayForMinNumber obj = new _33_SortArrayForMinNumber();
        String res = obj.printMinNumber2(new int[]{3, 32, 321});
        System.out.println(res);
    }

    // 设计一个比较规则，每次找到一个"最小值"
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

    // 直接使用比较规则进行排序(取决于排序算法)，时间复杂度更低，O(nlogn)<O(n^2)
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
