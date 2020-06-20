package multithreading.threadcorebasic.wangways;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 17:33
 *
 * 匿名内部类
 */
public class AnonymousInnerClass {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
