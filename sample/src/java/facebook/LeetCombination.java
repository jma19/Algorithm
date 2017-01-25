package facebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 1/3/17.
 */
public class LeetCombination {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList();
        if(digits == null || digits.length() == 0){
            return res;
        }
        letterHelper(res, new StringBuffer(), digits, 0);
        return res;
    }
    String[] args = {"","", "abc","def","ghi","jkl","mno","pqrs","tuv", "wxyz"};
    void letterHelper(List<String> res, StringBuffer tempRes, String digits, int offset){

        if(tempRes.length() == digits.length()){
            res.add(tempRes.toString());
            return;
        }
        if(offset >= digits.length()){
            return;
        }
        String temp = args[digits.charAt(offset) - '0'];
        for(int i = 0; i < temp.length(); i++){
            tempRes.append(temp.charAt(i));
            letterHelper(res, tempRes, digits, offset + 1);
            tempRes.deleteCharAt(tempRes.length()-1);
        }
    }
    public static void main(String [] args){
        LeetCombination leetCombination = new LeetCombination();
        leetCombination.letterCombinations("2");
    }
}
