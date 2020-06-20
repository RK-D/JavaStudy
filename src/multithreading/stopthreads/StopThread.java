package multithreading.stopthreads;

import org.omg.CORBA.INITIALIZE;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 23:52
 *
 *使用stop 的错误方法，突然强制停止操作，很危险，产生脏数据
 */
public class StopThread implements  Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            System.out.println("数据组"+i +"开始接受数据");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try{
                    Thread.sleep(50);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println("数据组" + i+ "领取完毕");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.stop();
    }
}
