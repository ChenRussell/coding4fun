package org.cr.testClass;

/**
 * ���ȣ�super()����ָ���ǵ��ø���Ĺ��췽��
 * ��
 * new B()
 * ִ��B�Ĺ��캯������һ����super(5);
 * ��ʱִ�е���A�Ĺ��캯����A�Ĺ��캯�����õ���setValue()����������B��д��A�����������
 * ���ԣ�����ִ�е���B�� setValue()������
 * ������Ĳ�����2*5=10
 * ��ʱ����Ϊsuper�����Ե��õ��Ǹ���� setValue()��������value=10
 * ��һ��ִ����ϡ�
 * �ڶ����� setValue(getValue()-3);
 * Bû��getValue()��������ִ�и���Ĵ˷�����
 * try���ص���value=10+1=11����������ʱջ��
 * finally�е���this�ķ��������thisָ����B�Ķ�������д���ʾ���B�� setValue()����
 * value=2*11=22����һ����ӡ����Ļ�ϵ�����
 * ���������� getValue()-3=11-3=8
 * ����B�� setValue()����
 * ��ʱvalue=2*8=16
 * ���ˣ�new B()ִ�н���
 * ��
 * new B(). getValue()
 * Bû�� getValue()����ִ��A�� getValue()
 * try����16+1=17�����浽��ʱջ��
 * finally����B�� setValue()����
 * value=17*2=34���ڶ�����ӡ����Ļ���������
 * �����������ӡ����ֵ��Ҳ����try���浽��ʱջ��17
 *
 * @author chenrui
 */
public class SubClassOverload {

    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }

    static class A {
        protected int value;

        public A(int v) {
            setValue(v);    // ������д��setValue()����,���õ�������ķ���
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;    // ���浽��ʱջ
            } finally {    //finally������Ȼ�ı���value��ֵ����try���з��ص�Ӧ����return֮ǰ�洢��ֵ��
                this.setValue(value);    // ������д��setValue()����,���õ�������ķ���
                System.out.println(value);
            }
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}
/**
 * output:
 * 22
 * 34
 * 17
 */
