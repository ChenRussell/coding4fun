package org.cr.leetcode.binarytree;


import org.cr.leetcode.linkedlist.ListNode;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/27
 *
 * Given the head of a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * Example 2:
 *
 * Input: head = []
 * Output: []
 * Example 3:
 *
 * Input: head = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: head = [1,3]
 * Output: [3,1]
 */
public class _109ConvertSortedListtoBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }

        int[] arr = new int[count];
        p = head;
        count = 0;
        while (p != null) {
            arr[count++] = p.val;
            p = p.next;
        }
        return constructBST(arr, 0, arr.length - 1);
    }

    public TreeNode constructBST(int[] nums, int start, int end) {
        if (start > end) return null;
        int middle = (start + end) >> 1;
        TreeNode node = new TreeNode(nums[middle]);
        node.left = constructBST(nums, start, middle - 1);
        node.right = constructBST(nums, middle + 1, end);
        return node;
    }


    public TreeNode sortedListToBST_voted(ListNode head) {
        if(head==null) return null;
        return toBST(head,null);
    }
    public TreeNode toBST(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head==tail) return null;

        while(fast!=tail&&fast.next!=tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode thead = new TreeNode(slow.val);
        thead.left = toBST(head,slow);
        thead.right = toBST(slow.next,tail);
        return thead;
    }
}
