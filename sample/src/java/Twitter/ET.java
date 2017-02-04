package Twitter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Created by junm5 on 1/27/17.
 */
public class ET {
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        ET solution = new ET();
        String res = solution.parser("");
        //ABC(D(EFG)H)
        System.out.println(res);
    }

    private String parser(String exp) {
        String[] exps = exp.trim().split("/");
        if (exps.length == 1) {
            return exps[0];
        }
        //replace white space by ""
        String ex = exps[0].replace(" ", ""), ops = exps[1].replace(" ", "");
        for (int i = 0; i < ops.length(); i++) {
            char temp = ops.charAt(i);
            if (temp == 'R') {
                //jump the two R condition
                if (i + 1 < ops.length() && ops.charAt(i + 1) == 'R') {
                    i++;
                } else {
                    ex = reverse(ex);
                }
            } else if (temp == 'S') {
                if (i + 1 < ops.length() && ops.charAt(i + 1) == 'S') {
                    continue;
                }
                ex = simplify1(ex);
            }
        }
        return ex;
    }

    //simplify operation
    private String simplify(String exp) {
        if (exp == null || exp.length() == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int i = 0, ignored = 0, len = exp.length();
        if (exp.charAt(0) == '(') {
            i++;
            while (i < len && exp.charAt(i) != ')') {
                sb.append(exp.charAt(i++));
            }
            i++;
        }
        for (; i < exp.length(); i++) {
            if (exp.charAt(i) == '(') {
                if (i > 0 && exp.charAt(i - 1) == '(') {
                    ignored++;
                } else {
                    sb.append('(');
                }
            } else if (exp.charAt(i) == ')') {
                if (ignored == 0) {
                    sb.append(')');
                } else {
                    ignored--;
                }
            } else {
                sb.append(exp.charAt(i));
            }
        }
        return sb.toString();
    }

    static String simplify1(String s) {
        boolean firstLeft = true;
        char[] arr = s.toCharArray();
        Stack<Integer> stk = new Stack<>();
        List<Integer> index = new ArrayList<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ')') {
                stk.push(i);
            }
            if (arr[i] == '(') {
                int rightIndex = stk.pop();
                if (firstLeft == true) {
                    int leftIndex = i;
                    index.add(rightIndex);
                    index.add(leftIndex);
                    firstLeft = false;
                } else {
                    if (stk.isEmpty()) {
                        firstLeft = true;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder(s);
        Iterator<Integer> iterator = index.iterator();
        while (iterator.hasNext()) {
            int id = iterator.next();
            sb = sb.deleteCharAt(id);
        }
        return sb.toString();
    }


    //reverse string expression
    private String reverse(String exp) {
        char chs[] = exp.toCharArray();
        int start = 0, end = chs.length - 1;
        while (start <= end) {
            swap(chs, start, end);
            reverseParenthes(chs, start);
            reverseParenthes(chs, end);
            start++;
            end--;
        }
        return new String(chs);
    }

    //sawp two index value in an array
    private void swap(char[] ch, int start, int end) {
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
    }

    //transform '(' to ')', ')' to '('
    private void reverseParenthes(char[] chs, int index) {
        if (chs[index] == '(') {
            chs[index] = ')';
        } else if (chs[index] == ')') {
            chs[index] = '(';
        }
    }

}
