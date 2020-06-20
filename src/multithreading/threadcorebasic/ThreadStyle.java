package multithreading.threadcorebasic;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 10:43
 *
 * Thread创建多线程
 * 缺点： 任务创建和线程机制不解耦，每次
 */
public class ThreadStyle extends Thread{
    @Override
    public void run(){
        System.out.println("Thread多线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
