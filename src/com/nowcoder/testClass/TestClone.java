package com.nowcoder.testClass;

/**
 * created by chenrui18,2018/8/12 at 17:00
 */
public class TestClone implements Cloneable {

    int x;
    int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TestClone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void print() {
        System.out.println(x+","+y);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        TestClone obj1 = new TestClone(1, 2);
        TestClone obj2 = (TestClone) obj1.clone();
        obj2.setX(5);
        obj2.setY(7);
        System.out.println(obj1 == obj2);
        obj1.print();
        obj2.print();
    }
}
