package cn.yqd.itcast.test;

import cn.yqd.itcast.graph.Digraph;
import cn.yqd.itcast.graph.TopoLogical;
import cn.yqd.itcast.linear.Stack;

import java.io.BufferedReader;
import java.io.FileReader;

public class TopoLogicalTest {
    public static void main(String[] args) {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("src\\road_find.txt"))) {
            //读取顶点个数，初始化Graph图
            int number = Integer.parseInt(br.readLine());
            Digraph G = new Digraph(number);
            //读取边的个数
            int roadNumber = Integer.parseInt(br.readLine());
            //读取边，并调用addEdge方法
            for (int i = 0; i < roadNumber; i++) {
                String line = br.readLine();
                int p = Integer.parseInt(line.split(" ")[0]);
                int q = Integer.parseInt(line.split(" ")[1]);
                G.addEdge(p, q);
            }
            //创建拓扑排序对象对象
            TopoLogical topo = new TopoLogical(G);
            Stack<Integer> order = topo.order();
            //遍历打印
            for (Integer w : order) {
                System.out.print(w+" ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
