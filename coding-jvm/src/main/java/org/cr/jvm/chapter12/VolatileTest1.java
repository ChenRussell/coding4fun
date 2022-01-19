package org.cr.jvm.chapter12;

/**
 * @author chenrui.a@mininglamp.com
 * @project coding4fun
 * @date 2022/01/06
 */
public class VolatileTest1 extends Thread {

    private static boolean flag = false;
    public void run() {
        while (!flag) ;
    }

    public static void main(String[] args) throws Exception {
        new VolatileTest1().start();
        Thread.sleep(2000);
        flag = true;
    }
}
