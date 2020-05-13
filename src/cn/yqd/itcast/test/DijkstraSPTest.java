package cn.yqd.itcast.test;

import cn.yqd.itcast.graph.DijkstraSP;
import cn.yqd.itcast.graph.DirectedEdge;
import cn.yqd.itcast.graph.EdgeWeightedDigraph;
import cn.yqd.itcast.linear.Queue;

import java.io.BufferedReader;
import java.io.FileReader;

public class DijkstraSPTest {
    public static void main(String[] args) {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("src\\min_route_test.txt"))) {
            //读取顶点数目，初始化EdgeWeightedDigraph图
            int number = Integer.parseInt(reader.readLine());
            EdgeWeightedDigraph G = new EdgeWeightedDigraph(number);
            //读取边的数目
            int edgeNumber = Integer.parseInt(reader.readLine());
            //循环读取每一条边，并调用addEdge方法
            for (int i = 0; i < edgeNumber; i++) {
                String line = reader.readLine();
                String[] strs = line.split(" ");
                int v = Integer.parseInt(strs[0]);
                int w = Integer.parseInt(strs[1]);
                double weight = Double.parseDouble(strs[2]);
                G.addEdge(new DirectedEdge(v,w,weight));
            }
            //根据图G和顶点0，构建DijkstraSP对象
            DijkstraSP dsp = new DijkstraSP(G, 0);
            //获取起点0到顶点6的最短路径
            Queue<DirectedEdge> edges = dsp.pathTo(6);
            //打印输出
            for (DirectedEdge edge : edges) {
                System.out.println(edge.from() + "->" + edge.to() + "::" + edge.weight());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
