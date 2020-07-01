package synchronizedtest;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/23 12:13
 * synchronized 两种用法 1.对象锁（包括方法锁）默认锁对象为this当前实例对象，和同步代码块锁
 * （自己指定锁对象）
 * <p>
 * 2.类锁 指synchronized修饰的静态方法或者指定锁为class对象
 */
public class SynchronizedMethodObject implements Runnable {
    /**
     * 静态实例，用于指定自己的Runnable对象
     */
    static SynchronizedMethodObject instance = new SynchronizedMethodObject();
    /**
     * @lock 充当锁对象
     * 说在前面： 尽可能去使用synchronized而不要去使用LOCK，但是
     *
     * ？ 什么时候用自定义lock而不是this一个，为什么呢？
     * 业务复杂时使用，并行执行，线程通信，原生自己写不是很好，可以使用java自己定义的工具
     * eg： CountDownLatch（倒计时门栓），
     * ps: synchronized 只能锁静态代码块，不管锁什么都是锁对象
     * 提一嘴 CyclicBarrier是栅栏闭锁
     *
     * 1.先说一下synchronized缺陷
     * 如果一个代码块被synchronized修饰了，当一个线程获取了对应的锁，并执行该代码块时，其他线程便只能一直等待，等待获取锁的线程释放锁，而这里获取锁的线程释放锁只会有两种情况：
     * 1）获取锁的线程执行完了该代码块，然后线程释放对锁的占有；
     * 2）线程执行发生异常，此时JVM会让线程自动释放锁。
     *
     * 例子1：
     * 如果这个获取锁的线程由于要等待IO或者其他原因（比如调用sleep方法）被阻塞了，但是又没有释放锁，其他线程便只能干巴巴地等待，试想一下，这多么影响程序执行效率。
     * 因此就需要有一种机制可以不让等待的线程一直无期限地等待下去（比如只等待一定的时间或者能够响应中断），通过Lock就可以办到。
     * 例子2：
     * 当有多个线程读写文件时，读操作和写操作会发生冲突现象，写操作和写操作会发生冲突现象，但是读操作和读操作不会发生冲突现象。
     * 但是采用synchronized关键字来实现同步的话，就会导致一个问题：
     * 如果多个线程都只是进行读操作，当一个线程在进行读操作时，其他线程只能等待无法进行读操作。
     *
     *
     *
     * */
    final Object lock = new Object();
    final Object lock2 = new Object();

    @Override
    public void run() {
        //用同一个保证串行执行，这里this替换成lock
        synchronized (lock) {
            System.out.println("lock1 thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock1 finished");
        }

        synchronized (lock2) {
            System.out.println("lock2 thread " + Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " lock2 finished");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("finish");
    }
}
