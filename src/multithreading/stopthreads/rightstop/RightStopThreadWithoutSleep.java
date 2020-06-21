package multithreading.stopthreads.rightstop;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 20:14
 *
 * run中午sleep/wait 停止线程
 */
public class RightStopThreadWithoutSleep implements Runnable{

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() &&
                num <= Integer.MAX_VALUE / 2){
            if (num % 100000 == 0){
                System.out.println(num + "是100000倍数");
            }
            num ++;
        }
        System.out.println("run over");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(
                new RightStopThreadWithoutSleep());
        thread.start();
        Thread.sleep(10);
        thread.interrupt();
    }
}
