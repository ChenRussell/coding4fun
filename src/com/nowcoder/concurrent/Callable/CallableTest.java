package com.nowcoder.concurrent.Callable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by ChenRui on 18-3-15
 *
 *  方式1：通过单线程的方式我们自己实现，首先创建一个FutureTask对象，在创建FutureTask对象的时候，
 *  需要传入一个实现了Callable接口的对象，接着以该FutureTask作为Thread的参数，调用Thread的start方法开启线程执行任务，
 *  最后使用FutureTask的get方法获取到任务的返回值就可以了；那么为什么FutureTask对象可以作为Thread的参数呢？
 *  原因就在于FutureTask类实现了RunnableFuture接口，
 *  而RunnableFuture接口实现了Runnable和Future接口，那么当然可以作为Thread的参数了，我们来看看这种实现方式；
 * <p>
 * 可以看到确实得到了call方法的返回值，但是在调用get方法的时候却造成了主线程的阻塞，
 * 因为我们在call方法里面让子线程暂停了3秒，这时候如果不阻塞主线程的话，输出语句中的第三行时间不应该是12:21:46的，
 * 应该是12:21:43，因此验证了上面我们给出的结论，但是使用Runnable接口是不会造成主线程阻塞的，具体实例马上给出；
 */
public class CallableTest {
    public static void main(String[] args) {
        //创建实现了Callable接口的对象
        MyCallable callable = new MyCallable();
        //将实现Callable接口的对象作为参数创建一个FutureTask对象
        FutureTask<String> task = new FutureTask<>(callable);
        //创建线程处理当前callable任务
        Thread thread = new Thread(task);
        //开启线程
        System.out.println("开始执行任务的时间: " + getNowTime());
        thread.start();
        //获取到call方法的返回值
        try {
            String result = task.get();
            System.out.println("得到返回值: " + result);
            System.out.println("结束执行get的时间: " + getNowTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getNowTime() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date());
    }
}

class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "call method result";
    }
}