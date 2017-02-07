package amaon;

/**
 * Created by junm5 on 2/5/17.
 */
public class Anagrams {
    //O(n) time
    public static boolean isAnagrams(String t1, String t2) {
        char[] chars = t1.toCharArray();
        int[] maps = new int[256];
        int numOfUniqueChar = 0;
        for (int i = 0; i < chars.length; i++) {
            if (maps[chars[i]] == 0) {
                numOfUniqueChar++;
            }
            maps[chars[i]]++;
        }
        for (int i = 0; i < t2.length(); i++) {
            char ch = t2.charAt(i);
            if (maps[ch] == 0) {
                return false;
            }
            maps[ch]--;
            if (maps[ch] == 0) {
                numOfUniqueChar--;
            }
            if (numOfUniqueChar == 0 && i == t2.length() - 1) {
                return true;

            }
        }
        return false;
    }
}
