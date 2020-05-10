package cn.yqd.itcast.test;

import cn.yqd.itcast.graph.DepthFirstSearch;
import cn.yqd.itcast.graph.Graph;
import cn.yqd.itcast.uf.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.FileReader;

public class Traffic_Project2 {
    public static void main(String[] args) {
        // 创建字符缓冲输入流
        try (BufferedReader br =
                     new BufferedReader(new FileReader("src\\traffic_project.txt"))) {
            //读取城市数目，初始化Graph图
            int number = Integer.parseInt(br.readLine());
            Graph G = new Graph(number);
            //读取已经修建好的道路数目
            int roadNumber = Integer.parseInt(br.readLine());
            //循环读取已经修建好的道路，并调用addEdge方法
            for (int i = 0; i < roadNumber; i++) {
                String line = br.readLine();
                int p = Integer.parseInt(line.split(" ")[0]);
                int q = Integer.parseInt(line.split(" ")[1]);
                G.addEdge(p, q);
            }
            //根据图G和顶点9构建图的搜索对象
            DepthFirstSearch dfs = new DepthFirstSearch(G, 9);
            //调用搜索对象的marked(10)方法和marked(8)方法
            boolean flag1 = dfs.marked(10);
            boolean flag2 = dfs.marked(8);
            System.out.println("9号城市和10号城市是否已相通：" + flag1);
            System.out.println("9号城市和8号城市是否已相通：" + flag2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
