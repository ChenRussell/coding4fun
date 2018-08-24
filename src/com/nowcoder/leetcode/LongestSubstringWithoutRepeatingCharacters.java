package com.nowcoder.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ChenRui on 18-3-4
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    String str;

    /**
     * TIME LIMITED EXCEEDED, FUCK
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int max = 0;
        StringBuffer subStr = new StringBuffer("");
        if (chars.length == 0) return 0;
        if (chars.length == 1) return 1;
        subStr.append(chars[0]);
        for (int i = 0; i < chars.length-1; i++) {
//            subStr.append(chars[i]);
            if (!subStr.toString().contains(String.valueOf(chars[i+1]))) {
                subStr.append(chars[i+1]);
            } else {
//                subStr = new StringBuffer(String.valueOf(chars[i+1]));
//                int index = s.lastIndexOf(String.valueOf(chars[i + 1]));
                int index = s.substring(0,i+1).lastIndexOf(chars[i+1]); // 找最后出现的索引
                //System.out.println(index);
                subStr = new StringBuffer(s.substring(index+1,i+2));
//                System.out.println(subStr.toString());
            }
            if (subStr.length()>max) {
                max = subStr.length();
                str = subStr.toString();

            }
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters a = new LongestSubstringWithoutRepeatingCharacters();

        int b = a.lengthOfLongestSubstring("abbcd");
        System.out.println(b);
        System.out.println(a.str);
    }
}
