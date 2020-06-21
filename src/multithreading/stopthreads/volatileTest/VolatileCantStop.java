package multithreading.stopthreads.volatileTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/21 0:14
 *
 * 建立生产者消费者模型，生产速度快，消费者慢，阻塞队列满
 * 生产者阻塞，等待消费者消费
 * volatile失效
 */
public class VolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue storage = new ArrayBlockingQueue(10);
        Producer producer = new Producer(storage);
        Thread producerThread = new Thread(producer);
        producerThread.start();
        Thread.sleep(1000);
        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNums()){
            System.out.println(consumer.storage.take()+"被消费");
            Thread.sleep(100);

        }
        System.out.println("消费者不需要数据了");
        producer.canceled = true;
        System.out.println(producer.canceled);
    }
}

class Producer implements Runnable{
    public volatile boolean canceled = false;
    BlockingQueue storage;
    public Producer(BlockingQueue storage){
        this.storage = storage;
    }
    @Override
    public void run() {
        int num = 0;
        try{
            while (num <= 100000 && !canceled) {
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
class Consumer{
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