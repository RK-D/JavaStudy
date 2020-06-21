package multithreading.stopthreads;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/21 16:08
 */
public class RightInterrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                for (; ; ) {
                }
            }
        });

        // 启动线程
        threadOne.start();
        //设置中断标志
        threadOne.interrupt();
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        //获取中断标志并重置
        //不应该通过类实例访问静态成员
        System.out.println("isInterrupted: " + threadOne.interrupted());
        //获取中断标志并重直
        System.out.println("isInterrupted: " + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupted: " + threadOne.isInterrupted());
        threadOne.join();
        System.out.println("Main thread is over.");

    }
}
