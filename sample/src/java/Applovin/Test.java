package Applovin;

import java.util.HashMap;

/**
 * Created by junm5 on 1/15/17.
 */
public class Test {
    private final char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};

    public static void  main(String [] args){
        String str = "a    b  c d";
        String[] split = str.split(" ");

        for(int i = 0; i < split.length; i++){
            System.out.println("i:" + split[i]);
        }
    }
    public String toHex(int num) {
        if(num == 0){
            return "0";
        }
        String res = "";
        while(num != 0){
            res =  map[num & 15] + res;
            //The unsigned right shift operator ">>>" shifts a zero into the leftmost position,
            //while the leftmost position after ">>" depends on sign extension.
            num = num >>> 4;
        }
        return res;
    }
}
