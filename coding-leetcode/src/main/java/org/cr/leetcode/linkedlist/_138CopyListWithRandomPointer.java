package org.cr.leetcode.linkedlist;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/01/26
 *
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 *
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 *
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 *
 * Return the head of the copied linked list.
 *
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 *
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Example 2:
 *
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 * Example 3:
 *
 *
 *
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 *
 * Constraints:
 *
 * 0 <= n <= 1000
 * -10^4 <= Node.val <= 10^4
 * Node.random is null or is pointing to some node in the linked list.
 */
public class _138CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * An intuitive solution is to keep a hash table for each node in the list, via which we just need to iterate the list in 2 rounds respectively to create nodes and assign the values for their random pointers. As a result, the space complexity of this solution is O(N), although with a linear time complexity.
     *
     * Note: if we do not consider the space reversed for the output, then we could say that the algorithm does not consume any additional memory during the processing, i.e. O(1) space complexity
     *
     * As an optimised solution, we could reduce the space complexity into constant. The idea is to associate the original node with its copy node in a single linked list. In this way, we don't need extra space to keep track of the new nodes.
     *
     * The algorithm is composed of the follow three steps which are also 3 iteration rounds.
     *
     * Iterate the original list and duplicate each node. The duplicate
     * of each node follows its original immediately.
     * Iterate the new list and assign the random pointer for each
     * duplicated node.
     * Restore the original list and extract the duplicated nodes.
     * The algorithm is implemented as follows:
     */
    public Node copyRandomList(Node head) {
        Node p = head;
        // First round: make copy of each node, and link them together side-by-side in a single list.
        while (p != null) {
            Node next = p.next;
            Node cp = new Node(p.val);
            p.next = cp;
            cp.next = next;
            p = next;
        }

        // Second round: assign random pointers for the copy nodes.
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            } /*else {
                p.next.random = null;
            }*/
            p = p.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        Node dummyNode = new Node(-1), cp = dummyNode;
        p = head;
        while (p != null) {
            cp.next = p.next;
            cp = p.next;

            p.next = p.next.next;
            p = p.next;
        }
        return dummyNode.next;
    }
}
