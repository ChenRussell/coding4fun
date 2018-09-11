package com.nowcoder.campusExam.zhihu;

/**
 * 题目名称：计算逆波兰表达式的结果
 * 时间限制：1000ms
 * 题目描述：逆波兰记法中，操作符置于操作数的后面。例如表达“三加四”时，写作“3 4 +”，而不是“3 + 4”。
 * 如果有多个操作符，操作符置于第二个操作数的后面，所以常规中缀记法的“3 - 4 + 5”
 * 在逆波兰记法中写作“3 4 - 5 +”：先3减去4，再加上5。使用逆波兰记法的一个好处是不需要使用括号。
 * 例如中缀记法中“3 - 4 * 5”与“（3 - 4）*5”不相同，但后缀记法中前者写做“3 4 5 * -”，
 * 无歧义地表示“3 (4 5 *) -”；后者写做“3 4 - 5 *”。（测试用例仅做参考，我们会根据代码质量进行评分）
 * <p>
 * 输入描述：第一行输入一个整数 n，表示包含元素数量.(1<=n<=1000)
 * 第二行输入n个元素。
 * <p>
 * 输出描述：输出计算后的结果。
 * 示例1
 * 输入
 * 2 1 + 3 *
 * 输出
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