package cn.yqd.itcast.graph;

import cn.yqd.itcast.linear.Queue;

/**
 * 加权无向图的实现
 */
public class EdgeWeightedGraph {
    //记录顶点数量
    private final int V;
    //记录边的数量
    private int E;
    //邻接表
    private Queue<Edge>[] adj;

    /**
     * 创建一个带有V个顶点的空加权无向图
     * @param v
     */
    public EdgeWeightedGraph(int v) {
        V = v;
        this.E = 0;
        adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Edge>();
        }
    }

    /**
     * 获取图中的顶点数量
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
     * 向加权无向图中添加一条边e
     * @param e
     */
    public void addEdge(Edge e) {
        //获取边中的一个顶点v
        int v = e.either();
        //获取边中的另一个顶点w
        int w = e.other(v);
        //因为是无向图，所以边e需要同时出现在两个顶点的邻接表中
        adj[v].enqueue(e);
        adj[w].enqueue(e);
        //边的数量+1
        E++;
    }

    /**
     * 获取和顶点v相关联的所有边
     * @param v
     * @return
     */
    public Queue<Edge> adj(int v) {
        return adj[v];
    }

    /**
     * 获取加权无向图的所有边
     * @return
     */
    public Queue<Edge> edges() {
        //创建一个队列，存储所有的边
        Queue<Edge> allEdge = new Queue<>();
        //遍历顶点，拿到每个顶点的邻接表
        for (int i = 0; i < V; i++) {
            //遍历邻接表，拿到邻接表中的每条边
            for (Edge edge : adj[i]) {
                /*
                    因为无向图中，每条边对象Edge都会在两个顶点的邻接表中各出现一次，为了不重复获取，暂定
                    一条规则：
                    除了当前顶点v，再获取边e中的另外一个顶点w，如果v<w则添加，这样可以保证同一条边
                    只会被统计一次
                    */
                if (edge.other(i) < i) {
                    allEdge.enqueue(edge);
                }
            }
        }
        return allEdge;
    }
}
