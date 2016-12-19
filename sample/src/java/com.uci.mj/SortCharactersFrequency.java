package com.uci.mj;

import java.util.*;

/**
 * Created by junm5 on 11/8/16.
 */
public class SortCharactersFrequency {
    public String frequencySort(String s) {
        Map<Character, CharFre> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            CharFre val = map.get(s.charAt(i));
            if (val == null) {
                map.put(s.charAt(i), new CharFre(s.charAt(i), 1));
            } else {
                val.count += 1;
                map.put(s.charAt(i), val);
            }
        }
        Collection<CharFre> values = map.values();
        ArrayList<CharFre> list = new ArrayList(values);
        Collections.sort(list, Collections.reverseOrder());
        StringBuffer stringBuffer = new StringBuffer();
        for (CharFre charFre : list) {
            stringBuffer.append(charFre.ch);
        }
        return stringBuffer.toString();
    }
}

class CharFre implements Comparable<CharFre> {
    Character ch;
    Integer count;

    CharFre(Character ch, Integer count) {
        this.ch = ch;
        this.count = count;
    }

    public int compareTo(CharFre o) {
        if (this.count >= o.count) {
            return 1;
        } else {
            return 0;
        }
    }
}
