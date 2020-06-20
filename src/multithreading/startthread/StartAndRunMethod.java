package multithreading.startthread;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 18:18
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(
                    Thread.currentThread().getName());
        };
        runnable.run();

        new Thread(runnable).start();
    }
}
