package Applovin;

/**
 * Created by junm5 on 1/16/17.
 */
public class LongestPalindrom {
    public int longestPalindrome(String s) {
        if(s == null || s.equals("")){
            return 0;
        }
        s = s.trim().toLowerCase();
        char[] chs = s.toCharArray();
        int max = 1;
        for(int i = 1; i < chs.length; i++){
            int odd = getPalidromeLen(chs, i, i);
            int even = getPalidromeLen(chs, i-1, i);
            max = Math.max(max, Math.max(odd, even));
        }
        return max;

    }
    private int getPalidromeLen(char[] chs, int start, int end){
        while(start >= 0 && end < chs.length && chs[start] == chs[end]){
            start--;
            end++;
        }
        return end - start - 1;
    }
    public static void main(String [] args){
        LongestPalindrom longestPalindrom = new LongestPalindrom();
        longestPalindrom.longestPalindrome("abccccdd");
    }
}
