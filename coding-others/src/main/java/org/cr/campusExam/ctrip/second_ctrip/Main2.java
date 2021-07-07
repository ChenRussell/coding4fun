package org.cr.campusExam.ctrip.second_ctrip;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

    class Entry {
        Entry pre;
        Entry next;
        Integer key;
        Integer value;
    }

    public Entry first;
    public Entry last;

    private int CACHED_SIZE;
    private HashMap<Integer, Entry> cached = new HashMap<>();

    public Main2(int CACHED_SIZE) {
        this.CACHED_SIZE = CACHED_SIZE;
    }

    public void put(Integer key, Integer value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            if (cached.size() >= CACHED_SIZE) {
                cached.remove(last.key);
                removeLast();
            }
            entry = new Entry();
            entry.key = key;
            entry.value = value;
            moveToFirst(entry);
        }
        entry.value = value;

        cached.put(key, entry);
    }

    public int get(Integer key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            moveToFirst(entry);
        }
        if (entry == null) return -1;
        return entry.value;
    }

    public void moveToFirst(Entry entry) {
        if (first == entry) return;
        // 摘下节点
        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;

        if (first == null) {
            first = entry;
            last = entry;   // 维护last指针
//            last.next =null;
            return;
        }

        //  当移动的元素为最后一个的时候，需要维护last指针
        if (entry == last) {
            last = last.pre;
            last.next = null;
        }
        entry.next = first;
        first.pre = entry;
        first = entry;
    }

    public void removeLast() {
        if (last == null) return;
        if (last.pre != null) {
            last = last.pre;  // 大于一个元素
            last.next = null;
        }
        if (first == last) {    // 一个元素
            first = null;
            last = null;
        }
    }

    public Entry getEntry(Integer key) {
        return cached.get(key);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        Main2 obj = new Main2(cacheSize);
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
