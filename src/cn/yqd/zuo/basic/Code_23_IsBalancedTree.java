package cn.yqd.zuo.basic;

/**
 * @description: 判断一棵二叉树是否是平衡二叉树
 * @author: yuqiaodi
 * @date: 2020/9/3 9:50
 */
public class Code_23_IsBalancedTree {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class IsBAndHeight {
        private boolean isB;
        private int height;

        public IsBAndHeight(boolean isB, int height) {
            this.isB = isB;
            this.height = height;
        }
    }

    public static boolean isBalance(Node head) {
        return process(head).isB;
    }

    public static IsBAndHeight process(Node head) {
        // 以叶节点为头的树肯定平衡而且高度为0
        if (head == null) {
            return new IsBAndHeight(true,0);
        }
        // 获取左子树的平衡数据
        IsBAndHeight leftData = process(head.left);
        if (!leftData.isB) {
            return new IsBAndHeight(false, 0);
        }
        // 获取右子树的平衡数据
        IsBAndHeight rightData = process(head.right);
        if (!rightData.isB) {
            return new IsBAndHeight(false, 0);
        }
        // 两棵子树各自平衡时，判断两棵子树的高度差是否大于1
        if (Math.abs(leftData.height - rightData.height) > 1) {
            return new IsBAndHeight(false, 0);
        }
        // 两棵子树平衡则返回子树高度中的较大者，然后加上该节点高度返回
        return new IsBAndHeight(true, Math.max(leftData.height, rightData.height) + 1);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isBalance(head));

    }

}
