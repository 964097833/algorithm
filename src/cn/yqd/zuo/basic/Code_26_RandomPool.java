package cn.yqd.zuo.basic;

import java.util.HashMap;

/**
 * @description:
 * @author: yuqiaodi
 * @date: 2020/9/4 10:40
 */
public class Code_26_RandomPool {

    public static class Pool<K> {

        private HashMap<K, Integer> keyIndexMap;
        private HashMap<Integer, K> indexKeyMap;
        private Integer size;

        public Pool() {
            keyIndexMap = new HashMap<>();
            indexKeyMap = new HashMap<>();
            size = 0;
        }

        public void insert(K key) {
            if (keyIndexMap.containsKey(key)) {
                throw new RuntimeException("不能重复插入!");
            }
            keyIndexMap.put(key, size);
            indexKeyMap.put(size, key);
            size++;
        }

        /** 删除时要把最后索引的数据放到要删除的数据的位置，然后在两个map中删除最后一条数据 */
        public void delete(K key) {
            if (!keyIndexMap.containsKey(key)) {
                throw new RuntimeException("哈希表中无此key");
            }
            int deleteIndex = keyIndexMap.get(key);
            int lastIndex = --size;
            K lastKey = indexKeyMap.get(lastIndex);
            keyIndexMap.remove(key);
            indexKeyMap.remove(lastIndex);
            keyIndexMap.put(lastKey, deleteIndex);
            indexKeyMap.put(deleteIndex, lastKey);
        }

        public K getRandom() {
            int num = (int)(Math.random() * size);
            return indexKeyMap.get(num);
        }

    }

    public static void main(String[] args) {
        Pool<String> pool = new Pool<>();
        pool.insert("zuo");
        pool.insert("cheng");
        pool.insert("yun");
        System.out.println(pool.getRandom());
        pool.delete("yun");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());

    }

}
