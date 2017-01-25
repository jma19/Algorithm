package com.uci.mj;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junm5 on 12/13/16.
 */
public class CanIWin {
    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(10, 11));
    }

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
            return false;
        }
        Map<String, Boolean> tempRes = new HashMap();
        int[] used = new int[maxChoosableInteger + 1];

        return helper(tempRes, used, desiredTotal);
    }

    boolean helper(Map<String, Boolean> map, int[] used, int desiredTotal) {

        String key = Arrays.toString(used);

        if (map.containsKey(key)) {
            return map.get(key);
        }
        for (int i = 1; i < used.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                if (desiredTotal <= i || !helper(map, used, desiredTotal - i)) {
                    map.put(key, true);
                    used[i] = 0;
                    return true;
                }
                used[i] = 0;
            }
        }
        map.put(key, false);
        return false;

    }
}
