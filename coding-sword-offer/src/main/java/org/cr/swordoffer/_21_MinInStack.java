package org.cr.swordoffer;

import java.util.Stack;

/**
 * Created by ChenRui on 2018/3/28
 * <p>
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
public class _21_MinInStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int node) {
        s1.push(node);
        if (node < min)  s2.push(node);
        else s2.push(min); // 这种写法有问题，当最小值pop后，并没有更新最小值
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
