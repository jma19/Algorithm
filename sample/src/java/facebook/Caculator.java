package facebook;

import java.util.Stack;

/**
 * Created by junm5 on 1/20/17.
 */
public class Caculator {
    public int calculate(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        char[] chs =s.toCharArray();

        Stack<Integer> stack = new Stack<Integer>();
        char sign = '+';
        int num = 0;
        for(int i = 0; i < chs.length; i++){
            while(i < chs.length && Character.isDigit(chs[i])){
                num = num * 10 + (chs[i++] - '0');
            }
            if(i >= chs.length -1 || chs[i] == '+' || chs[i] == '-' || chs[i] == '*' || chs[i] == '/'){
                if(sign == '+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    stack.push(stack.pop()*num);
                }else if(sign == '/'){
                    stack.push(stack.pop()/num);
                }
                if(i <  chs.length){
                    sign = chs[i];
                }
                num = 0;
            }

        }
        int sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
    public static void main(String[] args){
        Caculator caculator = new Caculator();
        int calculate = caculator.calculate("1 / 1");
        System.out.println(calculate);
    }
}
