package com.uci.mj;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by junm5 on 12/14/16.
 */
public class Arithmetics {
    public int numberOfArithmeticSlices(int[] A) {
        int res = 0;

        Map<Integer, Integer>[] map = new Map[A.length];
        for (int i = 0; i < A.length; i++) {
            map[i] = new HashMap(i);
            for (int j = 0; j < i; j++) {
                long diff = (long) A[i] - A[j];
//                if (diff <= Integer.MIN_VALUE || diff > Integer.MAX_VALUE) continue;

                int d = (int) diff;
                int c1 = map[i].getOrDefault(d, 0);
                int c2 = map[j].getOrDefault(d, 0);
                res += c2;
                map[i].put(d, c1 + c2 + 1);
            }
        }
        for (Map map1 : map) {
            Set<Integer> set = map1.keySet();
            for (Integer key : set) {
                System.out.println(key + ":" + map1.get(key));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Arithmetics arithmetics = new Arithmetics();
        arithmetics.numberOfArithmeticSlices(new int[]{2, 4, 6, 8, 10});
    }
}
