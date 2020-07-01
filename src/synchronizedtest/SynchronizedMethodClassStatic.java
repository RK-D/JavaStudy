package synchronizedtest;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/23 17:52
 *
 * Java类可能有很多个对象，但只有1个Class对象
 *
 * 所以synchronized获取的锁对象是Class对象的锁
 *
 * 形式1： synchronized加上static方法上
 * 形式2： synchronized(*.class)代码块
 *
 * @SynchronizedMethodClassStatic synchronized加上static方法上
 */
public class SynchronizedMethodClassStatic implements Runnable{
    /**这人是static方法，不是静态形式和类锁无关*/
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
    /**类锁的实现形式1： static形式*/
    public static synchronized void method(){
        System.out.println("class lock1 "+ Thread.currentThread().getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"finish");
    }

    @Override
    public void run() {
        method();
    }

}
