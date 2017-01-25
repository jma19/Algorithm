package Applovin;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by junm5 on 1/14/17.
 */
public class ReverseString {
    public String reverse(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        while (left < right) {
            swap(chars, right, right);
        }
        return String.valueOf(chars);
    }

    private final String EMPTY_STR = "";

    private String reverseRecursive(String str) {
        if (str.equals(EMPTY_STR)) {
            return EMPTY_STR;
        }
        return reverseRecursive(str.substring(1)) + str.charAt(0);
    }

    private void swap(char[] chars, int i, int j) {
        char ch = chars[i];
        chars[i] = chars[j];
        chars[j] = ch;
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String abc = reverseString.reverseRecursive("abc");
        System.out.println(abc);
        Set<Integer> set = new HashSet<Integer>();
        set.add(1);
        Integer[] objects = (Integer[]) set.toArray();
    }


}
