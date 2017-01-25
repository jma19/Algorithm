package facebook;

/**
 * Created by junm5 on 1/10/17.
 */
public class TernaryParser {
    public String parseTernary(String expression) {
        //recursively solve this problem
        int index = expression.indexOf("?");
        if(index == -1){
            return expression;
        }
        String prefix = expression.substring(0, index).trim();
        int split = expression.indexOf(":");
        return prefix.equals("T") ?
                parseTernary(expression.substring(index+1, split))
                : parseTernary(expression.substring(split + 1));


    }
    public static void main(String [] args){
        TernaryParser ternaryParser = new TernaryParser();
        String s = ternaryParser.parseTernary("F?1:T?4:5");
        System.out.println(s);
    }
}
