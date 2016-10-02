package com.uci.mj;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by junm5 on 9/29/16.
 */
public class DistinctNumber {
    public int numDistinct(String s, String t) {


        return backtracking(s, t, 0, 0);

    }

    private int backtracking(String s, String target, int start, int end) {
        if (end < start) {
            return 0;
        }
        if (end > s.length()) {
            return 0;
        }
        System.out.println(s.substring(start, end));
        if (s.substring(start, end).equals(target)) {
            return 1;
        }
        int res = 0;
        for (int i = start; i < s.length(); i++) {
            res += backtracking(s, target, i, end + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        DistinctNumber distinctNumber = new DistinctNumber();
        int backtracking = distinctNumber.backtracking("rabbbit", "rabbit", new StringBuffer(), 0);
        System.out.println(backtracking);
    }

    private void combine(String instr, StringBuffer outstr, int index) {
        Queue<String> strings = new LinkedList<String>();
        strings.add("1");
        strings.add("2");
        System.out.println(strings.poll());
        System.out.println(strings.poll());

//        for (int i = index; i < instr.length(); i++) {
//            outstr.append(instr.charAt(i));
//            System.out.println(outstr);
//            combine(instr, outstr, i + 1);
//            outstr.deleteCharAt(outstr.length() - 1);
//        }
    }

    private int backtracking(String s, String target, StringBuffer outstr, int index){

        if(outstr.toString().equals(target)){
            return 1;
        }

        int res = 0;
        for(int i = index; i < s.length(); i++){
            outstr.append(s.charAt(i));
            res += backtracking(s, target, outstr, i + 1);
            outstr.deleteCharAt(outstr.length() - 1);
        }
        return res;
    }

}
