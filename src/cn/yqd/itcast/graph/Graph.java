package cn.yqd.itcast.graph;

import cn.yqd.itcast.linear.Queue;

/**
 * 图
 */
public class Graph {
    // 记录顶点数量
    private final int V;
    // 记录边的数量
    private int E;
    // 邻接表
    private Queue[] adj;

    /**
     * 创建一个包含V个顶点但不包含边的图
     * @param v
     */
    public Graph(int v) {
        //初始化顶点数量
        this.V = v;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        adj = new Queue[V];
        //初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
        }
    }

    /**
     * 获取图中顶点的数量
     * @return
     */
    public int V() {
        return this.V;
    }

    /**
     * 获取图中边的数量
     * @return
     */
    public int E() {
        return this.E;
    }

    /**
     * 向图中添加一条边v-w
     * @param v
     * @param w
     */
    public void addEdge(int v,int w) {
        //把w添加到v的链表中，这样顶点v就多了一个相邻点w
        adj[v].enqueue(w);
        //把v添加到w的链表中，这样顶点w就多了一个相邻点v
        adj[w].enqueue(v);
        //边的数目自增1
        E++;
    }

    /**
     * 获取和顶点v相邻的所有顶点
     * @param v
     * @return
     */
    public Queue<Integer> adj(int v) {
        return adj[v];
    }
}
