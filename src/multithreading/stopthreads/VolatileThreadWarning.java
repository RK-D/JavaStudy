package multithreading.stopthreads;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/21 0:04
 */
public class VolatileThreadWarning implements Runnable{
    private volatile boolean canceled = false;


    @Override
    public void run() {
        int num = 0;
        try{
            while (num <= 10000 && !canceled) {
                if (num %100 == 0){
                    System.out.println(num + "是100倍数");
                }
                num ++;
                Thread.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileThreadWarning volatileThreadWarning = new VolatileThreadWarning();
        Thread thread = new Thread(volatileThreadWarning);
        thread.start();
        Thread.sleep(500);
        volatileThreadWarning.canceled = true;
    }
}
