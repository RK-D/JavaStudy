package synchronizedtest.disadvantages;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/7/1 15:10
 */
public class Test {
    public static void main(String[] args) {
        //lock对比显示synchronized的缺点
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();
        lock.tryLock();
    }
}
