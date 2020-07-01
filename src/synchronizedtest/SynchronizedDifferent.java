package synchronizedtest;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/25 11:24
 *
 * 访问同一个对象的不同的普通同步方法
 */
public class SynchronizedDifferent implements Runnable{
    static SynchronizedDifferent instance = new SynchronizedDifferent();


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
//            throw new Exception(); 这样抛出异常是错误的，因为这样抛出还是会执行到代码块try catch之外，同时打印出正常执行的结束语句这显然不合理
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        RuntimeException不要求强制不会，以为运行中无法预判
        throw new RuntimeException();
//        System.out.println("1Finish Use lock : "+Thread.currentThread().getName());
    }
    public  synchronized void  method2(){
        System.out.println("2Not  Use lock: "+Thread.currentThread().getName());
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
