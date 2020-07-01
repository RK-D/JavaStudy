package synchronizedtest.principle;



import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/7/1 8:08
 */
public class SynchronizedInnerLock {
    Lock lock = new ReentrantLock();
    public synchronized void method (){
        System.out.println("synchronized lock ");
    }

    public void method2(){
        lock.lock();
        try{
            System.out.println("lock lock");
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SynchronizedInnerLock synchronizedInnerLock  = new SynchronizedInnerLock();
        synchronizedInnerLock.method();
        synchronizedInnerLock.method2();
    }
}
