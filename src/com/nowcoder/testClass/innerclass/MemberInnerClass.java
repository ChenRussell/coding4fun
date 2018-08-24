package com.nowcoder.testClass.innerclass;

/**
 * 成员内部类
 * 成员内部类可以无条件的访问外部类的所有成员属性和成员方法
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
        // 第一种方式
        Outter outter = new Outter();
        Outter.Inner inner = outter.new Inner();

        // 第二种方式
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
