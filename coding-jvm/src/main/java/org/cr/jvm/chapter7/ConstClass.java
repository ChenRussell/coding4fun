package org.cr.jvm.chapter7;

/**
 * ����ʹ�����ֶ���ʾ��:
 * �����ڱ���׶λ���������ĳ�������,�����ϲ�û��ֱ�����õ����峣������,��˲��ᴥ�����峣������ĳ�ʼ��
 * @author chenrui
 *
 */
public class ConstClass {

	static {
		System.out.println("ConstClass init!");
	}

	public static final String HELLOWORLD = "hello world";
}
