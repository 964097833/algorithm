package cn.yqd.itcast.graph;

/**
 * 图的深度优先搜索
 */
public class DepthFirstSearch {
    // 索引代表顶点，值代表当前顶点是否已被搜索
    private boolean[] marked;
    // 记录有多少个顶点与s相通
    private int count;

    /**
     * 构造深度优先对象，使用深度优先搜索找出G图中s顶点的所有相通点
     * @param G
     * @param s
     */
    public DepthFirstSearch(Graph G, int s) {
        //创建一个和图的顶点数一样大小的布尔数组
        this.marked = new boolean[G.V()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        //搜索G图中与顶点s相同的所有顶点
        dfs(G, s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相通顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        // 当前顶点标记为已搜索
        marked[v] = true;
        System.out.println(v+" ");
        // 遍历v的邻接表，得到每一个顶点w
        for (Integer w : G.adj(v)) {
            // 如果该顶点未被搜索过，则递归搜索与w相关的其他顶点
            if (!marked(w)) dfs(G, w);
        }
        //相通的顶点数量加1
        count++;
    }

    /**
     * 判断顶点w与s是否相通
     * @param w
     * @return
     */
    public boolean marked(int w) {
        return marked[w];
    }

    /**
     * 与顶点相通的所有顶点数
     * @return
     */
    public int count() {
        return count;
    }
}
