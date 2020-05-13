package cn.yqd.itcast.graph;

public class DirectedEdge {
    private int from;//起点
    private int to;//终点
    private double weight;//权重

    public DirectedEdge(int from, int to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    public int from() {
        return from;
    }

    public int to() {
        return to;
    }

    public double weight() {
        return weight;
    }
}
