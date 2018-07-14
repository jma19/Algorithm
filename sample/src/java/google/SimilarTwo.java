package google;

import java.util.*;

class SimilarTwo {
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, String[][] pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        Map<String, Set<String>> adjMap = buildAdjMap(pairs);
        for (int i = 0; i < words1.length; i++) {
            boolean adj = isAdj(words1[i], words2[i], adjMap);
            System.out.println(words1[i] + " " + words2[i] + " " + adj);
            if (!adj) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SimilarTwo solution = new SimilarTwo();
        solution.areSentencesSimilarTwo(new String[]{
                "great", "acting", "skills"
        }, new String[]{
                "fine", "drama", "talent"
        }, new String[][]{
                {"great", "good"}, {"fine", "good"}, {"drama", "acting"}, {"skills", "talent"}
        });
        System.out.println(3 << 2);



    }

    private boolean isAdj(String word1, String word2, Map<String, Set<String>> adjMap) {
        if (word1.equals(word2)) {
            return true;
        }
        if (!(adjMap.containsKey(word1) && adjMap.containsKey(word2))) {
            return false;
        }
        Queue<String> queue = new LinkedList();
        Set<String> visited = new HashSet();
        queue.offer(word1);
        visited.add(word1);
        while (!queue.isEmpty()) {
            String node = queue.poll();
            Set<String> adjs = adjMap.get(node);
            if (adjs.contains(word2)) {
                return true;
            }
            for (String adjNode : adjs) {
                if (!visited.contains(adjNode)) {
                    queue.offer(adjNode);
                    visited.add(adjNode);
                }
            }
        }
        return false;
    }

    private Map<String, Set<String>> buildAdjMap(String[][] pairs) {
        //build a adj Map
        Map<String, Set<String>> map = new HashMap();
        for (int i = 0; i < pairs.length; i++) {
            Set<String> vals1 = map.get(pairs[i][0]);
            if (vals1 == null) {
                vals1 = new HashSet();
                map.put(pairs[i][0], vals1);
            }
            vals1.add(pairs[i][1]);

            Set<String> vals2 = map.get(pairs[i][1]);
            if (vals2 == null) {
                vals2 = new HashSet();
                map.put(pairs[i][1], vals2);
            }
            vals2.add(pairs[i][0]);
        }
        return map;
    }


}