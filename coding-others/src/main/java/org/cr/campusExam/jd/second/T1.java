package org.cr.campusExam.jd.second;

/**
 * Created by ChenRui on 2018/9/9
 */
public class T1 {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = systemClassLoader.loadClass("org.cr.campusExam.jd.second.A");
        System.out.println("Test");
        clazz.forName("org.cr.campusExam.jd.second.A");
    }
}
class A {
    static {
        System.out.println("A");
    }
}
