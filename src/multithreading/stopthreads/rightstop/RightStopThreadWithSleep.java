package multithreading.stopthreads.rightstop;

import org.omg.CORBA.INITIALIZE;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 20:27
 */
public class RightStopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException{
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 400 && ! Thread.currentThread().isInterrupted()){
                    if (num % 100 == 0){
                        System.out.println(num + "100 倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }


        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
