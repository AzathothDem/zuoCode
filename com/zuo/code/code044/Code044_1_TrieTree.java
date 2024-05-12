package com.zuo.code.code044;

import com.zuo.code.TreeNode;

public class Code044_1_TrieTree {

    class Trie {
        class TrieNode {
            public int pass;
            public int end;
            public TrieNode[] nexts;

            public TrieNode() {
                pass = 0;
                end = 0;
                nexts = new TrieNode[26];
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode node = root;
            node.pass++;
            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    node.nexts[path] = new TrieNode();
                }
                node = node.nexts[path];
                node.pass++;
            }
            node.end++;
        }

        public int countWordsEqualTo(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];

            }
            return node.end;
        }

        public int countWordsStartingWith(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                int path = word.charAt(i) - 'a';
                if (node.nexts[path] == null) {
                    return 0;
                }
                node = node.nexts[path];

            }
            return node.pass;
        }

        public void erase(String word) {
            if (countWordsEqualTo(word) > 0) {
                TrieNode node = root;
                node.pass--;
                for (int i = 0; i < word.length(); i++) {
                    int path = word.charAt(i) - 'a';
                    if (--node.nexts[path].pass == 0) {
                        node.nexts[path] = null;
                        return ;
                    }
                    node = node.nexts[path];
                }
                node.end--;
            }

        }

    }
}
