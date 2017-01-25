package com.uci.mj;

/**
 * Created by junm5 on 12/21/16.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }
        if(x < 10){
            return true;
        }
        int temp = x;
        //number is the bit number of x
        int rad = 1, number = 0;
        while(temp !=0){
            temp = temp /10;
            number++;
            if(temp != 0){
                rad = 10*rad;
            }
        }
        int first, last;
        for(int i = 0; i <number/2; i++){
            first = x/rad;
            last = x % 10;
            if(first != last){
                return false;
            }
            //remove the first and last digit
            x = (x % rad)/10;
            rad = rad/100;
        }
        return true;
    }
    public static void main(String [] args){
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        boolean palindrome = palindromeNumber.isPalindrome(9999);
        System.out.println(palindrome);
    }
}
