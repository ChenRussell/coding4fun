package com.nowcoder.testClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ChenRui on 18-4-17
 */
public class IteratorTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        // 使用iterator遍历时，删除元素不会抛异常
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (next.equals("e")) {
                iterator.remove();
            }
            else System.out.println(next);
        }

        System.out.println("size: "+list.size());
        System.out.println("**************");

        /*
          当遍历到倒数第二个元素并删除该元素时将使列表的size-1并等于cursor，
          此时hasNext()返回false所以不再调用next()方法调用checkForComodification()进行修改验证。
         */
        for (String s : list) {
            if (s.equals("e")) list.remove(s);
            else System.out.println(s);
        }
    }
}
