package multithreading.threadcorebasic.wangways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 11:18
 */
public class ThreadPool1 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task(){

            });
        }
    }
}

class Task implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
