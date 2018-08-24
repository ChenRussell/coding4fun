package com.nowcoder.testClass;

public class TestClass extends AbstractSuperClass implements InterfaceSuperClass {

//	public static void main(String[] args) {
//		
//		SubClass sc = new SubClass();
//		System.out.println(sc.a);
//		sc.getSuperInfo();
//		sc.printInfo();
//	}
//	public final String finalString;

    private static void testMethod() {
        System.out.println("test");
    }

    public static void main(String args[]) {
        String s;
//		System.out.println(s);		// 方法中定义的局部变量必须初始化,否则编译不通过
        Thread t = new Thread() {
            public void run() {
                dianping();

            }
        };
        t.run();    // start方法才会创建新线程,run()方法只是简单的方法调用
        System.out.print("dazhong");

        ((TestClass) null).testMethod();    // 正常打印
    }

    static void dianping() {
        System.out.print("dianping");
        String dd = "dd";
    }

    /**
     * 方法的重载不允许参数列表相同,返回值不同
     *
     * @param a
     * @param b
     * @return
     */
    public int f1(int a, int b) {
        return a + b;
    }

    public double f1(double a, int b) {
        return 1.0;
    }

    // 参数顺序不同也是重载的一种
    public double f1(int b, double a) {
        return 1.0;
    }

    /**
     * 抽象类和接口里的抽象方法子类必须要实现
     */
    @Override
    public int interface1(int a, int b) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int abstract1(int a, int b) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void commonFunction() {

    }


    @Override
    public void abstract2() {
    }

}
