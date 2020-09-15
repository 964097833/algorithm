package cn.yqd.zuo.basic;

/**
 * @description: 已知一棵完全二叉树，求其节点的个数
 * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 * @author: yuqiaodi
 * @date: 2020/9/4 9:08
 */
public class Code_25_CompleteTreeNodeNumber {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    private static int nodeNum(Node head) {
        if (head == null) {
            return 0;
        }
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * 计算当前左树或右树的节点数，然后递归调用自身求出另一部分
     * @param node 当前子树的头节点
     * @param level 当前子树所在的层级
     * @param h 总树的高度
     * @return
     */
    public static int bs(Node node, int level, int h) {
        if (level == h) {
            return 1;
        }
        int rightLevel = mostLeftLevel(node.right, level + 1);
        if (rightLevel == h) {
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        } else {
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    /** 求出当前节点所在的高度位置 */
    public static int mostLeftLevel(Node node, int level) {
        while (node != null) {
            level++;
            node = node.left;
        }
        return level - 1;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        System.out.println(nodeNum(head));
    }

}
