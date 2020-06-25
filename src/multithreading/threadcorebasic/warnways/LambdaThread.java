package multithreading.threadcorebasic.warnways;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 17:38
 *
 * lambda表达式实现
 */
public class LambdaThread {
    public static void main(String[] args) {
        new Thread(()-> System.out.println(
                Thread.currentThread().getName())).start();
    }
}
