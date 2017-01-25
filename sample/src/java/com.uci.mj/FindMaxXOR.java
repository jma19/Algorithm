package com.uci.mj;

import java.util.HashMap;

/**
 * Created by junm5 on 12/26/16.
 */
public class FindMaxXOR {

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int val : nums) {
            trie.insert(val);
        }

        int ans = 0;
        for (int val : nums) {
            ans = Math.max(ans, trie.count(val));
        }
        return ans;
    }

    public class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int num) {
            TrieNode cur = root;
            for (int i=31; i>=0; i--) {
                int val = (num>>i)&1;
                if (cur.getNode(val)==null) cur.addNode(val);
                cur = cur.getNode(val);
            }
        }

        public int count(int num) {
            TrieNode cur = root;
            int ans = 0;
            for (int i=31; i>=0; i--) {
                int val = (num>>i)&1;
                if (cur.getNode(val^1)==null) {
                    cur = cur.getNode(val);
                } else {
                    cur = cur.getNode(val^1);
                    ans |= (1<<i);
                }
            }
            return ans;
        }

        private class TrieNode {
            private TrieNode childNodes [];

            public TrieNode() {
                childNodes = new TrieNode[2];
            }

            public TrieNode getNode(Integer letter) {
                return childNodes[letter];
            }

            public void addNode(Integer letter) {
                childNodes[letter] = new TrieNode();
            }
        }
    }
    public static void main(String [] args){
        FindMaxXOR findMaxXOR = new FindMaxXOR();
        findMaxXOR.findMaximumXOR(new int[]{8,4});
    }
}
