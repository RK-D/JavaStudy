package synchronizedtest;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/25 11:32
 *
 * 同时访问静态synchronized和非静态synchronized方法
 */
public class SynchronizedStaticAndNot implements Runnable{
    static SynchronizedStaticAndNot instance = new SynchronizedStaticAndNot();


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        }else {
            method2();
        }
    }
    /**类锁，加static*/
    public static synchronized void method1(){
        System.out.println("static Use lock: "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static Finish Use lock : "+Thread.currentThread().getName());
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
