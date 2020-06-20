package Multithreading.threadcorebasic.wangways;

import java.util.concurrent.*;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 11:38
 */
public class CallableFuture {
    public static void main(String[] args) {
        System.out.println("main start");
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // Future<?> future = threadPool.submit(new MyRunnable()) ;
        Future<String> future = threadPool.submit(new MyCallable());
        try {
            // 这里会发生阻塞
            System.out.println(future.get());
        } catch (Exception e) {

        } finally {
            threadPool.shutdown();
        }
        System.out.println("main end");
    }
}
class MyCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        // 模拟耗时任务
        Thread.sleep(3000);
        System.out.println("MyCallable 线程：" + Thread.currentThread().getName());
        return "MyCallable" ;
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        // 模拟耗时任务
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyRunnable");
    }
}