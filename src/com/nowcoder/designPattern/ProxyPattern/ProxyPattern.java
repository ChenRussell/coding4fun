package com.nowcoder.designPattern.ProxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by ChenRui on 18-4-13
 *
 * JDK的动态代理主要涉及java.lang.reflect包中的两个类：Proxy和InvocationHandler。
 * 其中InvocationHandler只是一个接口，可以通过实现该接口定义横切逻辑，
 * 并通过反射机制调用目标类的代码，动态的将横切逻辑与业务逻辑织在一起。
 * 而Proxy利用InvocationHandler动态创建一个符合某一接口的实例，生成目标类的代理对象。
 * 其代理对象必须是某个接口的实现, * 它是通过在运行期间创建一个接口的实现类来完成对目标对象的代理.
 * 只能针对实现接口的类生成代理,而不能针对类
 */
public class ProxyPattern {

        interface IHello {
            void sayHello();
        }

        static class Hello implements IHello {

            @Override
            public void sayHello() {
                System.out.println("这是看目标对象的逻辑： hello world!");
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
                System.out.println("这是横切逻辑！");
                return method.invoke(originalObj, args);
            }
        }

        public static void main(String[] args) {
            // 生成字节码文件
//        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

            IHello hello = (IHello) new DynamicProxy().bind(new Hello());
            hello.sayHello();
        }
}
