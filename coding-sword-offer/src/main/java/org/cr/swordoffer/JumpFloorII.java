package org.cr.swordoffer;

/**
 * Created by ChenRui on 2018/2/19
 * ��Ŀ����
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 */
public class JumpFloorII {
    private int jumpFloorII(int target) {
        int result = 1;
        if (target < 1) return 0;
        else if (target == 1) return 1;
        for (int i = 2; i <= target; i++) {
            result *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        int i = new JumpFloorII().jumpFloorII(3);
        System.out.println(i);
    }
}
