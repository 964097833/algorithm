package cn.yqd.itcast.uf;

public class UF_Tree {
    // 记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    // 记录并查集中数据的分组个数
    private int count;

    /**
     * 初始化并查集，以整数标识(0,N-1)个结点
     * @param N
     */
    public UF_Tree(int N) {
        // 初始情况下，每个元素都在一个独立的分组中，所以，初始情况下，并查集中的数据默认分为N个组
        this.count = N;
        // 初始化数组
        this.eleAndGroup = new int[N];
        // 把eleAndGroup数组的索引看做是每个结点存储的元素，把eleAndGroup数组每个索引处的值看做是该
        // 结点所在的分组，那么初始化情况下，i索引处存储的值就是i
        for (int i = 0; i < N; i++) {
            eleAndGroup[i] = i;
        }
    }

    /**
     * 获取当前并查集中的数据有多少个分组
     * @return
     */
    public int count() {
        return count;
    }

    /**
     * 判断并查集中元素p和元素q是否在同一分组中
     * @param p
     * @param q
     * @return
     */
    public boolean connected(int p,int q) {
        return find(p) == find(q);
    }

    /**
     * 元素p所在分组的标识符
     * @param p
     * @return
     */
    public int find(int p) {
        while (true) {
            //判断当前元素p的父结点eleAndGroup[p]是不是自己，如果是自己则证明已经是根结点了；
            if (eleAndGroup[p] == p) {
                return p;
            }
            //如果当前元素p的父结点不是自己，则让p=eleAndGroup[p]，继续找父结点的父结点,直到找到根结点为止；
            p = eleAndGroup[p];
        }
    }

    /**
     * 把p元素所在分组和q元素所在分组合并
     * @param p
     * @param q
     */
    public void union(int p,int q) {

        //如果p和q不在同一个分组，则只需要将p元素所在组的所有的元素的组标识符修改为q元素所在组的标识符即可
        int pRoot = find(p);
        int qRoot = find(q);
        //如果p和q已经在同一个分组中，则无需合并；
        if (pRoot == qRoot) return;
        // 如果p和q不在同一个分组，则只需要将p元素所在树根结点的父结点设置为q元素的根结点即可
        eleAndGroup[p] = eleAndGroup[q];
        //分组数量-1
        count--;
    }
}
