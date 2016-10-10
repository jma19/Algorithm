package com.uci.mj;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by junm5 on 10/4/16.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            Integer val = map.get(ch[i]);
            if (val == null) {
                map.put(ch[i], 1);
            } else {
                map.put(ch[i], val + 1);
            }
        }

        Set<Character> keys = map.keySet();
        for (Character c : keys) {
            Integer val = map.get(c);
            if (max % 2 == 0) {
                max += val;
            } else {
                if (val % 2 == 0) {
                    max += val;
                } else {
                    max += val - 1;

                }
            }
        }
        return max;
    }
    public static void main(String [] args){
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        int abccccdd = longestPalindrome.longestPalindrome("abccccdd");
        System.out.println(abccccdd);

    }
}
