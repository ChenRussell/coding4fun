package org.cr.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 2018/9/23.
 * <p>
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
 * 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 输出描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class _41_2_ContinuousSequenceWithSum {

    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (sum == 0) return res;
//        if (sum == 1) {
//            res.add(new ArrayList<>(Collections.singletonList(1)));
//        }
        int head = 1, tail = 2;
        while (head < tail) {
            if (calculateSum(head, tail) == sum) {
                ArrayList<Integer> temp = new ArrayList<>();
                addList(temp, head, tail);
                res.add(temp);
                tail++;
            } else if (calculateSum(head, tail) < sum) {
                tail++;
            } else {
                head++;
            }
        }
        return res;
    }

    private void addList(ArrayList<Integer> temp, int head, int tail) {
        for (int i = head; i <= tail; i++) {
            temp.add(i);
        }
    }

    private int calculateSum(int head, int tail) {
        int sum = 0;
        for (int i = head; i <= tail; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        _41_2_ContinuousSequenceWithSum findContinuousSequence = new _41_2_ContinuousSequenceWithSum();
        ArrayList<ArrayList<Integer>> res = findContinuousSequence.findContinuousSequence(11);
        for (ArrayList<Integer> re : res) {
            System.out.println(re);
        }
    }
}
