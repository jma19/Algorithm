package facebook;

/**
 * Created by junm5 on 1/10/17.
 */
public class ImplStrStr {
    public int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        for(int i = 0;; i++){
            for(int j = 0;; j++){
                if(j == n)  return i;
                if(i + j >= m) return -1;
                if(haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
    public static void main(String [] args){
        ImplStrStr implStrStr = new ImplStrStr();
        int i = implStrStr.strStr("123", "");
        System.out.println(i);
    }
}
