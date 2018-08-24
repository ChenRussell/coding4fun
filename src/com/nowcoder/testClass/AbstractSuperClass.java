package com.nowcoder.testClass;


public abstract class AbstractSuperClass implements InterfaceSuperClass{

    /**
     * 抽象类可以有构造方法，但是不能实例化
     */
    public static final int d = 2;

    public AbstractSuperClass() {
	}

	public abstract int abstract1(int a , int b);


	public abstract void abstract2();

    public abstract void commonFunction();

}
