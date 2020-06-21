package multithreading.stopthreads.rightstop;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 22:17
 */
public class RightStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException{
        Runnable runnable = ()->{
            int num = 0;
            try{
                //&& !Thread.currentThread().isInterrupted() 多余此处不需要
                while (num <= 1000 ){
                    if (num % 100 == 0){
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            }catch (InterruptedException e) {
                e.printStackTrace(); //这句话会在该方法隐藏它的异常信息
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(6000);
        thread.interrupt();
    }
}
