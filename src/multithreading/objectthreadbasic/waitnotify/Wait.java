package multithreading.objectthreadbasic.waitnotify;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/23 11:34
 *
 * wait & notify 基本用法
 * 1.研究代码执行顺序
 * 2.证明wait释放锁
 */
public class Wait {
    public static Object object = new Object();
    static class  Thread1 extends Thread{
        @Override
        public void run() {
         synchronized (object){
             System.out.println("thread1 start");
             try{
                 object.wait();
             }catch (InterruptedException e){
                 e.printStackTrace();
             }
             System.out.println("Thread " +
                     Thread.currentThread().getName()+" get lock");
         }
        }
    }

    static class  Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                object.notify();
                System.out.println("Thread "  +
                        Thread.currentThread().getName()+
                        " use notify");
            }
        }
    }

    // 是二者相互合作，必须wait先执行notify后执行唤醒
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        Thread.sleep(200);
        thread2.start();
    }
}
