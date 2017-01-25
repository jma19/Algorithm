package LinkedIn;

import java.util.HashMap;

/**
 * Created by junm5 on 12/26/16.
 */
public class WordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        //word1 and word2 may be same
        int index1 = -1, index2 = -1, dis = Integer.MAX_VALUE;
        boolean equalInput = word1.equals(word2);
        for (int i = 0; i < words.length; i++) {
            if (equalInput && words[i].equals(word1)) {
                //updated smaller index
                if (index1 > index2) {
                    index2 = i;
                } else {
                    index1 = i;
                }
            }
            else if (words[i].equals(word1)) {
                index1 = i;
            } else if (words[i].equals(word2)) {
                index2 = i;
            }
            if (index1 != -1 && index2 != -1) {
                dis = Math.min(dis, Math.abs(index1 - index2));
            }
        }
        return dis;
    }
    public static void main(String[] args){
        WordDistanceIII wordDistanceIII = new WordDistanceIII();
        int distance = wordDistanceIII.shortestWordDistance(new String[]{"a", "a"}, "a", "a");
        System.out.println(distance);
    }
}
