package org.cr.campusExam.zhihu;

/**
 * ��Ŀ���ƣ������沨�����ʽ�Ľ��
 * ʱ�����ƣ�1000ms
 * ��Ŀ�������沨���Ƿ��У����������ڲ������ĺ��档����������ġ�ʱ��д����3 4 +���������ǡ�3 + 4����
 * ����ж�������������������ڵڶ����������ĺ��棬���Գ�����׺�Ƿ��ġ�3 - 4 + 5��
 * ���沨���Ƿ���д����3 4 - 5 +������3��ȥ4���ټ���5��ʹ���沨���Ƿ���һ���ô��ǲ���Ҫʹ�����š�
 * ������׺�Ƿ��С�3 - 4 * 5���롰��3 - 4��*5������ͬ������׺�Ƿ���ǰ��д����3 4 5 * -����
 * ������ر�ʾ��3 (4 5 *) -��������д����3 4 - 5 *�������������������ο������ǻ���ݴ��������������֣�
 * <p>
 * ������������һ������һ������ n����ʾ����Ԫ������.(1<=n<=1000)
 * �ڶ�������n��Ԫ�ء�
 * <p>
 * �����������������Ľ����
 * ʾ��1
 * ����
 * 2 1 + 3 *
 * ���
 * 9
 */

import java.util.Scanner;
import java.util.Stack;

public class Main2 {
    public static int evalRPN(String[] tokens) {

        Stack<Integer> nums = new Stack<Integer>();

        for(String token : tokens){

            if(token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")){
                nums.push(evaulate(nums.pop(), nums.pop(), token));
            }else{
                nums.push(Integer.parseInt(token));
            }
        }

        return nums.pop();
    }

    private static int evaulate(int v2, int v1, String exp){
        switch(exp){
            case "+":
                return v1 + v2;
            case "-":
                return v1 - v2;
            case "/":
                return v1 / v2;
            default:
                return v1 * v2;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().trim();
        String[] split = str.split(" ");
        int res = evalRPN(split);
        System.out.println(res);
    }
}
