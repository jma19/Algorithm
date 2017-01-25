package com.uci.mj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by junm5 on 12/19/16.
 */
public class FindMaxform {
    public int findMaxForm(String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        List<String> strList = new ArrayList();
        for (String str : strs) {
            strList.add(str);
        }
        Collections.sort(strList, new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        return o1.length() - o2.length();
                    }
                }
        );

        int res = 0, numberOfOne = 0, numberOfZero = 0;
        for (String str : strList) {
            System.out.println(str);
            numberOfOne = numberOfOne(str);
            numberOfZero = str.length() - numberOfOne;
            if (numberOfOne <= n && numberOfZero <= m) {
                res++;
                n -= numberOfOne;
                m -= numberOfZero;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FindMaxform findMaxform = new FindMaxform();
        findMaxform.findMaxForm(new String[]{"10", "0", "1"}, 1, 1);
    }

    /**
     *
     **/
    private int numberOfOne(String s) {
        if (s.equals("")) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
