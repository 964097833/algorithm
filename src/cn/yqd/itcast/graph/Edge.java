package cn.yqd.itcast.graph;

/**
 * 加权无向图边的表示
 */
public class Edge implements Comparable<Edge> {
    //顶点一
    private final int v;
    //顶点二
    private final int w;
    //当前边的权重
    private final double weight;

    /**
     * 通过顶点v和w，以及权重weight值构造一个边对象
     * @param v
     * @param w
     * @param weight
     */
    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    /**
     * 获取边的权重值
     * @return
     */
    public double weight() {
        return weight;
    }

    /**
     * 获取边上的一个点
     * @return
     */
    public int either() {
        return v;
    }

    /**
     * 获取边上除了顶点vertex外的另外一个顶点
     * @param vertex
     * @return
     */
    public int other(int vertex) {
        if (vertex == v) {
            return w;
        } else {
            return v;
        }
    }

    /**
     * 比较当前边和参数that边的权重，如果当前边权重大，返回1
     * 如果一样大，返回0，如果当前权重小，返回-1
     * @param that
     * @return
     */
    public int compareTo(Edge that) {
        if (this.weight() - that.weight() > 0) {
            return 1;
        } else if (this.weight() - that.weight() < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
