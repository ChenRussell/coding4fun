package org.cr.leetcode.stack;

import java.util.*;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/17
 * <p>
 * You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.
 * <p>
 * Implement the NestedIterator class:
 * <p>
 * NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
 * int next() Returns the next integer in the nested list.
 * boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
 * Your code will be tested with the following pseudocode:
 * <p>
 * initialize iterator with nestedList
 * res = []
 * while iterator.hasNext()
 * append iterator.next() to the end of res
 * return res
 * If res matches the expected flattened list, then your code will be judged as correct.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nestedList = [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * <p>
 * Input: nestedList = [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nestedList.length <= 500
 * The values of the integers in the nested list is in the range [-106, 106].
 */
public class _341FlattenNestedListIterator {


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }


    public class NestedIterator implements Iterator<Integer> {

        Queue<NestedInteger> queue;
        public NestedIterator(List<NestedInteger> nestedList) {
            queue = new LinkedList<>();
            init(nestedList);
        }

        public void init(List<NestedInteger> nestedList) {
            for (NestedInteger nestedInteger : nestedList) {
                if (!nestedInteger.isInteger()) {
                    init(nestedInteger.getList());
                } else {
                    queue.offer(nestedInteger);
                }
            }
        }

        @Override
        public Integer next() {
            NestedInteger poll = queue.poll();
            return poll == null ? null : poll.getInteger();
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }
    }


    public class NestedIterator2 implements Iterator<Integer> {

        Stack<NestedInteger> stack;
        public NestedIterator2(List<NestedInteger> nestedList) {
            stack = new Stack<>();
            for (int i = nestedList.size() - 1; i >= 0; i--) {
                stack.push(nestedList.get(i));
            }
        }

        @Override
        public Integer next() {
            NestedInteger pop = stack.pop();
            return pop == null ? null : pop.getInteger();
        }

        @Override
        public boolean hasNext() {
            while (!stack.isEmpty() && !stack.peek().isInteger()) {
                List<NestedInteger> list = stack.pop().getList();
                for (int i = list.size() - 1; i >= 0; i--) {
                    stack.push(list.get(i));
                }
            }
            return !stack.isEmpty();
        }
    }
}
