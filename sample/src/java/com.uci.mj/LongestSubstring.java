package com.uci.mj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junm5 on 12/20/16.
 */
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Character> map = new HashMap();
        int j = 0;
        int max  = 0;
        char[] ch = s.toCharArray();
        for(int i = 0; i <ch.length; i++){
            while(j < ch.length && !map.containsKey(ch[j])){
                map.put(ch[j], ch[j]);
                j++;
                if(j - i > max){
                    max = j - i;
                }
            }
            map.remove(ch[i]);
        }
        return max;
    }
    public static void main(String [] args){
        boolean isEven = true;
        LongestSubstring longestSubstring = new LongestSubstring();
        int bbbbb = longestSubstring.lengthOfLongestSubstring("abcabcbb");
        System.out.println(bbbbb);
    }
}
