package org.cr.testClass;

/**
 * Created by ChenRui on 2018/4/9
 * <p>
 * ��ν��̬������������ʱ��������Ѿ��϶��˷��������ĸ��ࡣ
 * <p>
 * רҵ�������ϸ�ĺ���,����Ҫ׼ȷ."��д"ֻ��������ʵ������.
 * �������ھ�̬����.���ھ�̬����,ֻ������(�ղŵ����ӿ�����д��ֻ����ʽ�ϵ� �����������̬�������������ϸ�˵������д)��
 * <p>
 * ��̬�����ĵ��ò���Ҫʵ������..  ��ʵ����Ҳ�Ͳ����ö�̬�ˣ�Ҳ��û����ν�ĸ�������ָ������ʵ��.��Ϊ����ʵ����
 * Ҳ��û�л���ȥָ�������ʵ��������Ҳ�Ͳ����ڶ�̬�ˡ�
 */
class Base1 {
    static void a() {
        System.out.println("A");
    }

    void b() {
        System.out.println("B");
    }
}

public class TestStaticOverwrite extends Base1 {
    static void a() {
        System.out.println("C");
    }

    void b() {
        System.out.println("D");
    }

    public static void main(String args[]) {
        Base1 b = new Base1();
        Base1 c = new TestStaticOverwrite();
        b.a();
        b.b();
        c.a();  // ��ӡA������C�� ˭�����ĵ���˭
        c.b();
    }
}
