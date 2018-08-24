package com.nowcoder.jvm;

import com.nowcoder.TestDemo;

import java.util.ArrayList;

/**
 * created by chenrui18,2018/8/23 at 14:38
 */
public class TestHeapSpace {

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            ArrayList<Object> list = new ArrayList<>();
            list.add(new TestDemo());
//            Thread.sleep(200);
        }

    }
}
