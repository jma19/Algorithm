package facebook;

/**
 * Created by junm5 on 1/5/17.
 */
public class ReverseString {
    public void reverseWords(char[] s) {
        reverse(s, 0, s.length - 1);  // reverse the whole string first
        int r = 0;
        while (r < s.length) {
            int l = r;
            while (r < s.length && s[r] != ' ')
                r++;
            reverse(s, l, r - 1);  // reverse words one by one
            r++;
        }
    }

    public void reverse(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l++] = s[r];
            s[r--] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String s = "the sky is blue";
        char[] s1 = s.toCharArray();
        reverseString.reverse(s1, 0, s.length() - 1);
        System.out.println(new String(s1));
    }
}
