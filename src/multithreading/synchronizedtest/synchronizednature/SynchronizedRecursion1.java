package multithreading.synchronizedtest.synchronizednature;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/25 12:06
 * 同一个方法可以重入
 */
public class SynchronizedRecursion1 {
    int num = 0;

    public static void main(String[] args) {
        SynchronizedRecursion1 synchronizedRecursion1 = new SynchronizedRecursion1();
        synchronizedRecursion1.method();
    }
    public synchronized void method(){
        System.out.println("thread :"+ Thread.currentThread().getName()+",num: "+num);
        if (num == 0){
            num++;
            method();
        }
    }

}
