package org.cr.designpattern.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ChenRui on 18-4-13
 *
 * JDK�Ķ�̬������Ҫ�漰java.lang.reflect���е������ࣺProxy��InvocationHandler��
 * ����InvocationHandlerֻ��һ���ӿڣ�����ͨ��ʵ�ָýӿڶ�������߼���
 * ��ͨ��������Ƶ���Ŀ����Ĵ��룬��̬�Ľ������߼���ҵ���߼�֯��һ��
 * ��Proxy����InvocationHandler��̬����һ������ĳһ�ӿڵ�ʵ��������Ŀ����Ĵ������
 * �������������ĳ���ӿڵ�ʵ��, * ����ͨ���������ڼ䴴��һ���ӿڵ�ʵ��������ɶ�Ŀ�����Ĵ���.
 * ֻ�����ʵ�ֽӿڵ������ɴ���,�����������
 */
public class ProxyPattern {

        interface IHello {
            void sayHello();
        }

        static class Hello implements IHello {

            @Override
            public void sayHello() {
                System.out.println("���ǿ�Ŀ�������߼��� hello world!");
            }
        }

        static class DynamicProxy implements InvocationHandler {

            Object originalObj;

            Object bind(Object originalObj) {
                this.originalObj = originalObj;
                return Proxy.newProxyInstance(originalObj.getClass().getClassLoader(), originalObj.getClass().getInterfaces(), this);
            }

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("���Ǻ����߼���");
                return method.invoke(originalObj, args);
            }
        }

        public static void main(String[] args) {
            // �����ֽ����ļ�
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

            IHello hello = (IHello) new DynamicProxy().bind(new Hello());
            hello.sayHello();
        }
}
