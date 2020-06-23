package multithreading.synchronizedtest;



/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/23 18:06
 */
public class SynchronizedMethodClass2 implements Runnable{
    static SynchronizedMethodClassStatic instance1 = new SynchronizedMethodClassStatic();
    static SynchronizedMethodClassStatic instance2 = new SynchronizedMethodClassStatic();


    public static void main(String[] args) throws InterruptedException{
        Thread thread1 = new Thread(instance1);
        Thread thread2 = new Thread(instance2);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()) {

        }
        System.out.println("finish");
    }

    @Override
    public void run() {
        try {
            method();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    /**类锁
     * */
    private void method() throws InterruptedException{
        //SynchronizedMethodClass2.class获取到 SynchronizedMethodClass2这个类
        synchronized (SynchronizedMethodClass2.class){
            System.out.println("class lock2 (*class)" +
                    Thread.currentThread().getName());
            Thread.sleep(3000);
            System.out.println("finish" +
                    Thread.currentThread().getName());
        }
    }
}
