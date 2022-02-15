package org.cr.leetcode.slidingwindow;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/15
 *
 * ������� K ����ͬ�ַ�����Ӵ�
 */
public class _340LongestSubstringwithAtMostKDistinctCharacters {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0; // counter��ʾ��ͬ�ַ��ĸ���

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > k) {
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
