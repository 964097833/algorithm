package cn.yqd.itcast.test;

import cn.yqd.itcast.uf.UF_Tree_Weighted;

import java.io.BufferedReader;
import java.io.FileReader;

public class Traffic_Project {
    public static void main(String[] args) {
        // 创建字符缓冲输入流
        try (BufferedReader br =
                     new BufferedReader(new FileReader("src\\traffic_project.txt"))) {
            //读取城市数目，初始化并查集
            int number = Integer.parseInt(br.readLine());
            UF_Tree_Weighted uf = new UF_Tree_Weighted(number);
            //读取已经修建好的道路数目
            int roadNumber = Integer.parseInt(br.readLine());
            //循环读取已经修建好的道路，并调用union方法
            for (int i = 0; i < roadNumber; i++) {
                String line = br.readLine();
                int p = Integer.parseInt(line.split(" ")[0]);
                int q = Integer.parseInt(line.split(" ")[1]);
                uf.union(p, q);
            }
            // 获取剩余的分组数量
            int groupNumber = uf.count();
            // 计算出还需要修建的道路
            System.out.println("还需要修建"+(groupNumber-1)+"条道路，城市才能相通");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
