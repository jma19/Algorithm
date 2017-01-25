package com.uci.mj;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by junm5 on 12/21/16.
 */
public class LetterCombination {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = digits.charAt(i) - '0';
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }

    public static void  main(String[] args){
        LetterCombination letterCombination = new LetterCombination();
        List<String> strings = letterCombination.letterCombinations("23");
        StringBuffer stringBuffer = new StringBuffer();
        LinkedList<String> res = new LinkedList();
    }

}
