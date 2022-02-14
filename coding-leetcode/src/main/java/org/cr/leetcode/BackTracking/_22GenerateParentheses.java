package org.cr.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/09/26
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * Example 2:
 *
 * Input: n = 1
 * Output: ["()"]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 8
 */
public class _22GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append("(").append(")");
        }
        List<Character> tempList = new ArrayList<>();
        boolean[] used = new boolean[sb.length()];
        char[] chars = sb.toString().toCharArray();
        Arrays.sort(chars);
        permutation(res, tempList, chars, used);
        return res;
    }

    private void permutation(List<String> res, List<Character> tempList, char[] arr, boolean[] used) {
        if (tempList.size() == arr.length && isValid(tempList)) {
            res.add(toStr(tempList));
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (used[i] || (i > 0 && arr[i] == arr[i-1] && !used[i-1])) continue;
                tempList.add(arr[i]);
                used[i] = true;
                permutation(res, tempList, arr, used);
                used[i] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    private boolean isValid(List<Character> tempList) {
        Stack<Character> stack = new Stack<>();
        for (Character c : tempList) {
            if (c == '(') stack.push(')');
            else if (c == ')' && !stack.isEmpty()) {
                stack.pop();
            }
            else if (c == ')') {
                return false;
            }
        }
        return stack.isEmpty();
    }

    private String toStr(List<Character> tempList) {
        StringBuilder sb = new StringBuilder();
        for (Character character : tempList) {
            sb.append(character);
        }
        return sb.toString();
    }
}
