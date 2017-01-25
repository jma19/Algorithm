package com.uci.mj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 12/22/16.
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();

        dfs(result, "", n, n);
        return result;
    }


    private void dfs(List<String> result, String temp, int left, int right){
        if(left > right)
            return;

        if(left == 0 && right == 0){
            result.add(temp);
            return;
        }

        if(left > 0){
            dfs(result, temp+"(", left-1, right);
        }
        if(right > 0){
            dfs(result, temp+")", left, right-1);
        }
    }

    public static void main(String [] args){
        GenerateParentheses generateParentheses = new GenerateParentheses();
        generateParentheses.generateParenthesis(2);
    }
}
