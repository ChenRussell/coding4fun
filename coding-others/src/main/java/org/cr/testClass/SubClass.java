package org.cr.testClass;

public class SubClass extends SuperClass {

	public void getSuperInfo() {
		System.out.println(this.a);
	}

	public static void printInfo() {
		System.out.println("this is a static function!");
	}

	public int a = 12;

//	@Test
	public void print() {
		// super�������Ӧ�Ķ���,������super�������������޷�ֱ��ʹ�õĸ����Ա�ͷ���
		System.out.println(super.a);
		System.out.println(this.a);
		System.out.println(a);	// ���า���˸���ĳ�Ա������,Ҫ����ʸ���ĸó�Ա������ֵ,����Ҫʹ��super�ؼ���
	}
}
