package amaon;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by junm5 on 3/12/17.
 */
public class WorkB extends Worker {
    public static void main(String[] args){
        WorkA workA = new WorkA();
        workA.map.put("A", 1);
        System.out.println(workA.map.get("A"));

        WorkB workB = new WorkB();
        System.out.println(workB.map.isEmpty());
    }
}
