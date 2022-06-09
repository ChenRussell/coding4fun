package org.cr.leetcode;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/02/16
 *
 * Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetcode"
 * Output: 0
 * Example 2:
 *
 * Input: s = "loveleetcode"
 * Output: 2
 * Example 3:
 *
 * Input: s = "aabb"
 * Output: -1
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * s consists of only lowercase English letters.
 */
public class _387FirstUniqueCharacterInaString {

    public int firstUniqChar(String s) {
        int[] hashTable = new int[26];
        for(int i=0; i < s.length(); i++) {
            hashTable[s.charAt(i)-'a']++;
        }
        for(int i=0; i < s.length(); i++) {
            if(hashTable[s.charAt(i)-'a'] == 1) return i;
        }
        return -1;
    }
}
