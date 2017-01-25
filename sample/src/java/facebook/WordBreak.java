package facebook;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.List;
import java.util.Map;

/**
 * Created by junm5 on 1/6/17.
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        //dp[i] stands for whether s.substring(0, i) can be breaked by wordDict
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }

    private boolean wordBreakHelper(String s, List<String> wordDict, Map<String, Boolean> map) {
        if (s.equals("")) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i + 1))) {
                if (wordBreakHelper(s.substring(i + 1), wordDict, map)) {
                    map.put(s, Boolean.TRUE);
                    return true;
                }
            }
        }
        map.put(s, Boolean.FALSE);
        return false;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println("123".substring(3).equals(""));
    }
}
