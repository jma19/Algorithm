package google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junm5 on 5/6/18.
 */
public class Interveling {
    public boolean isInterleave(String s1, String s2, String s3) {
        //use dp, dp[i][j] means the prev i + j characters of s3 can be formed by i chars of s1, and j chars of s2
        if(s1 == null && s2 == null && s3 == null){
            return true;
        }
        int m = s1.length(), n = s2.length();

        if(m + n != s3.length()){
            return false;
        }

        boolean[][] cache = new boolean[m + 1][n + 1];
        cache[0][0] = true;
        for(int i = 1; i <= m; i++){
            cache[i][0] = cache[i-1][0] & (s1.charAt(i-1) == s3.charAt(i -1));
        }
        for(int i = 1; i <= n; i++){
            cache[0][i] = cache[0][i-1] & (s2.charAt(i-1) == s3.charAt(i -1));
        }
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                cache[i][j] = (cache[i][j-1] && (s2.charAt(j-1) == s3.charAt(i+j-1))
                        ||cache[i-1][j] && (s1.charAt(i-1) == s3.charAt(i+j-1)));
            }
        }
        return cache[m][n];
    }

    private boolean isInterleave(String s1, String s2, String s3, Map<String, Boolean> cache){
        if(cache.containsKey(s1 + s2)){
            return cache.get(s1 + s2);
        }
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty()){
            return true;
        }
        if(s3.isEmpty()){
            return false;
        }

        boolean result = false;

        if(!s1.isEmpty() && s1.charAt(0) == s3.charAt(0)){
            result |= isInterleave(s1.substring(1), s2, s3.substring(1), cache);
        }

        if(!s2.isEmpty() && s2.charAt(0) == s3.charAt(0)){
            result |= isInterleave(s1, s2.substring(1), s3.substring(1), cache);
        }
        cache.put(s1 + s2, result);
        return result;
    }

    public static void main(String[] args){
        Interveling interveling = new Interveling();
        boolean interleave1 = interveling.isInterleave(""
                , "b", "b");
        System.out.println(interleave1);
    }

}
