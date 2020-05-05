package cn.yqd.itcast.test;


import cn.yqd.itcast.tree.BinaryTree;

/**
 * 二叉树的最大深度
 */
public class BinaryTreeMaxDepthTest {


    public static void main(String[] args) {
        //创建树对象
        BinaryTree<String, String> tree = new BinaryTree<>();
        //往树中添加数据
        tree.put("E", "5");
        tree.put("B", "2");
        tree.put("G", "7");
        tree.put("A", "1");
        tree.put("D", "4");
        tree.put("F", "6");
        tree.put("H", "8");
        tree.put("C", "3");

        int maxDepth = tree.maxDepth();
        System.out.println(maxDepth);
    }


}
