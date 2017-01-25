package com.uci.mj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junm5 on 12/20/16.
 */
public class CanIWin1 {

    boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) {
            return false;
        }
        boolean[] used = new boolean[maxChoosableInteger + 1];
        return canWin(maxChoosableInteger, desiredTotal, used, new HashMap<Integer, Boolean>());
    }

    boolean canWin(int maxChoosableInteger, int total, boolean[] used, Map<Integer, Boolean> res) {
        int cur = transform(used);
        if (res.containsKey(cur)) {
            return res.get(cur);
        }
        for (int i = 0; i < maxChoosableInteger; ++i) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            cur = transform(used);
            if (total <= i + 1 || !canWin(maxChoosableInteger, total - (i + 1), used, res)) {
                res.put(cur, true);
                used[i] = false;
                return true;
            }
            res.put(cur, false);
            used[i] = false;
        }
        res.put(transform(used), false);
        return false;
    }

    private int transform(boolean[] res) {
        int cur = 0;
        for (int i = 0; i < res.length; i++) {
            cur = cur << 1;
            if (res[i]) {
                cur |= 1;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        CanIWin1 canIWin1 = new CanIWin1();

    }
}
