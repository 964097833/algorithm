package cn.yqd.itcast.test;

import cn.yqd.itcast.graph.Edge;
import cn.yqd.itcast.graph.EdgeWeightedGraph;
import cn.yqd.itcast.graph.PrimMST;
import cn.yqd.itcast.linear.Queue;

import java.io.BufferedReader;
import java.io.FileReader;

public class PrimTest {
    public static void main(String[] args) throws Exception {
        //创建输入流
        BufferedReader reader = new BufferedReader(new FileReader("src\\min_create_tree_test.txt"));
        //读取顶点数目，初始化EdgeWeightedGraph图
        int number = Integer.parseInt(reader.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(number);
        //读取边的数目
        int edgeNumber = Integer.parseInt(reader.readLine());
        //循环读取每一条边，并调用addEdge方法
        for (int i = 0; i < edgeNumber; i++) {
            String line = reader.readLine();
            int v = Integer.parseInt(line.split(" ")[0]);
            int w = Integer.parseInt(line.split(" ")[1]);
            double weight = Double.parseDouble(line.split(" ")[2]);
            G.addEdge(new Edge(v, w, weight));
        }
        //构建PrimMST对象
        PrimMST mst = new PrimMST(G);
        //获取最小生成树的边
        Queue<Edge> edges = mst.edges();
        //打印输出
        for (Edge edge : edges) {
            if (edge != null) {
                System.out.println(edge.either() + "-" + edge.other(edge.either()) + "::" +
                        edge.weight());
            }
        }
    }
}