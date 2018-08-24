package com.nowcoder.leetcode;

/**
 * Created by ChenRui on 18-3-4
 * 这代码让老子写的稀碎啊啊啊啊啊啊啊啊啊啊啊啊啊!!!!!!!!!!!!!!!!!!!!!!!!!
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(0);
        ListNode h = headNode;
        ListNode preNode = null;
        while (l1 != null && l2 != null) {
//            System.out.println(l1.val+","+l2.val);
            int temp = headNode.val;
            headNode.val = (l1.val + l2.val + headNode.val) % 10;
            if (l1.val + l2.val + temp >= 10) {
                headNode.next = new ListNode(1);
            } else headNode.next = new ListNode(0);
            l1 = l1.next;
            l2 = l2.next;
            preNode = headNode;
            headNode = headNode.next;

        }
        /*while (l2 != null) {

//            l2.val = (l2.val + headNode.val) % 10;
            if (l2.val + headNode.val >= 10) {
                headNode.next = new ListNode(1);
                l2 = l2.next;
                preNode = headNode;
                headNode = headNode.next;
            }else {
                l2.val = l2.val + headNode.val;
                preNode.next = l2;
                break;
            }

        }*/
        while(l2!=null){
            if (l2.val + headNode.val >= 10) {
                headNode.val = (l2.val + headNode.val) % 10;
                headNode.next = new ListNode(1);
                preNode = headNode;
                headNode = headNode.next;
                l2 = l2.next;
            }
            else {
                l2.val = l2.val + headNode.val;
                preNode.next = l2;
                return h;
            }
        }

        while(l1!=null){
            if (l1.val + headNode.val >= 10) {
                headNode.val = (l1.val + headNode.val) % 10;
                headNode.next = new ListNode(1);
                preNode = headNode;
                headNode = headNode.next;
                l1 = l1.next;
            }
            else {
                l1.val = l1.val + headNode.val;
                preNode.next = l1;
                return h;
            }
        }

//        while (l1 != null) {
//            l1.val = l1.val + headNode.val;
//            preNode.next = l1;
////            headNode = l1;    为什么不能连起来????? pay attention!!!!!!!
//        }
//        if (headNode.val==0) headNode = null;
        if (headNode.val == 0) preNode.next = null;
        else headNode.next = null;
        return h;

    }

    /**
     * 示例代码,只要有一个不为null就循环,这样后面就不用再去遍历了!!
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = null;
        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);
        listNode2.next.next.next = null;
        ListNode listNode = new AddTwoNumbers().addTwoNumbers2(listNode1, listNode2);
        while (listNode != null) {
//            listNode = listNode.next;
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
