package org.cr.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/19
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */
public class _17LetterCombinationsofaPhoneNumber {

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        String[] arr = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        queue.add("");
        while (digits.length() != queue.peek().length()) {
            String poll = queue.remove();
            // key point: 取第几个数字对应的字母取决于队列中poll出来的元素length
            String letters = arr[digits.charAt(poll.length()) - '0'];
            for (int i = 0; i < letters.length(); i++) {
                queue.add(poll + letters.charAt(i));
            }
        }
        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        _17LetterCombinationsofaPhoneNumber obj = new _17LetterCombinationsofaPhoneNumber();
        System.out.println(obj.letterCombinations("23"));
    }
}
