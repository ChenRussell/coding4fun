package com.nowcoder.testClass.runTimeTypeIdentification;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        Constructor[] constructors = null;
        Method[] methods = null;
        Field[] fields = null;
        try {
            // 要加上包名才能执行下面一条语句
            Class c = Class.forName("com.nowcoder.testClass.runTimeTypeIdentification.Base2");
            constructors = c.getConstructors(); // 公有构造方法
            methods = c.getMethods();   // 公有方法
            fields = c.getFields();     // 公有字段
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Base2含有的公有的构造方法: ");
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
        }
        System.out.println("Base含有的公有方法(有些是从Object继承的):");
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
        System.out.println("Base含有的公有字段:");
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }

    }

    @Test
    public void testInvoke() {
        try {
            Class c2 = Class.forName("com.nowcoder.testClass.runTimeTypeIdentification.Base2");
            Method func = c2.getMethod("func");
            Object instance = c2.newInstance();
            func.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
