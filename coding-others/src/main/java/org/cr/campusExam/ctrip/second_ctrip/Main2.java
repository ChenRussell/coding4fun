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
        // ժ�½ڵ�
        if (entry.pre != null) entry.pre.next = entry.next;
        if (entry.next != null) entry.next.pre = entry.pre;

        if (first == null) {
            first = entry;
            last = entry;   // ά��lastָ��
//            last.next =null;
            return;
        }

        //  ���ƶ���Ԫ��Ϊ���һ����ʱ����Ҫά��lastָ��
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
            last = last.pre;  // ����һ��Ԫ��
            last.next = null;
        }
        if (first == last) {    // һ��Ԫ��
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
