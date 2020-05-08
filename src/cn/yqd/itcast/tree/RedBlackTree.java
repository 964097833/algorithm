package cn.yqd.itcast.tree;

import com.sun.deploy.util.BlackList;

public class RedBlackTree<Key extends Comparable<Key>, Value> {
    // 根节点
    private Node root;
    // 记录树中元素的个数
    private int N;
    // 红色链接
    private static final boolean RED = true;
    // 黑色链接
    private static final boolean BLACK = false;

    /**
     * 判断当前结点的父指向链接是否为红色
     * @param x
     * @return
     */
    private boolean isRed(Node x) {
        // 空结点默认是黑色链接
        if (x == null) {
            return BLACK;
        }
        // 非空结点需要判断结点color属性的值
        return x.color;
    }

    /**
     * 左旋转
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        // 找出当前结点h的右子结点
        Node hRight = h.right;
        // 找出右子结点的左子结点
        Node lhRight = hRight.left;
        // 让当前结点h的右子结点的左子结点成为当前结点的右子结点
        h.right = lhRight;
        // 让当前结点h成为右子结点的左子结点
        hRight.left = h;
        // 让当前结点h的color变成右子结点的color
        hRight.color = h.color;
        // 让当前结点h的color变成RED
        h.color = RED;
        // 返回当前结点的右子结点
        return hRight;
    }

    /**
     * 右旋
     * @param h
     * @return
     */
    private Node rotateRight(Node h) {
        // 找出当前结点h的左子结点
        Node hLeft = h.left;
        // 找出当前结点h的左子结点的右子结点
        Node rHleft = hLeft.right;
        // 让当前结点h的左子结点的右子结点成为当前结点的左子结点
        h.left = rHleft;
        // 让当前结点h的color值成为左子结点的color值
        hLeft.color = h.color;
        // 让当前结点h的color变为RED
        h.color = RED;
        // 返回当前结点的左子结点
        return hLeft;
    }

    /**
     * 颜色反转，相当于完成拆分4-结点
     * @param h
     */
    private void flipColors(Node h) {
        // 当前结点的color属性值变为RED
        h.color = RED;
        // 当前结点的左右子结点的color属性值都变为黑色
        h.left.color = BLACK;
        h.right.color = RED;
    }

    /**
     * 在整个树上完成插入操作
     *
     * @param key
     * @param val
     */
    public void put(Key key, Value val) {
        //在root整个树上插入key-val
        root = put(root, key, val);
        //让根结点的颜色变为BLACK
        root.color = BLACK;
    }

    /**
     * 在指定树中，完成插入操作，并返回添加元素后新的树
     * @param h
     * @param key
     * @param val
     * @return
     */
    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            // 标准的插入操作，和父结点用红链接相连
            N++;
            return new Node(key,val,null,null,RED);
        }

        // 比较要插入的键和当前结点的键
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            // 继续寻找左子树插入
            h.left = put(h.left,key,val);
        } else if (cmp > 0) {
            // 继续寻找右子树插入
            h.right = put(h.right,key,val);
        } else {
            // 已经有相同的结点存在，修改结点的值
            h.value = val;
        }

        // 如果当前结点的有链接是红色，左链接是黑色，需要左旋
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }

        // 如果当前结点的左子结点和左子结点的左子结点都是红色链接，则需要右旋
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }

        // 如果当前结点的左链接和右链接都是红色，需要颜色变换
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }

        //返回当前结点
        return h;
    }

    // 根据key，从树中找出对应的值
    public Value get(Key key) {
        return get(root,key);
    }

    // 从指定的树x中，查找key对应的值
    public Value get(Node x, Key key) {
        // 如果当前结点为空，则没有找到，返回null
        if (x == null) {
            return null;
        }

        // 比较当前结点的键和key
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            // 如果要查询的key小于当前结点的key，则继续找当前结点的左子结点
            return get(x.left,key);
        } else if (cmp > 0) {
            // 如果要查询的key大于当前结点的key，则继续找当前结点的右子结点
            return get(x.right,key);
        } else {
            // 如果要查询的key等于当前结点的key，则树中返回当前结点的value
            return x.value;
        }
    }

    // 获取树中元素的个数
    public int size() {
        return N;
    }

    /**
     * 结点类
     */
    private class Node {
        // 存储键
        public Key key;
        // 存储值
        public Value value;
        // 记录左子结点
        public Node left;
        // 记录右子结点
        public Node right;
        // 由其父结点指向它的链接的颜色
        public boolean color;

        public Node(Key key, Value value, Node left, Node right, boolean color) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.color = color;
        }
    }
}
