package org.cr.testClass.innerclass;

/**
 * �����ڲ���
 */
public class AnonymousInnerClass {

    public void test(){
        int afinal = 23;

        for (int i = 0; i < 6; i++) {

            Runnable runnable = new Runnable() {     // �����ڲ���
                @Override
                public void run() {
                    System.out.println("this is a anonymous class!" + afinal);   // û�����final���Ͳ�����?????
                }
            };
        }
    }

    public static void main(String[] args) {
        int afinal = 23;

        /**
         * ������˵�ġ������ڲ��ࡱ��Ҫ��ָ�����ⲿ��ĳ�Ա�����ڶ����ͬʱ���ʵ�������࣬������ʸó�Ա�����еľֲ�������
         * �ֲ���������Ҫ��final���Ρ�ԭ���Ǳ�����ʵ���ϵ����ѣ��ڲ��������������ں��п��ܻᳬ���ֲ��������������ڡ�
         *
         * ��������������ڲ��������Է���ͬһ�������б�����Ϊfinal���͵ľֲ�����������Ϊfinal��
         * ��������������ڲ������Ҫ���ʵ�����final���;ֲ�������������һ����Ϊ�ö���ĳ�Ա������
         * ��������ʹջ�оֲ������Ѿ�������
         * �����ڲ���������������õ��þֲ�������ֵ����Ϊ���Լ�������һ�ݣ�
         * ����ԭ�ֲ�������ֵʼ�ձ���һ�£�final���Ͳ��ɱ䣩
         * COPY LOCAL VARIABLE
         */
        for (int i = 0; i < 6; i++) {

            Runnable runnable = new Runnable() {     // �����ڲ���
                @Override
                public void run() {
                    System.out.println("this is a anonymous class!" + afinal);   // û�����final���Ͳ�����?????
                }
            };
        }

//        runnable.run();
//        new Thread(() -> System.out.println("this is another anonymous class!")).start();
    }
}
