package com.uci.mj;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junm5 on 11/8/16.
 */
public class AllCombinationProblems {
//
//    public static void main(String[] args){
//        AllCombinationProblems allCombinationProblems = new AllCombinationProblems();
//        ArrayList<String> res = new ArrayList<String>();
//        allCombinationProblems.backtracking(new StringBuffer("abcd"), res, new StringBuffer());
//        for(String re : res){
//            System.out.println(re);
//        }
//    }

    void backtracking(StringBuffer org, List<String> res, StringBuffer temp){
        if(org.toString().equals("")){
            res.add(temp.toString());
            return;
        }
        for(int i = 0; i <org.length(); i++){
            temp.append(org.charAt(i));
            StringBuffer newOrg = new StringBuffer(org);
            backtracking(newOrg.deleteCharAt(i), res, temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }

    public static void main(String [] args){
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(1);
        integers.add(1);
        integers.add(1);
        integers.add(1);

        ArrayList<Integer> integers1 = new ArrayList<Integer>();
        integers1.add(1);
        integers1.add(1);
        integers1.add(1);
        integers1.add(1);

        System.out.println(integers.toString().equals(integers.toString()));

        System.out.println("abc".substring(1));

    }
}
