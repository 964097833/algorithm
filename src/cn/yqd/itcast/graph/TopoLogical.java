package cn.yqd.itcast.graph;

import cn.yqd.itcast.linear.Stack;

public class TopoLogical {
    //顶点的拓扑排序
    private Stack<Integer> order;

    /**
     * 构造拓扑排序对象
     * @param G
     */
    public TopoLogical(Digraph G) {
        //创建检测环对象，检测图G中是否有环
        DirectedCycle cycle = new DirectedCycle(G);
        //如果图中没有环，则创建顶点排序对象，对顶点进行排序
        if (!cycle.hasCycle()) {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    /**
     * 判断图G是否有环
     * @return
     */
    public boolean isCycle() {
        return order==null;
    }

    /**
     * 获取拓扑排序的所有顶点
     * @return
     */
    public Stack<Integer> order() {
        return order;
    }
}
