package org.cr.leetcode.bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
 *
 * Every adjacent pair of words differs by a single letter.
 * Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
 * sk == endWord
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
 *
 *
 *
 * Example 1:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 * Output: 5
 * Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 * Example 2:
 *
 * Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
 * Output: 0
 * Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 *
 *
 * Constraints:
 *
 * 1 <= beginWord.length <= 10
 * endWord.length == beginWord.length
 * 1 <= wordList.length <= 5000
 * wordList[i].length == beginWord.length
 * beginWord, endWord, and wordList[i] consist of lowercase English letters.
 * beginWord != endWord
 * All the words in wordList are unique.
 */
public class _127LadderLength {

    /**
     * "The idea behind bidirectional search is to run two simultaneous searches—one forward from
     * the initial state and the other backward from the goal—hoping that the two searches meet in
     * the middle. The motivation is that b^(d/2) + b^(d/2) is much less than b^d. b is branch factor, d is depth. "
     *
     * ----- section 3.4.6 in Artificial Intelligence - A modern approach by Stuart Russel and Peter Norvig
     *
     * 1. It's much faster than one-end search indeed as explained in wiki.
     * 2. BFS isn't equivalent to Queue. Sometimes Set is more accurate representation for nodes of level. (also handy since we need to check if we meet from two ends)
     * 3. It's safe to share a visited set for both ends since if they meet same string it terminates early. (vis is useful since we cannot remove word from dict due to bidirectional search)
     * 4. It seems like if(set.add()) is a little slower than if(!contains()) then add() but it's more concise.
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;  // 如果endWord不包含在内，return 0
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();
        int len = 1;
        HashSet<String> visited = new HashSet<String>();
        Set<String> dict = new HashSet<>(wordList); // 将wordList转化为set，优化contains的时间复杂度
        beginSet.add(beginWord);
        endSet.add(endWord);

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 当beginSet元素个数多于endSet的时候，交换，意思是用较少元素的那个搜索，优化了时间复杂度
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            Set<String> temp = new HashSet<String>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }

        return 0;
    }

    public static void main(String[] args) {
        List<String > set = new ArrayList<>();
        set.add("a");
        set.add("c");
        set.add("b");
        int res = new _127LadderLength().ladderLength("hit", "tih", set);
        System.out.println(res);
    }
}
