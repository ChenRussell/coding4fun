package org.cr.swordoffer;

import java.util.ArrayList;

/**
 * Created by ChenRui on 2018/9/23.
 * <p>
 * ��Ŀ����
 * С����ϲ����ѧ,��һ����������ѧ��ҵʱ,Ҫ������9~16�ĺ�,�����Ͼ�д������ȷ����100��
 * ���������������ڴ�,�����뾿���ж������������������еĺ�Ϊ100(���ٰ���������)��
 * û���,���͵õ���һ������������Ϊ100������:18,19,20,21,22�����ڰ����⽻����,
 * ���ܲ���Ҳ�ܿ���ҳ����к�ΪS��������������? Good Luck!
 * �������:
 * ������к�ΪS�������������С������ڰ��մ�С�����˳�����м䰴�տ�ʼ���ִ�С�����˳��
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
