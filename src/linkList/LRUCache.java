package linkList;


import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 返回 1
        cache.put(3, 3); // 该操作会使得关键字 2 作废
        System.out.println(cache.get(2)); // 返回 -1

    }

    int capacity=0;
    Map<Integer,Integer> mp;
    public LRUCache(int capacity) {//构造方法
        this.capacity=capacity;
        mp=new LinkedHashMap<>();
    }
    //如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1
    public int get(int key) {
        Integer value=mp.remove(key);//存在的话返回值 不存在的话返回null
        if(value!=null){
            mp.put(key,value);
            return value;
        }
        return -1;
    }
    //如果关键字 key 已经存在，则变更其数据值 value
    //如果不存在，则向缓存中插入该组 key-value
    //如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
    public void put(int key, int value) {
        if(mp.remove(key)!=null){
            mp.put(key,value);
            return;
        }
        if(mp.size()>=capacity){
            Integer oldKey=mp.entrySet().iterator().next().getKey();//拿到最前边的key
            mp.remove(oldKey);
        }
        mp.put(key,value);
    }
}
