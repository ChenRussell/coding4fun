package com.nowcoder.campusExam.beike.beike_second;

import java.util.*;

public class Two2 {
    /**
     * ¶àÃ×Åµ¹ÇÅÆ
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int n = Integer.parseInt(sca.nextLine());
        Map<Integer, Integer> map = new TreeMap<>();
        int[] location = new int[n];
        for (int i = 0; i < n; i++) {
            int key = sca.nextInt();
            int value = sca.nextInt();
            int item = key;
            location[i] = item;
            map.put(item, value);
        }
        int index = 0;
        for (int item : location) {
            int left = item;
            int right = item + map.get(item) - 1;
            location[index] = 0;
            Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                Integer key = next.getKey();
                if (key >= left && key <= right) {
                    location[index]++;
                    int comp = key + next.getValue() - 1;
                    right = right > comp ? right : comp;
                }
            }
            System.out.print(location[index] + " ");
            index++;
        }
    }
}