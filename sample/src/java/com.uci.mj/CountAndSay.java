package com.uci.mj;

import java.util.List;

/**
 * Created by junm5 on 9/22/16.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        int count = 1;
        while (count < n) {
            result = transform(result);
            count++;
        }
        return result;
    }


    private String transform(String str) {
        String result = "";
        int tempCnt = 1;
        char[] chs = str.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (i < chs.length - 1 && chs[i] == chs[i + 1]) {
                tempCnt++;
            } else {
                result = result + tempCnt + chs[i];
                tempCnt = 1;
            }
        }
        return result;
    }

    public static void main(String[] arsgs) {
        CountAndSay countAndSay = new CountAndSay();
        String transform = countAndSay.transform("111221");
        System.out.println(transform);
        String[] splits1 = "01".split("\\.");
        System.out.println(splits1.length);
    }
    //My name is Junma, I came from China. I got my bachor degree from Nanjing University of post and Telecommunocation
    //in 2014. After graduation,  software defined network and
    // I have two year working expeience.
    //network sys EECS who
    // distriburted system, service orientied archi
    public void transform(List<Integer> combinations, List<List<Integer>> result, int[] coins, int sum) {
        //sum the combinations List
        //if tempResult > sum, return directly
        //if tempResult = sum, add combinations to result

        for (int i = 0; i < coins.length; i++) {
            combinations.add(coins[i]);
            transform(combinations, result, coins, sum);
        }
    }

}
