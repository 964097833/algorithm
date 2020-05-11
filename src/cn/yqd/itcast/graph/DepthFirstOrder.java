package cn.yqd.itcast.graph;

import cn.yqd.itcast.linear.Stack;

/**
 * 顶点排序
 */
public class DepthFirstOrder {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //使用栈，存储顶点序列
    private Stack<Integer> reversePost;

    /**
     * 创建一个顶点排序对象，生成顶点线性序列
     * @param G
     */
    public DepthFirstOrder(Digraph G) {
        marked = new boolean[G.V()];
        reversePost = new Stack<Integer>();
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) dfs(G, i);
        }
    }

    /**
     * 基于深度优先搜索，生成顶点线性序列
     * @param G
     * @param v
     */
    private void dfs(Digraph G,int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
        reversePost.push(v);
    }

    /**
     * 获取顶点线性序列
     * @return
     */
    public Stack<Integer> reversePost() {
        return reversePost;
    }
}
