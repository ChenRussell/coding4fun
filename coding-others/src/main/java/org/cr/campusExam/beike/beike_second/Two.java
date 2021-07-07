package org.cr.campusExam.beike.beike_second;

/**
 * ��Ŀ������
 * ����ŵ���ƴ����ض���İ����������n�����ŵ���Ʒ���x���ϣ�ÿһ�������һ������λ���±�͸߶ȣ�
 * ÿһ����ƶ�ֻ����x���������£�������λ��x0���߶�Ϊh0�Ķ���ŵ���Ƶ��£�
 * ��ѹ��[x?+?1,?x?+?h?-?1]�ڵ����ж���ŵ���ƣ�����ÿһ����ơ�����ϣ��֪����
 * ����Ұ��������Ƶ�����ô������Ե��¶��ٿ���ơ�
 * <p>
 * ����
 * �����һ�а���һ��������n����ʾ����ŵ���Ƶ�����(1<=n<=10^5)
 * <p>
 * ������n�У�ÿ�а�������������x,h���ֱ��ʾ��i�����ŵ���Ƶ�λ�ú͸߶�(-10^8<=x<=10^8,2<=h<=10^8)����֤���������������ͬһ�߶ȡ�
 * <p>
 * ���
 * ����ÿ���������ݣ����һ�У� ����n������������i�����ֱ�ʾ������Ƶ���i�����ŵ���ƣ�����ʹ�ö��ٸ����Ƶ��¡�
 * <p>
 * <p>
 * ��������
 * 4
 * 16 5
 * 20 5
 * 10 10
 * 18 2
 * �������
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
                long max = findMax(map, entry); // ���ҵ�ǰ����ѹ���������
                if (integer >= entry.getKey() && integer <= max) {  // ���ڵ�ǰ����ѹ���ķ�Χ�ڵ���
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
