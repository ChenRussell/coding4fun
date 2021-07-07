package org.cr.campusExam.ctrip.second_ctrip;

import java.util.HashMap;
import java.util.Scanner;

public class Main22 {

    private final int MAX_CACHE_SIZE;
    private Entry first;
    private Entry last;

    private HashMap<Integer, Entry> hashMap;

    public Main22(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;
        hashMap = new HashMap<Integer, Entry>();
    }

    public void put(Integer key, Integer value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            if (hashMap.size() >= MAX_CACHE_SIZE) {
                hashMap.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
            entry.value = value;
            moveToFirst(entry);
        }
        entry.value = value;
        hashMap.put(key, entry);
    }

    public int get(Integer key) {
        Entry entry = getEntry(key);
        if (entry == null) return -1;
        moveToFirst(entry);
        return entry.value;
    }


    private void moveToFirst(Entry entry) {
        if (entry == first) return;
        // 先把节点摘下来
        if (entry.pre != null) entry.pre.next = entry.next; //  前一个节点指向后一个节点
        if (entry.next != null) entry.next.pre = entry.pre; //  后一个节点指向前一个节点
        if (entry == last) last = last.pre;

        if (first == null || last == null) {
            first = last = entry;
            return;
        }

        entry.next = first;
        first.pre = entry;
        first = entry;
        entry.pre = null;
    }

    private void removeLast() {
        if (last != null) {
            last = last.pre;
            if (last == null) first = null;     // 只有一个元素的时候
            else last.next = null;
        }
    }


    private Entry getEntry(Integer key) {
        return hashMap.get(key);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry entry = first;
        while (entry != null) {
            sb.append(String.format("%s:%s ", entry.key, entry.value));
            entry = entry.next;
        }
        return sb.toString();
    }

    class Entry {
        public Entry pre;
        public Entry next;
        public Integer key;
        public Integer value;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        Main22 obj = new Main22(cacheSize);
        sc.nextLine();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            String action = split[0];
            Integer p1 = Integer.valueOf(split[1]);
            Integer p2 = 0;
            if (split.length == 3) {
                p2 = Integer.valueOf(split[2]);
            }
            if (action.equals("p")) {
                obj.put(p1, p2);
            }
            if (action.equals("g")) {
                System.out.println(obj.get(p1));
            }
        }
    }
}
