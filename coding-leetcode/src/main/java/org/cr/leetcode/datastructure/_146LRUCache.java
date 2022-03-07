package org.cr.leetcode.datastructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2021/08/18
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation,
 * evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 *
 *
 * Example 1:
 *
 * Input
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * Output
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * Explanation
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // cache is {1=1}
 * lRUCache.put(2, 2); // cache is {1=1, 2=2}
 * lRUCache.get(1);    // return 1
 * lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
 * lRUCache.get(2);    // returns -1 (not found)
 * lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
 * lRUCache.get(1);    // return -1 (not found)
 * lRUCache.get(3);    // return 3
 * lRUCache.get(4);    // return 4
 *
 *
 * Constraints:
 *
 * 1 <= capacity <= 3000
 * 0 <= key <= 104
 * 0 <= value <= 105
 * At most 2 * 105 calls will be made to get and put.
 */
public class _146LRUCache {
    class Entry {
        int key;
        int val;
        Entry pre;
        Entry next;

        public Entry(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public Map<Integer, Entry> map;
    public final int capacity;

    private Entry head, tail;

    public _146LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        int res;
        Entry entry = map.get(key);
        if (entry != null) {
            res = entry.val;
            moveToFirst(entry);
        } else {
            return  -1;
        }
        return res;
    }

    public void put(int key, int value) {
        Entry entry = map.get(key);
        if (entry != null) {
            entry.val = value;
            moveToFirst(entry);
        } else {
            entry = new Entry(key, value);
            if (map.size() >= capacity) {
                removeEldestEntry();
            }
            addEntry(entry);
            map.put(key, entry);
        }
    }

    // add entry to head
    private void addEntry(Entry entry) {
        if (head != null) {
            head.pre = entry;
            entry.next = head;
            head = entry;
            head.pre = null;
        } else {
            entry.next = null;
            entry.pre = null;
            head = entry;
            tail = entry;
        }
    }

    private void removeEldestEntry() {
        map.remove(tail.key);
        Entry preTail = tail.pre;
        tail.pre = null;
        if (preTail != null) {
            preTail.next = null;
        } else {
            head = null;
        }
        tail = preTail;
    }


    private void moveToFirst(Entry entry) {
        if (entry == head) return;
        // remove the entry
        Entry pre = entry.pre;
        Entry next = entry.next;
        pre.next = next;
        if (next != null) {
            next.pre = pre;
        } else {
            tail = pre;
        }
        addEntry(entry);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Entry entry = head;
        while (entry != null) {
            sb.append(String.format("%s:%s,", entry.key, entry.val));
            entry = entry.next;
        }
        return sb.toString();
    }

    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    public static void main(String[] args) {
        _146LRUCache lruCache = new _146LRUCache(2);
//        System.out.println(lruCache.get(1));
//        lruCache.put(1, 1);
//        lruCache.put(2, 2);
//        System.out.println(lruCache.get(1));
//        lruCache.put(3, 3);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4, 4);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));

        lruCache.put(1, 0);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache);
        lruCache.put(3,3);
        System.out.println(lruCache);

        System.out.println(lruCache.get(2));
        lruCache.put(4,4);
        System.out.println(lruCache);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
