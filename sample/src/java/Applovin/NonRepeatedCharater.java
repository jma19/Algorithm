package Applovin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by junm5 on 1/14/17.
 */
public class NonRepeatedCharater {
    //Object
    public Character getFirstNonRepeatedChar(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        Map<Character, Integer> map = new HashMap();
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            Integer val = map.getOrDefault(ch, 0);
            map.put(ch, val + 1);
        }
        for (char ch : chars) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }
        return null;
    }
}
