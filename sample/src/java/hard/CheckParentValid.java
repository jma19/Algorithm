package hard;

import java.util.Stack;

/**
 * Created by junm5 on 9/24/17.
 */
public class CheckParentValid {
    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack();
        char chs[] = s.toCharArray();
        int cntOfStar = 0;
        for(char ch : chs){
            if(ch == '*'){
                cntOfStar++;
            }
            else if(ch == '(' || stack.isEmpty()){
                stack.push(ch);
            }else{
                if(stack.peek() == '('){
                    stack.pop();
                }else if(cntOfStar > 0){
                    cntOfStar--;
                }else{
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
    public static void main(String [] args){
        CheckParentValid checkParentValid = new CheckParentValid();

        checkParentValid.checkValidString("**((*");

    }
}
