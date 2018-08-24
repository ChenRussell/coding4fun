package com.nowcoder.testClass;
/**
 * 解释一:
 * 开始时JVM加载B.class，对所有的静态成员进行声明，t1 t2被初始化为默认值，为null，又因为t1 t2需要被显式初始化，
 * 所以对t1进行显式初始化，初始化代码块→构造函数（没有就是调用默认的构造函数），咦！静态代码块咋不初始化？
 * 因为在开始时已经对static部分进行了初始化，虽然只对static变量进行了初始化，但在初始化t1时也不会再执行static块了，
 * 因为JVM认为这是第二次加载类B了，所以static会在t1初始化时被忽略掉，所以直接初始化非static部分，
 * 也就是构造块部分（输出''构造块''）接着构造函数（无输出）。接着对t2进行初始化过程同t1相同（输出'构造块'），
 * 此时就对所有的static变量都完成了初始化，接着就执行static块部分（输出'静态块'），接着执行，main方法，
 * 同样也，new了对象，调用构造函数输出（'构造块'）

 *解释二:
 *main方法作为程序的入口，会触发类加载中的初始化，所以遇到main方法时，会按顺序加载类中静态变量，执行静态代码块，
 *所以会先初始化t1，再t2，这两个不再触发类加载(因为JVM认为类已经加载过)，所以不会执行静态代码，只执行构造块了。
 *
 *解释三:
 *静态块：用static申明，JVM加载类时执行，仅执行一次
	构造块：类中直接用{}定义，每一次创建对象时执行
	执行顺序优先级：静态块>main()>构造块>构造方法
	静态块按照申明顺序执行，所以先执行publicstaticB t1 = newB();该语句创建对象，则又会调用构造块，输出构造块
	接着执行public static B t1 = new B();输出构造块
	再执行
	static
	{
	System.out.println("静态块");
	}输出静态块
	最后main方法执行，创建对象，输出构造块。
 * @author chenrui
 *
 */
public class StaticTest {

	public static StaticTest t1 = new StaticTest();
	public static StaticTest t2 = new StaticTest();
	
	{
		System.out.println("构造快");
	}
	static {
		System.out.println("静态块");
	}
	
	public static void main(String[] args) {
		StaticTest t = new StaticTest();
	}
}

/**
 * output:
 *  构造快
	构造快
	静态块
	构造快
 */
