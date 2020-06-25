package multithreading.synchronizedtest;

import javax.swing.plaf.SliderUI;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/23 18:15
 *
 * 运用两种synchronized锁解决，并发问题
 */
public class SolveDisappearRequest implements Runnable{
    static SolveDisappearRequest instance  = new SolveDisappearRequest();
    static int i = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        //join等待状态，按序执行
        thread1.join();
        thread2.join();
        //执行结果每次都不一眼且不符合预期i++执行时三步骤，1.读取i 2.i+1 3.把i写入内存
        //所以多线程式存在抢占等问题，执行中万一被抢占则进入等待，随后，数据丢失
        //这种叫线程不安全
        System.out.println(i);
    }

   /**
    @Override
    public synchronized void run() {
        for (int j = 0; j < 100000; j++) {
            i++;
        }
    }
   */

 /**
    @Override
   public  void run() {
       synchronized (this){
           for (int j = 0; j < 100000; j++) {
               i++;
           }
       }
   }
 */

   @Override
    public void run(){
      synchronized (SolveDisappearRequest.class){
          for (int j = 0; j < 100000; j++) {
              i++;
          }
      }
   }
   //最后一种不能使用static方法在run，但是自己写的可以使用
}
