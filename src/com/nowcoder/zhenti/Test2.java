package com.nowcoder.zhenti;

class Value {
    public int i = 15;
}

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();
        test2.first();
    }

    public void first() {
        int i = 5;
        Value value = new Value();
        value.i = 25;
        second(value, i);
        System.out.println(value.i);
    }

    public void second(Value v, int i) {
        i = 0;
        v.i = 20;
        Value value = new Value();
        v = value;
        System.out.println(v.i + " " + i);

    }
}
