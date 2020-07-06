package multithreading.jmm;

import java.util.concurrent.CountDownLatch;

/**
 * @author rookie
 * @date 2020/7/6
 *
 * 演示重排序的现象 “直到达到某个条件才停止”，测试小概率事件
 * x,y都为0才是重排序，一般几乎不会遇到 --》重排序后的可能(y=a ,a=1, x=b ,b=1)
 */
public class OutOfOrderExecution {
    private static int x = 0, y = 0, a = 0, b = 0;


    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            //倒计时闭锁，让两个线程同时进行，模拟特殊情况，a，b先赋值，导致x，y都为1
            CountDownLatch latch = new CountDownLatch(3);

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.countDown();
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });
            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.countDown();
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });
            two.start();
            one.start();
            latch.countDown();
            one.join();
            two.join();

            String result = "第" + i + "次（" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }

}
