package org.cr.testClass;

import java.util.Date;

public class SuperTest extends Date{

	private void test() {
		System.out.println(super.getClass().getName());		// ���ر���+����
		System.out.println(super.getClass().getSuperclass().getName());	// �õ����������
	}

	public static void main(String[] args) {
		new SuperTest().test();
	}
}
