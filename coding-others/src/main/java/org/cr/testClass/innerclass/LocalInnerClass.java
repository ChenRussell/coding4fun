package org.cr.testClass.innerclass;

/**
 * �ֲ��ڲ����Ƕ�����һ����������һ��������������࣬���ͳ�Ա�ڲ�����������ھֲ��ڲ���ķ���Ȩ�޽����ڷ����ڻ��߸�
 * ��������
 */
public class LocalInnerClass {

    class People {
    }

    class Man {

    }
    public People getInnerClass() {
        int a = 3;
        class Woman extends People {        // �ֲ��ڲ���
            int age = 0;
            int b = a;
        }
        return new Woman();
    }
}
