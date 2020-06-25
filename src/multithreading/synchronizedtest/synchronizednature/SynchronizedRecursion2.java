package multithreading.synchronizedtest.synchronizednature;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/25 12:07
 *
 * 可重入不要求同一个方法
 */
public class SynchronizedRecursion2 {
    public synchronized void method1(){
        System.out.println("method1:");
        method2();
    }
    public synchronized void method2(){
        System.out.println("method2:");
    }

    public static void main(String[] args) {
        SynchronizedRecursion2 synchronizedRecursion2 = new SynchronizedRecursion2();
        synchronizedRecursion2.method1();
    }
}
