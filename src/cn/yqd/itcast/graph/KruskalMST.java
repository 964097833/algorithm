package cn.yqd.itcast.graph;

import cn.yqd.itcast.linear.Queue;
import cn.yqd.itcast.priority.MinPriorityQueue;
import cn.yqd.itcast.uf.UF_Tree_Weighted;

public class KruskalMST {
    //保存最小生成树的所有边
    private Queue<Edge> mst;
    /**
     * 索引代表顶点，使用uf.connect(v,w)可以判断顶点v和顶点w是否在同一颗树中，使用uf.union(v,w)可以
     * 把顶点v所在的树和顶点w所在的树合并
     */
    private UF_Tree_Weighted uf;
    //存储图中所有的边，使用最小优先队列，对边按照权重进行排序
    private MinPriorityQueue<Edge> pq;

    public KruskalMST(EdgeWeightedGraph G) {
        //初始化mst队列
        this.mst = new Queue<Edge>();
        //初始化并查集，容量和图的顶点数相同
        this.uf = new UF_Tree_Weighted(G.V());
        //初始化最小优先队列pq，容量比图的边的数量大1，并把图中所有的边放入pq中
        this.pq = new MinPriorityQueue<Edge>(G.E()+1);
        for (Edge edge : G.edges()) {
            pq.insert(edge);
        }
        //如果优先队列pq不为空，也就是还有边未处理，并且mst中的边还不到V-1条，继续遍历
        while (!pq.isEmpty() && mst.size() < G.V()-1) {
            //获取pq中权重最小的边
            Edge edge = pq.delMin();
            //取出该边的两个顶点
            int v = edge.either();
            int w = edge.other(v);
            //判断这两个顶点在uf中是否连通
            if (uf.connected(v, w)) {
                //如果连通则继续下一条边
                continue;
            }
            //如果不连通则将该边的两个顶点所在的两颗树合并为一棵树
            uf.union(v,w);
            //并将这条边加入到mst中
            mst.enqueue(edge);
        }
    }

    //获取最小生成树的所有边
    public Queue<Edge> edges() {
        return mst;
    }
}
