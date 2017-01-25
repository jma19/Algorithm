package facebook;

import LinkedIn.Interval;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by junm5 on 1/1/17.
 */
public class TreeMapTest {
    public static void main(String [] args){
        TreeMap treeMap = new TreeMap();
        treeMap.put(1,2);
        treeMap.put(4,5);
        Map.Entry<Integer, Integer> entry = treeMap.floorEntry(1);
        System.out.println(entry.getKey() + entry.getValue());

    }
}
