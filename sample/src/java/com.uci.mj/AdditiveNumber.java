package com.uci.mj;

/**
 * Created by junm5 on 12/14/16.
 */
public class AdditiveNumber {
    public static void main(String [] args){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        boolean additiveNumber1 = additiveNumber.isAdditiveNumber("9801982396");

    }
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.equals("") || num.charAt(0) == '0') {
            return false;
        }
        int L = num.length();
        for (int i = 1; i < num.length() / 2; i++) {
            for (int j = i + 1; j < num.length(); j++) {
                if (num.charAt(j) == '0') {
                    continue;
                }
                if (dfs(num, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(String num, int i, int j, int k) {

        Integer number1 = Integer.valueOf(num.substring(i, j));
        String substring = num.substring(j, k);
        System.out.println(substring);
        Integer number2 = Integer.valueOf(substring);
        String sum = String.valueOf(number1 + number2);

        if (!num.substring(k).startsWith(sum)) {
            return false;
        }

        if (num.length() == (k + sum.length())) {
            return true;
        }
        return dfs(num, j, k, k + sum.length());

    }
}
