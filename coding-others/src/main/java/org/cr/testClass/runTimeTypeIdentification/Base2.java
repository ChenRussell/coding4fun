package org.cr.testClass.runTimeTypeIdentification;

public class Base2 {

    private static int number = 1;
    public int otherNum = 100;

    public Base2() {
    }

    public Base2(int number) {
        this.number = number;
    }

    public void func() {
        System.out.println("֮ǰ��ֵΪ: " + number);
        number++;
        System.out.println("���÷��䷽��: " + number);
    }

    public void otherFunc() {
        otherNum--;
    }
}
