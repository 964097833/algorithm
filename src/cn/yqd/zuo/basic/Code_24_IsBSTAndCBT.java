package cn.yqd.zuo.basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @description: 判断一棵树是否是搜索二叉树、判断一棵树是否是完全二叉树
 * @author: yuqiaodi
 * @date: 2020/9/3 10:47
 */
public class Code_24_IsBSTAndCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /** 判断是否是搜索二叉树 */
    public static boolean isBST(Node head) {
        if (head == null) {
            return false;
        }
        int pre = Integer.MIN_VALUE;
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.push(head);
                head = head.left;
            } else {
                head = stack.pop();
                if (pre >= head.value) {
                    return false;
                }
                pre = head.value;
                head = head.right;
            }
        }
        return true;
    }

    /** 判断是否是完全二叉树 */
    public static boolean isCBT(Node head) {
        if (head == null) {
            return false;
        }
        // 标志是否接下来遍历到的节点都应该为叶子节点
        boolean leaf = false;
        // 以队列来完成树的层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        // 队列为空时代表树遍历完成
        while (!queue.isEmpty()) {
            head = queue.poll();
            Node l = head.left;
            Node r = head.right;
            if (leaf) {
                // 当leaf==true，但l和r有任一不为空时返回false
                if (l != null || r != null) {
                    return false;
                }
            }
            // 有右子树没有左子树不符合完全二叉树定义，返回false
            if (l == null && r != null) {
                return false;
            }
            //
            if (l != null) {
                queue.offer(l);
            }
            if (r != null) {
                queue.offer(r);
            }
            // 表明已经来到最底层
            if (l == null && r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);

        printTree(head);
        System.out.println(isBST(head));
        System.out.println(isCBT(head));

    }

    // for test -- print tree
    public static void printTree(Node head) {
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "H", 17);
        System.out.println();
    }

    public static void printInOrder(Node head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "v", len);
        String val = to + head.value + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "^", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

}
