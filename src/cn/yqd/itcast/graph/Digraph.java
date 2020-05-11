package cn.yqd.itcast.graph;

import cn.yqd.itcast.linear.Queue;

/**
 * 有向图
 */
public class Digraph {
    //记录顶点数量
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    /**
     * 创建一个包含V个顶点但不包含边的有向图
     * @param v
     */
    public Digraph(int v) {
        V = v;
        E = 0;
        adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    /**
     * 获取图中顶点的数量
     * @return
     */
    public int V() {
        return V;
    }

    /**
     * 获取图中边的数量
     * @return
     */
    public int E() {
        return E;
    }

    /**
     * 向有向图中添加一条边 v->w
     * @param v
     * @param w
     */
    public void addEdge(int v,int w) {
        adj[v].enqueue(w);
        E++;
    }

    /**
     * 获取由v指出的边所连接的所有顶点
     * @param v
     * @return
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 该图的反向图
     * @return
     */
    private Digraph reverse() {
        Digraph r = new Digraph(V);
        for (int i = 0; i < r.V(); i++) {
            for (Integer w : adj(i)) {
                r.addEdge(w, i);
            }
        }
        return r;

    }


}
