package facebook;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by junm5 on 1/5/17.
 */
public class LRUCache {
    class Entity{
        int value;
        int key;
        int timestamp;
        public Entity(int key, int value, int timestamp){
            this.value = value;
            this.key = key;
            this.timestamp = timestamp;
        }
    }

    private int capacity;
    private Map<Integer, Entity> map;
    private PriorityQueue<Entity> pq;
    private int timestamp = 0;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        pq = new PriorityQueue(new Comparator<Entity>(){
            public int compare(Entity o1, Entity o2){
                return o1.timestamp - o2.timestamp;
            }
        });
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Entity entity = map.get(key);
            pq.remove(entity);
            timestamp++;
            entity.timestamp = timestamp;
            pq.offer(entity);
            return entity.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if(capacity == 0){
            return;
        }
        timestamp++;
        if(map.containsKey(key)){
            Entity entity = map.get(key);
            pq.remove(entity);
            entity.value = value;
            entity.timestamp = timestamp;
            map.put(key, entity);
            pq.offer(entity);
            return;
        }
        if(map.size() == capacity) {
            //need to remove the least used item
            Entity entity = pq.poll();
            map.remove(entity.key);
            entity = new Entity(key, value, timestamp);
            map.put(key, entity);
            pq.offer(entity);
        }
        else{
            Entity entity = new Entity(key, value, timestamp);
            map.put(key, entity);
            pq.offer(entity);
        }
    }
    public static void main(String [] args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.set(2,1);
        lruCache.set(1,1);
        lruCache.set(2,3);
        lruCache.set(4,1);

        System.out.println(lruCache.get(1));// - 1
        System.out.println(lruCache.get(2)); // 3



    }
}
