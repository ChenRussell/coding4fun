package org.cr.campusExam.netease;

/**
 * Created by ChenRui on 2018/9/8
 */
public class T2 {

    private int i;

    private int increase() {
        try {
            return ++i;
        } catch (Exception e) {
            i = 5;
            return i++;
        }
        finally {
            i = 10;
        }
    }

    public static void main(String[] args) {
//        List objects = new ArrayList<>();
//        objects.add(1L);
//        objects.add(2L);
//        objects.add(3L);
//
//        for (Long object : objects) {
//
//        }
        T2 t2 = new T2();
        System.out.println(t2.increase());
    }
}
