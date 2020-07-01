package synchronizedtest;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/25 11:12
 * 同时访问同步方法与非同步方法
 */
public class UseSynchronizedAndNotUse implements Runnable{
    static UseSynchronizedAndNotUse instance = new UseSynchronizedAndNotUse();


    @Override
    public void run() {
        if (Thread.currentThread().getName().equals("Thread-0")) {
            method1();
        }else {
            method2();
        }
    }

    public  synchronized void method1(){
        System.out.println("Use lock: "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish Use lock : "+Thread.currentThread().getName());
    }
    public  void  method2(){
        System.out.println("Not Use lock: "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finish Not Use lock: "+Thread.currentThread().getName());
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
