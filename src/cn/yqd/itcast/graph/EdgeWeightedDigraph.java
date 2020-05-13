package cn.yqd.itcast.graph;

import cn.yqd.itcast.linear.Queue;

public class EdgeWeightedDigraph {
    //记录顶点数
    private final int V;
    //边数
    private int E;
    //邻接表
    private Queue<DirectedEdge>[] adj;

    //创建一个含有V个顶点的空加权有向图
    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[V];
        //初始化邻接表中的空队列
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    //向加权有向图中添加一条边e
    public void addEdge(DirectedEdge edge) {
        int v = edge.from();
        adj[v].enqueue(edge);
        E++;
    }

    /**
     * 获取由顶点v指出的所有边
     * @param v
     * @return
     */
    public Queue<DirectedEdge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权有向图的所有边
     * @return
     */
    public Queue<DirectedEdge> edges() {
        //创建一个队列，存储所有的边
        Queue<DirectedEdge> allEdges = new Queue<>();
        //遍历顶点，拿到每个顶点的邻接表
        for (int i = 0; i < adj.length; i++) {
            //遍历邻接表，拿到邻接表中的每条边存储到队列中
            for (DirectedEdge edge : adj[i]) {
                allEdges.enqueue(edge);
            }
        }

        return allEdges;
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }
}
