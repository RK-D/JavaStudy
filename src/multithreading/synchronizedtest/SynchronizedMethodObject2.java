package multithreading.synchronizedtest;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/23 17:43
 *
 *  2. 对像锁形式2-普通方法锁
 *
 */
public class SynchronizedMethodObject2 implements Runnable{
    static SynchronizedMethodObject2 instance = new SynchronizedMethodObject2();

    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("finish");
    }

    @Override
    public void run() {
        method();
    }
    public synchronized void method(){
        System.out.println("Modified form of object lock method "+ Thread.currentThread().getName());
        try{
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
