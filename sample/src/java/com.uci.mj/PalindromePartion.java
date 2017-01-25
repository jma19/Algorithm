package com.uci.mj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 12/18/16.
 */
public class PalindromePartion  {
    public List<List<String>> partition(String s) {
        //using backtrcking
        List<List<String>> res = new ArrayList();
        if(s == null || s.length() == 0){
            return res;
        }

        dfs(res, new ArrayList<String>(), s, 0);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> temp, String s, int start){
        if(start == s.length()){
            res.add(new ArrayList(temp));
            return;
        }
        for(int i = start; i < s.length(); i++){
            String subs = s.substring(start, i + 1);
            if(isPalindrome(subs)){
                temp.add(subs);
                dfs(res, temp, s, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean isPalindrome(String str){
        int start = 0, end = str.length() -1;
        while(start <= end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public static void main(String[] args){
        PalindromePartion palindromePartion = new PalindromePartion();
        List<List<String>> aab = palindromePartion.partition("aab");
        System.out.println(aab);
    }
}
