package org.cr.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/04/21
 *
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 *
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
 *
 * Return intervals after the insertion.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:
 *
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 *
 * Constraints:
 *
 * 0 <= intervals.length <= 104
 * intervals[i].length == 2
 * 0 <= starti <= endi <= 105
 * intervals is sorted by starti in ascending order.
 * newInterval.length == 2
 * 0 <= start <= end <= 105
 */
public class _57InsertInterval {

    // 与_56MergeIntervals类似，不需要再整体排序
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int start = newInterval[0], end = newInterval[1];
        for(int i = 0; i < intervals.length;i++) {
            if(intervals[i][0] > end) {
                res.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            } else if (intervals[i][1] < start) {
                res.add(intervals[i]);
            } else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }
        res.add(new int[] {start, end});
        return res.toArray(new int[res.size()][2]);
    }
}
