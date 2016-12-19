package com.uci.mj;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junm5 on 10/19/16.
 */
public class ShortestWordDistance {
    /*
    Given a list of words and two words word1 and word2,
    return the shortest distance between these two words in the list.
    For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
    Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes",
     word2 = "coding", return 1.
     */

    public int getShortestWordDistance(String[] list, String word1, String word2) {

        int index1 = -1, index2 = -1, distance = Integer.MAX_VALUE;

        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(word1)) {
                index1 = i;
            } else if (list[i].equals(word2)) {
                index2 = i;
            }
            distance = Math.min(distance, Math.abs(index1 - index2));
        }
        return distance;
    }
    class ShortestWordContainer{
        private Map<String, List<Integer>> wordsMap = new HashMap();

        ShortestWordContainer(List<String> words){

        }
    }
    /**
     This is a follow up of Shortest Word Distance.
     The only difference is now you are given the list of words
     and your method will be called repeatedly
     many times with different parameters. How would you optimize it?
     Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
     For example,
     Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

     Given word1 = "coding”, word2 = "practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
     */



}
