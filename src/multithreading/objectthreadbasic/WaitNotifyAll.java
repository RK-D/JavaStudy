package multithreading.objectthreadbasic;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/23 11:46
 *3个线程，线程1和线程2 首先被阻塞，线程3唤醒他们notify和notifyAll
 * start 先执行不代表线程先启动
 *
 */
public class WaitNotifyAll implements Runnable{
    private static final Object resourceA  = new Object();
    @Override
    public void run() {

    }
}
