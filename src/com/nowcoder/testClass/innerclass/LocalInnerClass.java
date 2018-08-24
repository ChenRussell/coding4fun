package com.nowcoder.testClass.innerclass;

/**
 * 局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问权限仅限于方法内或者该
 * 作用域内
 */
public class LocalInnerClass {

    class People {
    }

    class Man {

    }
    public People getInnerClass() {
        int a = 3;
        class Woman extends People {        // 局部内部类
            int age = 0;
            int b = a;
        }
        return new Woman();
    }
}
