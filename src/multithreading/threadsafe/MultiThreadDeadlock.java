package multithreading.threadsafe;

/**
 * @author rookie
 * @date 2020/7/6
 * 写一个必然死锁
 * 思路：两把锁，互相竞争资源，不放开资源，同事sleep是不释放锁的，然后先获取对方的锁产生竞争，从而死锁
 *
 */
public class MultiThreadDeadlock implements Runnable {

    int flag = 1;
    static Object o1 = new Object();
    static Object o2 = new Object();

    public static void main(String[] args) {
        MultiThreadDeadlock r1 = new MultiThreadDeadlock();
        MultiThreadDeadlock r2 = new MultiThreadDeadlock();
        r1.flag = 1;
        r2.flag = 0;
        new Thread(r1).start();
        new Thread(r2).start();
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if (flag == 1) {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    System.out.println("1");
                }
            }
        }
        if (flag == 0) {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    System.out.println("0");
                }
            }
        }
    }
}
