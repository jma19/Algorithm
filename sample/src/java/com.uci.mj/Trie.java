package com.uci.mj;

/**
 * Created by junm5 on 10/19/16.
 */
public class Trie {

    private TrieNode root = new TrieNode();

    public boolean search(String word) {
        TrieNode p = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (p.next[i] == null) {
                return false;
            }
            p = p.next[i];
        }
        return true;
    }

    public void addWord(String word) {
        TrieNode p = root;
        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (p.next[i] == null) {
                p.next[i] = new TrieNode();
            }
            p = p.next[i];
        }
        p.word = word;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

}
