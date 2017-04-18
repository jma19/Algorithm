package amaon;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junm5 on 3/6/17.
 */
public class SubstringAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> map = new HashMap();
        List<Integer> res = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int len = words[0].length();
        for (int i = 0; i < s.length(); i++) {
            Map<String, Integer> temp = new HashMap(map);
            for (int j = i; j <= s.length() - len; j = j + len) {
                String str = s.substring(j, j + len);
                //code change my fate
                if (temp.containsKey(str)) {
                    Integer val = temp.get(str);
                    if (val == 1) {
                        temp.remove(str);
                    } else {
                        temp.put(str, val - 1);
                    }
                }else if(!temp.isEmpty() && !temp.containsKey(str)){
                    break;
                }
                if(temp.isEmpty()){
                    res.add(i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubstringAllWords substringAllWords = new SubstringAllWords();
        List<Integer> barfoothefoobarman = substringAllWords.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"});
        System.out.println(barfoothefoobarman);
    }
}
