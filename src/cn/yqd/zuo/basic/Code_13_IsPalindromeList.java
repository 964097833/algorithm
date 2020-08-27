package cn.yqd.zuo.basic;


import cn.yqd.itcast.linear.Stack;

/**
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回
 * 文结构。 例如： 1->2->1，返回true。 1->2->2->1，返回true。
 * 15->6->15，返回true。 1->2->3，返回false。
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂
 * 度达到O(1)。
 * @Author yuqiaodi
 * @Date 2020/8/23 16:34
 * @Version 1.0
 */
public class Code_13_IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /** 额外空间为n */
    public static boolean isPalindrome1(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node cur = head;
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }
        cur = head;
        while (!stack.isEmpty()) {
            if (cur.value != stack.pop()) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /** 额外空间为n/2 */
    public static boolean isPalindrome2(Node head) {

        Node cur = head;
        Node slow = head;
        Node fast = head;
        Stack<Node> stack = new Stack<>();
        while (fast != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow.next != null) {
            stack.push(slow.next);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != cur) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

//    /** 额外空间为常数 */
//    public static boolean isPalindrome3(Node head) {
//        Node cur = head;
//        Node slow = head;
//        Node fast = head;
//        while (fast != null && fast.next.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        Node now = slow.next;
//        slow.next = null;
//        Node pre = slow;
//        while (now.next != null) {
//            cur = now;
//            now = now.next;
////            pre.next =
//        }
//    }

}
