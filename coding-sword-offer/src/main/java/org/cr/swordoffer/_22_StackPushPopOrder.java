package org.cr.swordoffer;

import java.util.Stack;

/**
 * ��Ŀ����
 * ���������������У���һ�����б�ʾջ��ѹ��˳�����жϵڶ��������Ƿ�Ϊ��ջ�ĵ���˳��
 * ����ѹ��ջ���������־�����ȡ���������1,2,3,4,5��ĳջ��ѹ��˳������4��5,3,2,1�Ǹ�ѹջ���ж�Ӧ��һ���������У�
 * ��4,3,5,1,2�Ͳ������Ǹ�ѹջ���еĵ������С���ע�⣺���������еĳ�������ȵģ�
 */
public class _22_StackPushPopOrder {

    private static boolean Solution(int[] pushS, int[] popS) {
        if (pushS.length == 0 || popS.length == 0 || pushS.length != popS.length) return false;
        Stack<Integer> s = new Stack<Integer>();    // �����ռ�
        int popIndex = 0;   // ������������
        for (int i = 0; i < pushS.length; i++) {
            s.push(pushS[i]);
            while (!s.empty() && popS[popIndex] == s.peek()) {
                s.pop();
                popIndex++;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        int[] pushS = {1, 2, 3, 4, 5};
        int[] popS = {4, 5, 3, 1, 2};
        boolean boo = Solution(pushS, popS);
        System.out.println(boo);
    }

    /**
     * ���ӣ�https://www.nowcoder.com/questionTerminal/d77d11405cc7470d82554cb392585106
     ��Դ��ţ����

     ˼·������һ��������ջ������ѹջ˳���Ƚ���һ������ջ�У�������1��Ȼ���ж�ջ��Ԫ���ǲ��ǳ�ջ˳��ĵ�һ��Ԫ�أ�
     ������4������Ȼ1��4���������Ǽ���ѹջ��ֱ������Ժ�ʼ��ջ����ջһ��Ԫ�أ��򽫳�ջ˳������ƶ�һλ��ֱ������ȣ�
     ����ѭ����ѹջ˳�������ɣ��������ջ����Ϊ�գ�˵���������в��Ǹ�ջ�ĵ���˳��
     ������
     ��ջ1,2,3,4,5
     ��ջ4,5,3,2,1
     ����1�븨��ջ����ʱջ��1��4��������ջ2
     ��ʱջ��2��4��������ջ3
     ��ʱջ��3��4��������ջ4
     ��ʱջ��4��4����ջ4�������������һλ����ʱΪ5��,����ջ������1,2,3
     ��ʱջ��3��5��������ջ5
     ��ʱջ��5=5����ջ5,�����������һλ����ʱΪ3��,����ջ������1,2,3
     ��.
     ����ִ�У������ջΪ�ա������Ϊ��˵���������в��Ǹ�ջ�ĵ���˳��
     */
}
