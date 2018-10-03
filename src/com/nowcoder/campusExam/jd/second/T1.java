package com.nowcoder.campusExam.jd.second;

/**
 * Created by ChenRui on 2018/9/9
 */
public class T1 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = systemClassLoader.loadClass("com.nowcoder.campusExam.jd.second.A");
        System.out.println("Test");
        clazz.forName("com.nowcoder.campusExam.jd.second.A");
    }
}
class A {
    static {
        System.out.println("A");
    }
}
