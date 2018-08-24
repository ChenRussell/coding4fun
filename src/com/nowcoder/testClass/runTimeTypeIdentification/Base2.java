package com.nowcoder.testClass.runTimeTypeIdentification;

public class Base2 {

    private static int number = 1;
    public int otherNum = 100;

    public Base2() {
    }

    public Base2(int number) {
        this.number = number;
    }

    public void func() {
        System.out.println("之前的值为: " + number);
        number++;
        System.out.println("调用反射方法: " + number);
    }

    public void otherFunc() {
        otherNum--;
    }
}
