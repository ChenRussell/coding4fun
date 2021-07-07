package org.cr.testClass.runTimeTypeIdentification;

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
            // Ҫ���ϰ�������ִ������һ�����
            Class c = Class.forName("org.cr.testClass.runTimeTypeIdentification.Base2");
            constructors = c.getConstructors(); // ���й��췽��
            methods = c.getMethods();   // ���з���
            fields = c.getFields();     // �����ֶ�
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Base2���еĹ��еĹ��췽��: ");
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
        }
        System.out.println("Base���еĹ��з���(��Щ�Ǵ�Object�̳е�):");
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i].getName());
        }
        System.out.println("Base���еĹ����ֶ�:");
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }

    }

    @Test
    public void testInvoke() {
        try {
            Class c2 = Class.forName("org.cr.testClass.runTimeTypeIdentification.Base2");
            Method func = c2.getMethod("func");
            Object instance = c2.newInstance();
            func.invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
