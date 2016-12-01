package com.uci.mj;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by junm5 on 11/20/16.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null || citations.length == 0) {
            return 0;
        }
        Integer[] cit = new Integer[citations.length];
        for (int i = 0; i < citations.length; i++) {
            cit[i] = citations[i];
        }
        Arrays.sort(cit, Collections.reverseOrder());

        int max = 0, m = citations.length;
        while (max < m && citations[max] >= max) {
            max++;
        }
        return max;

    }
}
