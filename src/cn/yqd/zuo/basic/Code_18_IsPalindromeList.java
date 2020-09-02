package cn.yqd.zuo.basic;


import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。
 * 例如： 1->2->1，返回true。 1->2->2->1，返回true。
 * 15->6->15，返回true。 1->2->3，返回false。
 * 进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
 * @Author yuqiaodi
 * @Date 2020/8/23 16:34
 * @Version 1.0
 */
public class Code_18_IsPalindromeList {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /** 额外空间为n */
    public static boolean isPalindrome1(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
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
        if (head == null || head.next == null) {
            return true;
        }
        Node cur = head;
        Node slow = head;
        Node fast = head;
        Stack<Node> stack = new Stack<>();
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        while (slow.next != null) {
            stack.push(slow.next);
            slow = slow.next;
        }

        while (!stack.isEmpty()) {
            if (stack.pop().value != cur.value) {
                return false;
            }
            cur = cur.next;
        }
        return true;
    }

    /** 额外空间为常数 */
    public static boolean isPalindrome3(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        // 找到链表的中点位置
        while (fast.next != null && fast.next.next != null) {
            // slow最终走到中点位置（偶数个为前一位）
            slow = slow.next;
            // fast最终走到链表的末尾
            fast = fast.next.next;
        }
        // former => mid
        Node former = slow;
        // 链表右边部分的第一个节点
        Node cur = slow.next;
        // mid.next = null
        former.next = null;
        Node next = null;
        // 反转右半部分链表
        while (cur != null) {
            // 保存cur右边的节点
            next = cur.next;
            // cur的next指向左边的节点
            cur.next = former;
            // former向右移动一个节点
            former = cur;
            // cur向右移动一个节点
            cur = next;
        }
        // 保存第一个头节点
        Node now = head;
        // 保存最后一个节点
        Node last = former;
        boolean res = true;
        // 从链表两端向中间遍历，比对是否回文
        while (now != null && last != null) {
            if (now.value != last.value) {
                res =  false;
                break;
            }
            // 比对相等则从链表两端继续往中间比对
            now = now.next;
            last = last.next;
        }
        // 在返回结果之前需要将链表复原
        cur = former;
        next = cur.next;
        cur.next = null;
        while (next.next != null) {
            // 三个指针分别保存三个节点
            former = cur;
            cur = next;
            next = next.next;
            // 改变节点的指向
            cur.next = former;
        }
        // 最后将mid节点next指向后一个节点
        next.next = cur;
        return res;
    }

    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }


}
