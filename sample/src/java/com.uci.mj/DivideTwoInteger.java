package com.uci.mj;

/**
 * Created by junm5 on 12/22/16.
 */
public class DivideTwoInteger {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return dividend >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if(dividend == 0){
            return 0;
        }

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        boolean isNegative = dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        int res = 0;
        while(a>=b){
            int shift = 0;
            while (a >= (b << shift)){
                shift++;
            }
            a -= b << (shift -1);
            res += 1 << (shift-1);
        }
        return isNegative ? -res : res;
    }
    public static void main(String [] args){
        DivideTwoInteger divideTwoInteger = new DivideTwoInteger();
        System.out.println(3 << 0);
        System.out.println(3<<3);
    }
}
