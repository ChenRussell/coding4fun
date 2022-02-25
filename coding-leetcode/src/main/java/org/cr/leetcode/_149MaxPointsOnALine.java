package org.cr.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/25
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[2,2],[3,3]]
 * Output: 3
 * Example 2:
 *
 *
 * Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -104 <= xi, yi <= 104
 * All the points are unique.
 */
public class _149MaxPointsOnALine {

    /**
     * �� delta x �� delta y �����Լ���������eg: (2,1), (4,2), (8,4)����Ȼ������������Ϊkey������б�ʣ�����������һ����
     * ֱ�ӽ�б����Ϊkey�������⣬�����������⣿
     */
    public int maxPoints(int[][] points) {
        int res = 0;
        Map<String, Integer> map = new HashMap<>();
        //Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            int max = 0;
            map.clear();
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                String key = getKey(x, y);
                int val = map.getOrDefault(key, 0) + 1;
                map.put(key, val);
                max = Math.max(max, val);
            }
            res = Math.max(res, max + 1); // +1��ʾ���Լ���������
        }
        return res;
    }

    // �����Լ��greatest common divisor(gcd)
    private int getGCD(int a, int b) {
        while (b != 0) {
            int r = a;
            a = b;
            b = r % b;
        }
        return a;
    }

    // Ҳ��ʹ��(long) x << 32 ^ y;�ķ�ʽ��Ϊkey
    private String getKey(int x, int y) {
        int c = getGCD(x, y);
        x = x / c;
        y = y / c;
        return x + "," + y;
    }
}
