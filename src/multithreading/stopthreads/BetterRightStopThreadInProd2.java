package multithreading.stopthreads;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 23:13
 *
 * 恢复中断逻辑
 */
public class BetterRightStopThreadInProd2 implements Runnable{
    @Override
    public void run() {
        while (true ){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("中断，程序结束");
                break;
            }
            returnInterrupt();
        }
    }


    private void returnInterrupt() {
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread( new Thread(new BetterRightStopThreadInProd2()));
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
