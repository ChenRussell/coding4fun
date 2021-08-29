package org.cr.leetcode;

import java.util.Stack;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/29
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 *
 *
 * Example 1:
 *
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * Output
 * [null,null,null,null,-3,null,0,-2]
 *
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 *
 *
 * Constraints:
 *
 * -231 <= val <= 231 - 1
 * Methods pop, top and getMin operations will always be called on non-empty stacks.
 * At most 3 * 104 calls will be made to push, pop, top, and getMin.
 */
public class _155MinStack {

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;
    public long min;

    /** initialize your data structure here. */
    public _155MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        stack1.push(val);
        if (!stack2.isEmpty() && val <= stack2.peek() || val<= min) {
            stack2.push(val);
            min = val;
        } else {
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
        if (stack2.isEmpty()) {
            min = Long.MAX_VALUE;
        }
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }

    /**
     * 使用链表实现
     */
    private Node head;

    public void push2(int x) {
        if (head == null)
            head = new Node(x, x, null);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop2() {
        head = head.next;
    }

    public int top2() {
        return head.val;
    }

    public int getMin2() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}
