package org.cr.testClass.innerclass;

/**
 * ��̬�ڲ���
 */
public class StaticInnerClass {
    int a = 10;
    static int b = 5;

    static class Inner {
        public Inner() {
//            System.out.println(a);    ����ʹ���ⲿ��ķ�static��Ա�����򷽷�
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        new StaticInnerClass.Inner();
    }
}
