package com.uci.mj;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by junm5 on 10/15/16.
 */
public class DifferentWayToAddP {
    private Set<Character> ops = new HashSet();


    {
        ops.add('+');
        ops.add('-');
        ops.add('*');
        ops.add('/');
    }

    public List<Integer> diffWaysToCompute(String input) {
        return helper(input);
    }

    private List<Integer> helper(String input) {
        List<Integer> res = new ArrayList();
        if (!(input.contains("*") || input.contains("+") || input.contains("-"))) {
            res.add(Integer.parseInt(input));
            return res;
        }
        for (int i = 0; i < input.length(); i++) {
            if (ops.contains(input.charAt(i))) {
                List<Integer> left = helper(input.substring(0, i));
                List<Integer> right = helper(input.substring(i + 1, input.length()));
                if (input.charAt(i) == '+') {
                    for (Integer val1 : left) {
                        for (Integer val2 : right) {
                            res.add(val1 + val2);
                        }

                    }
                } else if (input.charAt(i) == '-') {
                    for (Integer val1 : left) {
                        for (Integer val2 : right) {
                            res.add(val1 - val2);
                        }
                    }
                } else {
                    for (Integer val1 : left) {
                        for (Integer val2 : right) {
                            res.add(val1 * val2);
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        DifferentWayToAddP differentWayToAddP = new DifferentWayToAddP();
//        String str = "";
//        List<Integer> integers = differentWayToAddP.diffWaysToCompute("2-1-1");
//        System.out.println(integers);
        System.out.println((char)('a' + 25));
        String str = "asdjsacj.";
        int i = str.indexOf(".", 0);
        StringBuffer sb  = new StringBuffer(str);
        StringBuffer replace = sb.replace(i, i + 1, "#");
        System.out.println(replace);
    }

}
