package cn.yqd.zuo.basic;

import java.util.HashMap;
import java.util.List;

/**
 * @description: 并查集结构
 * @author: yuqiaodi
 * @date: 2020/9/14 10:54
 */
public class Code_28_UnionFind {

    public static class Node {
        // 可以是存储任意基本类型的节点，不需要指针
    }

    public static class UnionFindSet {
        /** 使用map结构来代替node节点的指针 */
        public HashMap<Node, Node> fatherMap;
        /** 存该节点所在的树的size */
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet() {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
        }

        public void makeSets(List<Node> nodes) {
            fatherMap.clear();
            sizeMap.clear();
            // 初始时每个节点都指向自己，而且所在的树size为1
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        /** 寻找当前节点所在并查集的头节点 */
        private Node findHead(Node node) {
            /** 存储当前节点的父节点，用来后续对并查集进行扁平化的优化 */
            Node father = fatherMap.get(node);
            // 如果不是头节点则递归直到到达头节点为止
            if (father != node) {
                father = fatherMap.get(father);
            }
            // 拿到头节点，对沿途遍历过的节点进行扁平化优化
            fatherMap.put(node, father);
            return father;
        }

        /** 判断两个节点是否在同一个并查集中 */
        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        /** 和并两个节点所属的两个并查集 */
        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            // 获取两个节点的头节点
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                // 获取两个节点所在并查集的size
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                if (aSize < bSize) {
                    // 如果a小于b则把a并查集接到b并查集的下面
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSize + bSize);
                } else {
                    // 如果a大于等于b则把b并查集接到a并查集的下面
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSize + bSize);
                }
            }
        }
    }

}
