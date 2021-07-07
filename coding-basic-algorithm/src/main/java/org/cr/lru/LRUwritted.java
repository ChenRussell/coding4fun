package org.cr.lru;

import java.util.HashMap;

/**
 * created by chenrui18,2018/8/16 at 17:30
 */
public class LRUwritted<K, V> {

    class Entry<K2, V2> {
        Entry pre;
        Entry next;
        K2 key;
        V2 value;
    }

    public Entry first;
    public Entry last;

    private static int CACHED_SIZE;
    private HashMap<K, Entry<K, V>> cached = new HashMap<>();

    public LRUwritted(int cachedSize) {
        CACHED_SIZE = cachedSize;
    }

    public void put(K key, V value) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) {
            if (cached.size() >= CACHED_SIZE) {
                cached.remove(last.key);
                removeLast();
            }
            entry = new Entry<>();
            entry.key = key;
        }
        entry.value = value;
        moveToFirst(entry);
        cached.put(key, entry);
    }

    public Entry get(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry != null) {
            moveToFirst(entry);
        }
        return entry;
    }

    public void remove(K key) {
        Entry<K, V> entry = getEntry(key);
        if (entry == null) return;
        if (entry == first) {
            first = first.next;
            first.pre = null;
            return;
        }
        if (entry == last) {
            last = entry.pre;
            last.next = null;
            return;
        }
        entry.pre.next = entry.next;
        entry.next.pre = entry.pre;
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
        if (entry == last){
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

    public Entry<K, V> getEntry(K key) {
        return cached.get(key);
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

    public static void print(LRUwritted lru) {
        System.out.println(lru);
    }

    public static void main(String[] args) {
        LRUwritted<Integer, String> lru = new LRUwritted<>(3);
        lru.put(1, "a");
        print(lru);
        System.out.println("first:"+lru.first.key+", last:"+lru.last.key);
        lru.put(2, "b");
        print(lru);
        System.out.println("first:"+lru.first.key+", last:"+lru.last.key);
        lru.put(4, "c");
        print(lru);
        System.out.println("first:"+lru.first.key+", last:"+lru.last.key);
        lru.put(3, "d");
        print(lru);
        System.out.println("first:"+lru.first.key+", last:"+lru.last.key);
//        System.out.println(lru.cached.size());
        lru.get(2);
        print(lru);
        System.out.println("first:"+lru.first.key+", last:"+lru.last.key);
        lru.get(3);
        print(lru);
        System.out.println("first:"+lru.first.key+", last:"+lru.last.key);
        lru.remove(2);
        print(lru);
        lru.remove(4);
        print(lru);
    }
}
