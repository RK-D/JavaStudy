package multithreading.objectthreadbasic.waitnotify;

/**
 * @author rookie
 * @date 2020/7/5
 * 两个线程交替打印0~100的奇偶数，用wait和notify
 */
public class WaitNotifyPrintOddEveWait {
    private static int count = 0;
    private static final Object lock = new Object();

//输出肯定是递增的但是容易线程错乱：，解决方法： 1.休眠 2.不写奇数偶数提示，
    public  static void main(String[] args)  {
        new Thread(new TurningRunner(), "偶数").start();
        //防止线程错乱使用休眠
//        Thread.sleep(100);
        new Thread(new TurningRunner(), "奇数").start();
    }

    //1. 拿到锁，我们就打印
    //2. 打印完，唤醒其他线程，自己就休眠
    static class  TurningRunner implements Runnable {

        @Override
        public  void run() {
            while (count <= 10000) {
                synchronized (lock) {
                    //拿到锁就打印
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if (count <= 10000) {
                        try {
                            //如果任务还没结束，就让出当前的锁，并休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
