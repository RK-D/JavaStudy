package Multithreading.threadcorebasic;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 10:31
 * Runnable方式创建线程
 */
public class RunnableStyle implements Runnable {
    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }
    @Override
    public void run() {
        System.out.println("Runnable多线程");
    }
}
