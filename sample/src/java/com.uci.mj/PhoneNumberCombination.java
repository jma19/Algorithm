package com.uci.mj;

import java.util.*;

/**
 * Created by junm5 on 11/2/16.
 */
public class PhoneNumberCombination {

    Map<Integer, String> map = new HashMap();

    {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "gkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();

        if (digits == null || digits.equals("")) {
            return res;
        }
        List<String> pool = new ArrayList<String>();

        for (int i = 0; i < digits.length(); i++) {
            int key = digits.charAt(i) - '0';
            pool.add(map.get(key));
        }
        compute(res, pool, pool.get(0), new StringBuffer());

        return res;
    }

    private void compute(List<String> res, List<String> pool, String current, StringBuffer tempRes) {
        if (tempRes.length() == pool.size()) {
            res.add(tempRes.toString());
        }
        for (int i = 0; i < current.length(); i++) {
            tempRes.append(current.charAt(i));
            current = pool.get(tempRes.length());
            compute(res, pool, current, tempRes);
            tempRes.deleteCharAt(tempRes.length() - 1);
        }
    }

    public static void main(String[] args) {

//        List<Integer> a = new ArrayList<Integer>();
//        a.add(1);
//        a.add(2);
//        List<Integer> b = new ArrayList<Integer>();
//        b.add(1);
//        b.add(2);
//        System.out.println(a.equals(b));
        System.out.println(((0.1+ 0.2) -  0.3) < 0.0000000001);

    }
}
