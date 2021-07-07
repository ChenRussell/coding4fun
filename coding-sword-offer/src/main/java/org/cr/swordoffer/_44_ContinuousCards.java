package org.cr.swordoffer;

import java.util.Arrays;

/**
 * Created by ChenRui on 18-4-17
 * <p>
 * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�2~10Ϊ���ֱ���AΪ1��JΪ11��
 * QΪ12��KΪ13��������С�����Կ����������֡�
 */
public class _44_ContinuousCards {

    static public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) return false;
        Arrays.sort(numbers);
        int count0 = 0;
        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) count0++;
        }

        // ͳ�Ƽ���ĸ��������С���ĸ�����ȡ���������򷵻�false
        for (int i = count0; i < numbers.length-1; i++) {
            // ������ظ���Ԫ�أ�ֱ�ӷ���false
            if (numbers[i+1] == numbers[i]) return false;
            count += numbers[i+1]-numbers[i]-1;
        }
        if (count>count0) return false;
        else return true;
    }

    public static void main(String[] args) {
        int num[] = {1,2,3,5,0};
        boolean res = isContinuous(num);
        System.out.println(res);
    }
}
