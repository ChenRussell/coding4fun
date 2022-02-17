package org.cr.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/02/17
 */
public class LRUCache20220217 {

    class Entry {
        int key; // pay attention
        int val;
        Entry pre;
        Entry next;

        public Entry(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }

    int capacity;
    Map<Integer, Entry> map;
    Entry head, tail;

    public LRUCache20220217(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        Entry entry = map.get(key);
        if(entry != null) {
            moveToFirst(entry);
        } else {
            return -1;
        }
        return entry.val;
    }

    public void put(int key, int value) {
        Entry entry = map.get(key);
        if(entry != null) {
            entry.val = value;
            moveToFirst(entry); // pay attention
        } else {
            if(map.size() >= this.capacity) {
                removeEldestEntry();
            }
            Entry newEntry = new Entry(key,value);
            addEntry(newEntry);
            map.put(key, newEntry); // pay attention
        }
    }

    public void moveToFirst(Entry entry) {
        if(head == entry) return;
        if(entry != tail) {
            Entry pre = entry.pre;
            Entry next = entry.next;
            pre.next = next;
            next.pre = pre;
        } else {
            Entry pre = entry.pre;
            pre.next = null;
            tail = pre;
        }
        addEntry(entry);
    }

    public void addEntry(Entry entry) {
        if (head == null) {
            head = entry;
            tail = entry;
            //entry.next = null;
            //entry.pre = null;
        } else {
            entry.next = head;
            head.pre = entry;
            head = entry;
            head.pre = null; // pay attention
        }
    }

    public void removeEldestEntry() {
        map.remove(tail.key); // pay attention
        Entry pre = tail.pre;
        tail.pre = null; // pay attention
        if (pre == null) {
            tail = null;
            head = null;
        } else {
            pre.next = null;
            tail = pre;
        }
    }
}
