package facebook;

import java.util.*;

/**
 * Created by junm5 on 1/3/17.
 */
public class Solution {

    public String frequencySort(String s) {
        char[] chs = s.toCharArray();
        Map<Character, CFEntity> map = new HashMap();
        for (int i = 0; i < chs.length; i++) {
            CFEntity entity = map.get(chs[i]);
            if (entity == null) {
                map.put(chs[i], new CFEntity(chs[i], 1));
            } else {
                entity.fre++;
            }
        }
        List<CFEntity> res = new ArrayList();
        for (Character key : map.keySet()) {
            res.add(map.get(key));
        }
        Collections.sort(res, (o1, o2) -> o2.fre - o1.fre);
        StringBuffer sb = new StringBuffer();
        for (CFEntity entity : res) {
            int fre = entity.fre;
            for (int i = 0; i < fre; i++) {
                sb.append(entity.ch);
            }
        }
        //0 - 10 K 数组中位数....
        //[][]
        //k - 10 K
        return sb.toString();
    }

    class CFEntity {
        char ch;
        int fre;

        CFEntity(char ch, int fre) {
            this.ch = ch;
            this.fre = fre;
        }
    }
}