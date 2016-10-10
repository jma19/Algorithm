package com.uci.mj;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junm5 on 10/9/16.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap();
        int bulls = 0, cows = 0;
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls ++;
            }else{
                Integer temp =  map.get(secret.charAt(i));
                if(temp == null){
                    map.put(secret.charAt(i), 1);
                }else{
                    map.put(secret.charAt(i), temp+1);
                }
            }
        }
        System.out.println(map.keySet()+":"+map.values());
        for(int i = 0; i < guess.length(); i++){
            Integer fre = map.get(guess.charAt(i));
            if(fre !=null && fre != 0){
                cows++;
                map.put(guess.charAt(i), fre -1);
            }
        }
        return "" +bulls + "A" + cows + "B";
    }

    public static void main(String[] args){
        BullsAndCows bullsAndCows = new BullsAndCows();
        String hint = bullsAndCows.getHint("1807", "7810");

    }
}
