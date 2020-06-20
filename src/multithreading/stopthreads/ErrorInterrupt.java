package multithreading.stopthreads;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 22:26
 *
 * try catch放在while循环内，会失效？为什么？
 * while因为此处try catch对象并非所有的线程，而是单单针对哪一个中断产生的线程。
 * 即使加入!Thread.currentThread().isInterrupted() 判断也无效，
 * 这是while内try catch的问题因为sleep设计的理念  存在一种清除机制即
 * @throws  InterruptedException 如果有任何线程中断了当前线程。抛出此异常时，将清除当前线程的* i状态
 *
 */
public class ErrorInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = ()->{
            int num = 0;
            while (num <= 1000 && !Thread.currentThread().isInterrupted()){
                if (num % 100 == 0){
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
