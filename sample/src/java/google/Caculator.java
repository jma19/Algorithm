package google;

import java.util.Stack;

/**
 * Created by junm5 on 1/2/17.
 */
public class Caculator {
    public int calculate(String s) {
        //using stack to
        char[] array = s.trim().toCharArray();
        Stack<Integer> stack = new Stack();
        int number = 0; char preSign = '+';
        for(int i = 0; i < array.length; i++){
            if(array[i] >= '0' && array[i] <= '9'){
                number = number*10 + (array[i] - '0');
            }
            if(array[i] =='+' || array[i] == '-' || array[i] == '*' || array[i] =='/' || i ==( array.length - 1)) {
                if(preSign == '+'){
                    stack.push(number);
                }
                else if(preSign == '-'){
                    stack.push(-number);
                }else if(preSign == '*'){
                    stack.push(stack.pop()*number);
                }else{
                    stack.push(stack.pop()/number);
                }
                preSign = array[i];
                number = 0;
            }
        }
        int sum = 0;
        while(!stack.isEmpty()){
            Integer pop = stack.pop();
            System.out.println(pop);
            sum += pop;
        }
        return sum;
    }
    public static void main(String [] args){
        Caculator caculator = new Caculator();
        caculator.calculate("0-2147483647");
    }
}
