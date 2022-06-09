package org.cr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author russ
 * @project coding4fun
 * @date 2021/08/27
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 *
 *
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 */
public class _118PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {
                res.add(Collections.singletonList(1));
            } else if (i == 1) {
                res.add(Arrays.asList(1, 1));
            } else {
                List<Integer> preRow = res.get(i - 1);
                List<Integer> row = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    if (j == 0) row.add(1);
                    else if (j == i) {
                        row.add(1);
                    } else {
                        row.add(preRow.get(j - 1) + preRow.get(j));
                    }
                }
                res.add(row);
            }
        }
        return res;
    }
}
