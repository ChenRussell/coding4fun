package org.cr.testClass;

public interface InterfaceSuperClass {

	static int a=2;

	public int interface1(int a, int b);

	public void commonFunction();

	/**
	 * jdk1.8���ṩ�˾�̬������default����,�������ַ���������ʵ��
	 */
	default void fuck(){}

	static void you(){}
}
