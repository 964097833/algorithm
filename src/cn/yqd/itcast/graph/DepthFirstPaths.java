package cn.yqd.itcast.graph;

import cn.yqd.itcast.linear.Stack;

public class DepthFirstPaths {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 起点
    private int s;
    // 索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;

    /**
     * 构造深度优先搜索对象，使用深度优先搜索找出G图中起点为s的所有路径
     * @param G
     * @param s
     */
    public DepthFirstPaths(Graph G, int s) {
        //创建一个和图的顶点数一样大小的布尔数组
        this.marked = new boolean[G.V()];
        //创建一个和图顶点数一样大小的整型数组
        this.edgeTo = new int[G.V()];
        //初始化顶点
        this.s = s;
        //搜索G图中起点为s的所有路径
        dfs(G, s);
    }

    /**
     * 使用深度优先搜索找出G图中v顶点的所有相邻顶点
     * @param G
     * @param v
     */
    private void dfs(Graph G, int v) {
        //把当前顶点标记为已搜索
        marked[v] = true;
        //遍历v顶点的邻接表，得到每一个顶点w
        for (Integer w : G.adj(v)) {
            //如果当前顶点w没有被搜索过，则将edgeTo[w]设置为v,表示w的前一个顶点为v，并递归搜索与w顶点相通的其他顶点
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    /**
     * 判断v顶点与s顶点是否存在路径
     * @param v
     * @return
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * 找出从起点s到顶点v的路径(就是该路径经过的顶点
     * @param v
     * @return
     */
    public Stack pathTo(int v) {
        //当前v顶点与s顶点不连通，所以直接返回null，没有路径
        if (!hasPathTo(v)) return null;
        //创建路劲中经过的顶点的容器
        Stack<Integer> path = new Stack<Integer>();
        /**
         * 第一次把当前顶点存进去，然后将x变换为到达当前顶点的前一个顶点edgeTo[x],在把前一个顶点存进
         * 去，继续将x变化为到达前一个顶点的前一个顶点，继续存，一直到x的值为s为止，相当于逆推法，最后把s放进去
         */
        for (int x = v;x!=s;x=edgeTo[x]){
            //把当前顶点放入容器
            path.push(x);
        }

        //把起点s放入容器
        path.push(s);
        return path;
    }
}
