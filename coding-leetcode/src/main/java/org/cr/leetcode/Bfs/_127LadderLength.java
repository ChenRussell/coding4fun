package org.cr.leetcode.Bfs;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ChenRui on 18-4-2
 */
public class _127LadderLength {

    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // ��beginSetԪ�ظ�������endSet��ʱ�򣬽�������˼���ý���Ԫ�ص��Ǹ��������Ż���ʱ�临�Ӷȣ�Ȼ�����ǹ�����
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

                        if (!visited.contains(target) && wordList.contains(target)) {
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
        HashSet<String > set = new HashSet<>();
        set.add("a");
        set.add("c");
        set.add("b");
        int res = new _127LadderLength().ladderLength("hit", "tih", set);
        System.out.println(res);
    }
}
