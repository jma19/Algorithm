package Twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class ExpressionTrees {

    public String expressionTree(String line) {
        String[] input = line.split("/");
        String exp = input[0];
        String ops = input[1].replace(" ", "");
        if (ops.length() == 0) {
            return exp;
        }
        exp = exp.replace(" ", "");
        for (int i = 0; i < ops.length(); i++) {
            if (ops.charAt(i) == 'R') {
                if (i + 1 < ops.length() && ops.charAt(i + 1) == 'R')
                    i++;
                else
                    exp = reverse(exp);
            } else if (ops.charAt(i) == 'S') {
                if (i + 1 < ops.length() && ops.charAt(i + 1) == 'S')
                    continue;
                exp = simplify(exp);
            }
        }
        return exp;
    }

    public String reverse(String exp) {
        char[] sc = exp.toCharArray();
        int start = 0, end = sc.length - 1;
        while (start <= end) {
            //swap start and end character
            swap(sc, start, end);
            //reverse parenthese
            reverseParenthese(sc, start);
            reverseParenthese(sc, end);
            start++;
            end--;
        }
        return new String(sc);
    }

    private void reverseParenthese(char[] ch, int index) {
        if (ch[index] == '(')
            ch[index] = ')';
        else if (ch[index] == ')')
            ch[index] = '(';
    }

    private void swap(char ch[], int start, int end) {
        char t = ch[start];
        ch[start] = ch[end];
        ch[end] = t;
    }

    static String simplify(String exp) {
        StringBuilder s = new StringBuilder();
        int i = 0, ignored = 0;
        if (exp.length() > 0 && exp.charAt(0) == '(') {
            i++;
            while (i < exp.length() && exp.charAt(i) != ')')
                s.append(exp.charAt(i++));
            i++;
        }
        for (; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                if (i > 0 && exp.charAt(i - 1) == '(')
                    ignored++;
                else
                    s.append('(');
            } else if (exp.charAt(i) == ')') {
                if (ignored == 0)
                    s.append(')');
                else
                    ignored--;
            } else
                s.append(exp.charAt(i));
        }
        return s.toString();
    } //simplify operation


    public static void main(String[] args) throws IOException {
        ExpressionTrees expressionTrees = new ExpressionTrees();
        String reverse = expressionTrees.expressionTree("A(BC)/RSR ");
        System.out.println(reverse);
    }

}
