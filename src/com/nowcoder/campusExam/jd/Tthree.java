package com.nowcoder.campusExam.jd;

import java.util.Scanner;
import java.util.Stack;

/**
 * 给定两个括号字符串，判断交换一个是否能变为合法闭合的括号字符串
 */

public class Tthree {

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                stack.push(chars[i]);
            }

            if (chars[i] == ')' || chars[i] == ']' || chars[i] == '}') {
                if (!stack.empty()) {
                    Character peek = stack.peek();
                    if (peek == '(' && chars[i] == ')' || peek == '[' && chars[i] == ']' || peek == '{' && chars[i] == '}') {
                        stack.pop();
                    } else return false;
                } else return false;
            }
        }
        if (stack.empty()) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k = 0; k < n; k++) {
            String str = sc.next();
            char[] chars = str.toCharArray();
            boolean flag = true;
            for (int i = 0; i < chars.length && flag; i++) {
                for (int j = i + 1; j < chars.length; j++) {
                    if (chars[i] != chars[j]) {
                        char temp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = temp;
                        String s = String.valueOf(chars);
                        if (isValid(s)) {
                            System.out.println("Yes");
                            flag = false;
                            break;
                        } else {
                            char temp2 = chars[i];
                            chars[i] = chars[j];
                            chars[j] = temp2;
                        }
                    }
                }
            }
            if (flag) System.out.println("No");
        }


//        boolean res = new Tthree().isValid("(())");
//        System.out.println(res);
    }
}
