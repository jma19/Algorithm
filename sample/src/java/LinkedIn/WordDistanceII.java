package LinkedIn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junm5 on 12/26/16.
 */
public class WordDistanceII {
    /**
     * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
     * <p>
     * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
     * <p>
     * For example,
     * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
     * <p>
     * Given word1 = “coding”, word2 = “practice”, return 3.
     * Given word1 = "makes", word2 = "coding", return 1.
     */

    private Map<String, List<Integer>> map = new HashMap();

    public WordDistanceII(String[] words) {
        for(int i = 0; i < words.length; i++){
            List<Integer> temp = map.getOrDefault(words[i], new ArrayList<Integer>());
            temp.add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int res = 0;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int i = 0, j = 0, dis = Integer.MAX_VALUE;
        while(i < list1.size() && j < list2.size()){
            int val1 = list1.get(i);
            int val2 = list2.get(j);

            dis = Math.min(dis, Math.abs(val1 - val2));
            if(val1 > val2){
                j++;
            }else{
                i++;
            }
        }
        return dis;
    }

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
}
