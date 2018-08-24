package com.nowcoder.leetcode;

import java.util.HashMap;

/**
 * Created by ChenRui on 18-4-8
 *
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 *
 * Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * Note:
 *
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].
 */
public class _792NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, 0);
        }
        System.out.println(map.size());

        for (String word : words) {

            if (map.get(word)!=0) {
                count++;
                continue;
            }

            int pt = 0;
            int ps = 0;
            if(word.length() == 0) {
                count++;
                continue;
            }
            while (ps < S.length()) {
                if (word.charAt(pt) == S.charAt(ps)) {
                    pt++;
                    if (pt == word.length()) {
                        map.put(word,1);
                        count++;
                        break;
                    }
                }
                ps++;
            }// while
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "abcde";
        String words[] = {"a","a","a", "bb", "acd", "ace"};
        int res = new _792NumberOfMatchingSubsequences().numMatchingSubseq(s, words);
        System.out.println(res);
    }
}
