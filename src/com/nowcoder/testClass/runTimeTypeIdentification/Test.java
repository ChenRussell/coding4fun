package com.nowcoder.testClass.runTimeTypeIdentification;

class Base {

}

class Subclass extends Base {

}

public class Test {
    static void test(Object x) {
        System.out.println("Testing x of type: " + x.getClass());
        System.out.println("x instanceof Base:" + (x instanceof Base));
        System.out.println("x instanceof Subclass: " + (x instanceof Subclass));
        System.out.println("Base.isInstance(x): " + (Base.class.isInstance(x)));
        System.out.println("Subclass.isInstance(x): " + (Subclass.class.isInstance(x)));
        System.out.println("x.getClass() == Base.class: " + (x.getClass() == Base.class));
        System.out.println("x.getClass() == Subclass.class: " + (x.getClass() == Subclass.class));
        System.out.println("x.getClass().equals(Base.class): " + (x.getClass().equals(Base.class)));
        System.out.println("x.getClass().equals(Subclass.class): " + (x.getClass().equals(Subclass.class)));
    }

    public static void main(String[] args) {
        test(new Base());
        System.out.println("---------------------------------------");
        test(new Subclass());
    }
}

