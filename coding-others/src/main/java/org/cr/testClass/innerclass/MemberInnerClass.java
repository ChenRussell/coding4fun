package org.cr.testClass.innerclass;

/**
 * ��Ա�ڲ���
 * ��Ա�ڲ�������������ķ����ⲿ������г�Ա���Ժͳ�Ա����
 */
public class MemberInnerClass {
    private double radius = 0;
    public static int count = 1;

    class Draw {
        public void drawShape() {
            System.out.println(radius);
            System.out.println(count);
        }
    }


    public static void main(String[] args) {
        // ��һ�ַ�ʽ
        Outter outter = new Outter();
        Outter.Inner inner = outter.new Inner();

        // �ڶ��ַ�ʽ
        Outter.Inner innerInstance = outter.getInnerInstance();

    }
}

class Outter {
    private Inner inner = null;

    public Inner getInnerInstance() {
        if (inner == null) {
            inner = new Inner();
        }
        return inner;
    }


    class Inner {

    }
}
