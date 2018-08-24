package com.nowcoder.testClass;

import java.util.HashMap;

/**
 * Created by ChenRui on 18-4-9
 */
public class TestHashMap {

    @Override
    public boolean equals(Object obj) {
        return true;
    }

    public boolean equals(String obj) {
        return false;
    }



    @Override
    public int hashCode() {
        return 32;
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("fr", 3);
        map.put("asfd", 4);
        System.out.println(map.size());
    }
}
