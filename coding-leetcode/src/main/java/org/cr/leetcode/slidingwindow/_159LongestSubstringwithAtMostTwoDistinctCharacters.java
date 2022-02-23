package org.cr.leetcode.slidingwindow;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/15
 *
 * �������������ͬ�ַ�����Ӵ�
 */
public class _159LongestSubstringwithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0; // counter��ʾ��ǰ�����ڲ�ͬ�ַ��ĸ���

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > 2) {
                final char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }
}
