package org.cr.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/11
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 *
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 * Example 2:
 *
 *
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"]
 * Output: []
 *
 *
 * Constraints:
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] is a lowercase English letter.
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] consists of lowercase English letters.
 * All the strings of words are unique.
 */
public class _212WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for(String word : words) {
            char[] arr = word.toCharArray(); // word[i] faster than word.charAt(i)
            if(exist(board, arr)) {
                res.add(word);
            }
        }
        return res;
    }

    public boolean exist(char[][] board, char[] word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(exist(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    public boolean exist(char[][] board, char[] word, int row, int col, int pos) {
        if(pos == word.length) return true;
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) return false;
        if(board[row][col] != word[pos]) return false;
        board[row][col] = '*';
        boolean res = exist(board, word, row+1, col, pos+1) ||
                exist(board, word, row-1, col, pos+1) ||
                exist(board, word, row, col-1, pos+1) ||
                exist(board, word, row, col+1, pos+1);
        board[row][col] = word[pos];
        return res;
    }

    /**
     * 优化方法
     *
     * Intuitively, start from every cell and try to build a word in the dictionary.
     * Backtracking (dfs) is the powerful way to exhaust every possible ways.
     * Apparently, we need to do pruning when current character is not in any word.
     *
     * How do we instantly know the current character is invalid? HashMap?
     * How do we instantly know what's the next valid character? LinkedList?
     * But the next character can be chosen from a list of characters. "Mutil-LinkedList"?
     * Combing them, Trie is the natural choice. Notice that:
     *
     * TrieNode is all we need. search and startsWith are useless.
     * No need to store character at TrieNode. c.next[i] != null is enough.
     * Never use c1 + c2 + c3. Use StringBuilder.
     * No need to use O(n^2) extra space visited[m][n].
     * No need to use StringBuilder. Storing word itself at leaf node is enough.
     * No need to use HashSet to de-duplicate. Use "one time search" trie.
     * For more explanations, check out dietpepsi's blog.
     *
     * Code Optimization
     * UPDATE: Thanks to @dietpepsi we further improved from 17ms to 15ms.
     *
     * 59ms: Use search and startsWith in Trie class like this popular solution.
     * 33ms: Remove Trie class which unnecessarily starts from root in every dfs call.
     * 30ms: Use w.toCharArray() instead of w.charAt(i).
     * 22ms: Use StringBuilder instead of c1 + c2 + c3.
     * 20ms: Remove StringBuilder completely by storing word instead of boolean in TrieNode.
     * 20ms: Remove visited[m][n] completely by modifying board[i][j] = '#' directly.
     * 18ms: check validity, e.g., if(i > 0) dfs(...), before going to the next dfs.
     * 17ms: De-duplicate c - a with one variable i.
     * 15ms: Remove HashSet completely. dietpepsi's idea is awesome.
     * The final run time is 15ms. Hope it helps!
     */
    public List<String> findWords_voted(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words); // 优化点：把words数组放到Trie里，可以一起判断，不用每个word单独判断
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}
