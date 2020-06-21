package multithreading.sixthreadstates;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/21 17:36
 *
 * 线程的New Runnable Terminated
 * 即使在正在执行的线程也是Runnable而不是Running
 */
public class NewRunnableTerminated implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTerminated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try{
            Thread.sleep(10);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //打印正在执行的线程也是Runnable而不是Running\
        // 会发现在执行中突然有了这么一行 RUNNABLE
        System.out.println(thread.getState());
        try{
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(thread.getState());
    }
}
