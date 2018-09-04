package com.nowcoder.campusExam.beike.beike_second;

/**
 * 题目描述：
 * 多米诺骨牌大家想必都不陌生，现在有n块多米诺骨牌放在x轴上，每一块骨牌有一个所在位置下标和高度，
 * 每一块骨牌都只会向x轴正方向倒下，当处于位置x0，高度为h0的多米诺骨牌倒下，
 * 会压倒[x?+?1,?x?+?h?-?1]内的所有多米诺骨牌，对于每一块骨牌。我们希望知道，
 * 如果我把这块骨牌推倒，那么至多可以倒下多少块骨牌。
 * <p>
 * 输入
 * 输入第一行包含一个正整数n，表示多米诺骨牌的数量(1<=n<=10^5)
 * <p>
 * 接下来n行，每行包含两个正整数x,h，分别表示第i块多米诺骨牌的位置和高度(-10^8<=x<=10^8,2<=h<=10^8)。保证不会有两块骨牌在同一高度。
 * <p>
 * 输出
 * 对于每个测试数据，输出一行， 包含n个正整数，第i个数字表示，如果推倒第i块多米诺骨牌，可以使得多少个骨牌倒下。
 * <p>
 * <p>
 * 样例输入
 * 4
 * 16 5
 * 20 5
 * 10 10
 * 18 2
 * 样例输出
 * 3 1 4 1
 */

import java.util.*;

public class Two {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> list = new ArrayList<>();
        Map<Long, Long> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            long key = sc.nextInt();
            long value = sc.nextInt();
            list.add(key);
            map.put(key, value);
        }

//        int[] res = new int[n];
        ArrayList<Integer> res = new ArrayList<>();

        Set<Map.Entry<Long, Long>> entries = map.entrySet();
        for (Map.Entry<Long, Long> entry : entries) {
            int sum = 0;
            for (Long integer : list) {
                long max = findMax(map, entry); // 查找当前牌能压倒的最大数
                if (integer >= entry.getKey() && integer <= max) {  // 找在当前牌能压倒的范围内的数
                    sum++;
                }
            }
            res.add(sum);
        }
//        System.out.println(res);
        for (Integer re : res) {
            System.out.print(re + " ");
        }
    }

    private static long findMax(Map<Long, Long> map, Map.Entry<Long, Long> entry) {
        Set<Map.Entry<Long, Long>> entries = map.entrySet();
        long max = entry.getKey() + entry.getValue() - 1;
        for (Map.Entry<Long, Long> item : entries) {
            if (item.getKey() == entry.getKey()) continue;
            if ((item.getKey() >= entry.getKey()) && (item.getKey() <= (entry.getKey() + entry.getValue() - 1)))
                max = Math.max(max, item.getKey() + item.getValue() - 1);
        }
        return max;
    }

}
