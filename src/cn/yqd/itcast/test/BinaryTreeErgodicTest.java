package cn.yqd.itcast.test;


import cn.yqd.itcast.linear.Queue;
import cn.yqd.itcast.tree.BinaryTree;

public class BinaryTreeErgodicTest {


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

        /*//前序遍历
        Queue<String> keys = tree.preErgodic();
        //中序遍历
        Queue<String> keys = tree.midErgodic();
        //后序遍历
        Queue<String> keys = tree.afterErgodic();*/
        //测试层序遍历
        Queue<String> keys = tree.layerErgodic();
        for (String key : keys) {
            String value = tree.get(key);
            System.out.println(key+"----"+value);
        }

    }
}
