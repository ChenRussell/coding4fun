package org.cr.swordoffer;

import java.util.Stack;

/**
 * ��Ŀ����
 * ������ջ��ʵ��һ�����У���ɶ��е�Push��Pop������ �����е�Ԫ��Ϊint���͡�
 */
public class _7_QueueOfTwoStack {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.empty()) {
            return stack2.pop();
        } else {
            if (stack1.empty()) return 404;
            while(!stack1.empty()){
                Integer pop = stack1.pop();
                stack2.push(pop);
            }
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        _7_QueueOfTwoStack queueOfTwoStack = new _7_QueueOfTwoStack();
        queueOfTwoStack.stack1.push(1);
        queueOfTwoStack.stack1.push(2);
        queueOfTwoStack.stack2.push(3);
        System.out.println(queueOfTwoStack.pop());
    }
}
