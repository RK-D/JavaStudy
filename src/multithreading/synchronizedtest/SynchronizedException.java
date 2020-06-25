package multithreading.synchronizedtest;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/25 11:37
 *
 * 方法抛出异常后，会释放锁
 * 1.一旦抛出了异常第二个线程会立刻进图同步方法说明锁已经释放
 *
 */
public class SynchronizedException implements Runnable{
    static SynchronizedException instance = new SynchronizedException();


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        }else {
            method2();
        }
    }

    public synchronized void method1(){
        System.out.println("1Use lock: "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1Finish Use lock : "+Thread.currentThread().getName());
    }
    public  synchronized void  method2(){
        System.out.println("2 Use lock: "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2Finish Not Use lock: "+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()){

        }
        System.out.println("ok");
    }
}
