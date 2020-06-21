package multithreading.sixthreadstates;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/21 17:51
 *
 * 线程的Blocked Waiting TimedWaiting
 */
public class BlockedWaitingTimedWaiting implements Runnable{
    @Override
    public void run() {
        syn();
    }

    private synchronized void syn(){
        try {
            //这是Timed waiting
            Thread.sleep(1000);
//            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting blockedWaitingTimedWaiting = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(blockedWaitingTimedWaiting);
        thread1.start();
        Thread thread2 = new Thread(blockedWaitingTimedWaiting);
        thread2.start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出timed_waiting状态
        System.out.println("thread1 "+thread1.getState());
        //打印Blocked状态，以为thread1拿不到synchronized 锁
        System.out.println("thread2 "+thread2.getState());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印出waiting状态，因为未被唤醒
        System.out.println("thread1 "+thread1.getState());
    }

}
