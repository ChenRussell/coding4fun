package org.cr.swordoffer;

import java.util.Stack;

/**
 * Created by ChenRui on 2018/3/28
 * <p>
 * ��Ŀ����
 * ����ջ�����ݽṹ�����ڸ�������ʵ��һ���ܹ��õ�ջ��СԪ�ص�min������
 */
public class _21_MinInStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        s1.push(node);
        if (node < min)  s2.push(node);
        else s2.push(min); // ����д�������⣬����Сֵpop�󣬲�û�и�����Сֵ
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
