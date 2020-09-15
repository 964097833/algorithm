package cn.yqd.zuo.basic;

import java.util.Stack;

/**
 * @description: 实现二叉树的先序、中序、后序遍历，包括递归方式和非递归方式
 * @author: yuqiaodi
 * @date: 2020/9/2 9:53
 */
public class Code_21_PreInPosTraversal {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    /** 借用栈来用非递归的方式实现二叉树的先序遍历 */
    private static void preOrderUnRecur(Node head) {
        System.out.print("pre-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    /** 借用栈来用非递归的方式实现二叉树的中序遍历 */
    private static void inOrderUnRecur(Node head) {
        System.out.print("in-order: ");
        if (head != null) {
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null) {
                // 当栈跟树同时为空时，遍历完整棵树
                if (head != null) {
                    // 把树左边的节点全都入栈
                    stack.push(head);
                    head = head.left;
                } else {
                    // 打印节点值然后到右边的节点
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    /** 使用类似前序遍历的方法，利用两个栈实现非递归的后序遍历 */
    private static void posOrderUnRecur1(Node head) {
        System.out.print("pos-order: ");
        if (head != null) {
            Stack<Node> saveStack = new Stack<>();
            Stack<Node> printStack = new Stack<>();
            saveStack.push(head);
            while (!saveStack.isEmpty()) {
                head = saveStack.pop();
                // 将<中右左>顺序遍历的结果放进一个栈里，在取出时就能得到后序遍历的顺序
                printStack.push(head);
                if (head.left != null) {
                    saveStack.push(head.left);
                }
                if (head.right != null) {
                    saveStack.push(head.right);
                }
            }
            while (!printStack.isEmpty()) {
                System.out.print(printStack.pop().value + " ");
            }
        }
        System.out.println();
    }

    /** 只用一个栈来实现二叉树的后序遍历，是一种比较极客的做法，只用一个栈在工程上并没有多少性能上的优势，比较炫技的做法，现在还没学，以后有空再学 */
    public static void posOrderUnRecur2(Node h) {
        System.out.print("pos-order: ");
        if (h != null) {
            Stack<Node> stack = new Stack<>();
            stack.push(h);
            Node c;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && h != c.right) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.print(stack.pop().value + " ");
                    h = c;
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(5);
        head.left = new Node(3);
        head.right = new Node(8);
        head.left.left = new Node(2);
        head.left.right = new Node(4);
        head.left.left.left = new Node(1);
        head.right.left = new Node(7);
        head.right.left.left = new Node(6);
        head.right.right = new Node(10);
        head.right.right.left = new Node(9);
        head.right.right.right = new Node(11);

        // recursive
        System.out.println("==============recursive==============");
        System.out.print("pre-order: ");
        preOrderRecur(head);
        System.out.println();
        System.out.print("in-order: ");
        inOrderRecur(head);
        System.out.println();
        System.out.print("pos-order: ");
        posOrderRecur(head);
        System.out.println();

        // unrecursive
        System.out.println("============unrecursive=============");
        preOrderUnRecur(head);
        inOrderUnRecur(head);
        posOrderUnRecur1(head);
        posOrderUnRecur2(head);

    }

    /** 递归形式的前序遍历 */
    private static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    /** 递归形式的中序遍历 */
    private static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

    /** 递归形式的后序遍历 */
    private static void posOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value + " ");
    }

}
