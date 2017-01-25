package facebook;

/**
 * Created by junm5 on 1/6/17.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        char chs[] = s.toCharArray();

        int start = 0, end = chs.length - 1;
        while(start < end){
            while(chs[start] == ' '){
                start++;
            }
            while(chs[end] == ' '){
                end--;
            }
            if(chs[start] != chs[end]){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
    public static void main(String[] ars){
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String s = String.valueOf(new int[]{12, 2});
        String transform = validPalindrome.transform("aaa");
        System.out.println(transform);
    }
    private String transform(String s){
        char[] key = new char[26];
        char[] chs = s.toCharArray();
        for(char ch : chs){
            key[ch - 'a']++;
        }
        return String.valueOf(key);
    }
}
