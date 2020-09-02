package cn.yqd.zuo.basic;

/**
 * @description: 两个单链表相交的一系列问题
 * 【题目】 在本题中，单链表可能有环，也可能无环。给定两个
 * 单链表的头节点 head1和head2，这两个链表可能相交，也可能
 * 不相交。请实现一个函数， 如果两个链表相交，请返回相交的
 * 第一个节点；如果不相交，返回null 即可。 要求：如果链表1
 * 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外
 * 空间复杂度请达到O(1)。
 * @author: yuqiaodi
 * @date: 2020/9/1 14:02
 */
public class Code_20_FindFirstIntersectNode {

    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /** 获取第一个相交节点的主方法 */
    private static Node getIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);

        if (loop1 == null && loop2 == null) {
            // 第一种情况，两个链表都不成环
            return noLoop(head1, head2);
        } else if (loop1 != null && loop2 != null) {
            // 第二种情况，两个链表都成环
            return bothLoop(head1, head2);
        } else {
            // 第三种情况，两个链表只有一个成环，则两个链表一定不相交
            return null;
        }
    }

    /** 两个链表都不成环的情况 */
    private static Node noLoop(Node head1, Node head2) {
        /** 两个链表长度的差值 */
        int diff = 0;
        Node end1 = head1;
        Node end2 = head2;
        while (end1.next != null) {
            diff++;
            end1 = end1.next;
        }
        while (end2.next != null) {
            diff--;
            end2 = end2.next;
        }
        if (end1 != end2) {
            // 如果两个链表的尾节点不相等，则证明两个链表之间没有相交
            return null;
        }
        /** 通过diff的正负来把两个链表中较长的链表放进longLink中 */
        Node longLink = diff > 0 ? head1 : head2;
        /** 反则把较短的链表放进shortLink中 */
        Node shortLink = longLink == head1 ? head2 : head1;
        diff = Math.abs(diff);
        while (diff != 0) {
            diff--;
            // 长的链表先根据比短链表长的先走diff的长度
            longLink = longLink.next;
        }
        while (longLink != shortLink) {
            // 然后两个链表一起，当第一次出现相同节点时，就是它们的相交节点
            longLink = longLink.next;
            shortLink = shortLink.next;
        }
        return longLink;
    }

    /** 两个链表都成环的情况 */
    private static Node bothLoop(Node head1, Node head2) {
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if (loop1 == loop2) {
            // 两个链表的入环节点相同，则证明两个链表是先相交再入环
            int diff = 0;
            Node cur1 = head1;
            Node cur2 = head2;
            // 长度差值只计算到入环点为止
            while (cur1.next != loop1) {
                diff++;
                cur1 = cur1.next;
            }
            while (cur2.next != loop1) {
                diff--;
                cur2 = cur2.next;
            }
            Node longLink = diff > 0 ? head1 : head2;
            Node shortLink = longLink == head1 ? head2 : head1;
            diff = Math.abs(diff);
            while (diff != 0) {
                diff--;
                longLink = longLink.next;
            }
            while (longLink != shortLink) {
                longLink = longLink.next;
                shortLink = shortLink.next;
            }
            return longLink;
        } else {
            // 两个链表的入环节点不相等，则有两种情况
            Node cur = loop1.next;
            while (cur != loop1) {
                if (cur == loop2) {
                    // 当从一个入环节点能走到另一个入环节点时，说明两个链表是在环上相交，默认返回loop1
                    return loop1;
                }
                cur = cur.next;
            }
            // 当loop1走了一圈都没遇到loop2时，说明两个链表各自成环，互补不相交
            return null;
        }
    }

    /** 获取有环链表的入环节点，如果无环则返回null */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node fast = head.next.next;
        Node slow = head.next;
        // 有环则会出现相等的情况，无环则返回空
        while (fast != slow) {
            if (fast.next == null || fast.next.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        // 出现相等之后fast指针回到起点，两个指针步长都为1，它们相遇时的节点就是入环节点
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }


    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }

}
