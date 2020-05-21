package cn.yqd.itcast.test;

import cn.yqd.itcast.graph.BreadthFirstSearch;
import cn.yqd.itcast.graph.DepthFirstPaths;
import cn.yqd.itcast.graph.DepthFirstSearch;
import cn.yqd.itcast.graph.Graph;

public class GraphFirstSearchTest {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        graph.addEdge(0,6);
        graph.addEdge(0,2);
        graph.addEdge(0,1);
        graph.addEdge(0,5);
        graph.addEdge(5,3);
        graph.addEdge(5,4);
        graph.addEdge(3,4);
        graph.addEdge(6,4);
        BreadthFirstSearch search = new BreadthFirstSearch(graph, 0);
//        DepthFirstSearch search = new DepthFirstSearch(graph, 0);
    }

}
