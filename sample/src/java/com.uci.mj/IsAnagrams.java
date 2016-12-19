package com.uci.mj;

/**
 * Created by junm5 on 10/9/16.
 */
public class IsAnagrams {

    private boolean isAnagrams(String s, String t) {
        char[] s1 = new char[26];
        for(int i = 0; i < s.length(); i++){
            s1[s.charAt(i) - 'a']++;
        }
        char[] t1 = new char[26];
        for(int i = 0; i < t.length(); i++){
            t1[t.charAt(i) - 'a']++;
        }
        String x = new String(s1);
        String x1 = new String(t1);

        return x.equals(x1);
    }

    public static void main(String[] args) {
        IsAnagrams isAnagrams = new IsAnagrams();
        boolean anagrams = isAnagrams.isAnagrams("", "");
        System.out.println(anagrams);
    }
}
