package google;

import java.util.Stack;

/**
 * Created by junm5 on 1/2/17.
 */
public class Caculator1 {

    public int calculate(String s) {
        char ch[] = s.trim().toCharArray();
        Stack<Integer> stack = new Stack();
        int sign = 1, result = 0;
        for(int i = 0; i < ch.length; i++){
            int number = 0;
            if(ch[i] >= '0' && ch[i] <= '9'){
                while(i < ch.length && ch[i] >= '0' && ch[i] <= '9'){
                    number = number * 10  + (ch[i] - '0');
                    i++;
                }
                i --;
                result += sign * number;
            }
            else if(ch[i] == '+'){
                sign = 1;
            }else if(ch[i] == '-'){
                sign = -1;
            }else if(ch[i] == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            }else if(ch[i] == ')'){
                result = result  * (stack.pop()) + stack.pop();
            }
        }
        return result;
    }
    public static void main(String [] args){
        Caculator1 caculator1 = new Caculator1();
        int result = caculator1.calculate("1-1");
        System.out.println(result);
    }
}
