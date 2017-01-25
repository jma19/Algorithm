package google;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by junm5 on 1/2/17.
 */
public class LFUCache {

    class Entity {
        int key;
        int value;
        int order;
        //frequency
        int fre;

        public Entity(int key, int value, int fre, int order) {
            this.key = key;
            this.value = value;
            this.order = order;
            this.fre = fre;
        }

        @Override
        public String toString() {
            return "Entity{" +
                    "key=" + key +
                    ", value=" + value +
                    ", order=" + order +
                    ", fre=" + fre +
                    '}';
        }
    }

    Map<Integer, Entity> map;

    PriorityQueue<Entity> queue;

    private int capacity;
    private int order;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap();
        queue = new PriorityQueue<Entity>(new Comparator<Entity>() {
            public int compare(Entity o1, Entity o2) {
                return o1.fre != o2.fre ? o1.fre - o2.fre : o1.order - o2.order;
            }

        });
    }

    public int get(int key) {
        Entity value = map.get(key);
        if (value != null) {
            queue.remove(value);
            order++;
            value.order = order;
            value.fre = value.fre + 1;
            queue.offer(value);
            return map.get(key).value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.size() >= capacity) {
            Entity entity = queue.poll();
            System.out.println("delete" + entity.key);
            map.remove(entity.key);
        }
        order++;

        if (map.containsKey(key)) {
            Entity entity = map.get(key);
            Entity newEntity = new Entity(entity.key, value, entity.fre + 1, order);
            queue.remove(entity);
            map.put(key, newEntity);
            queue.remove(entity);
        } else {
            Entity entity = new Entity(key, value, 1, order);
            map.put(key, entity);
            queue.offer(entity);
        }
    }
    //["LFUCache","get","set","get","set","set","get","get"]
//[[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]

    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(2);
        lfuCache.get(2);
        lfuCache.set(2,6); //null
        lfuCache.get(1);
        lfuCache.set(1,5);  //null
        lfuCache.set(1, 2);  //2
        lfuCache.get(1);  //删掉 2, null
        lfuCache.get(2); // -1
        System.out.println('1' - '0');
    }
}
