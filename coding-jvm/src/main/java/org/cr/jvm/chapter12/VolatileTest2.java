package org.cr.jvm.chapter12;

/**
 * @author russ
 * @project coding4fun
 * @date 2022/01/06
 */
public class VolatileTest2 extends Thread {

    private static volatile boolean flag = false;
    public void run() {
        while (!flag) ;
    }

    public static void main(String[] args) throws Exception {
        new VolatileTest2().start();
        Thread.sleep(2000);
        flag = true;
    }
}
