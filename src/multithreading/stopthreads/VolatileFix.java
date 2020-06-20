package multithreading.stopthreads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/21 1:13
 *
 * 中断修复 死循环，阻塞死情况
 */
public class VolatileFix {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        multithreading.stopthreads.Producer producer = new multithreading.stopthreads.Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);
        multithreading.stopthreads.Consumer consumer = new multithreading.stopthreads.Consumer(storage);
        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take()+"被消费");
            Thread.sleep(100);

        }
        System.out.println("消费者不需要数据了");
       producerThread.interrupt();
        System.out.println(producer.canceled);
    }
    static class Producer implements Runnable{
        public volatile boolean canceled = false;
        BlockingQueue storage;
        public Producer(BlockingQueue storage){
            this.storage = storage;
        }
        @Override
        public void run() {
            int num = 0;
            try{
                while (num <= 100000 && Thread.currentThread().isInterrupted()) {
                    if (num %100 == 0){
                        storage.put(num);
                        System.out.println(num + "是100倍数,并放入队列");
                    }
                    num ++;
                    //Thread.sleep(1); w为什么在这儿加上休眠程序就会执行到finally？，而且会停止，否则将会一直死循环
                    // 初步思考：sleep的设计会清除它的线程状态
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                System.out.println("生产者停止生产");
            }
        }
    }
    static class Consumer{
        BlockingQueue storage;
        public Consumer(BlockingQueue storage){
            this.storage = storage;
        }
        public  boolean needMoreNums(){
            if (Math.random() > 0.95){
                return false;
            }
            return true;
        }
    }
}
