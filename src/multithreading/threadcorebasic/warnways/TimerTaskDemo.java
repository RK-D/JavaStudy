package multithreading.threadcorebasic.warnways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 15:43
 *
 * 定时器创建线程
 */
public class TimerTaskDemo {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        }, 1000, 1000);
    }
}
