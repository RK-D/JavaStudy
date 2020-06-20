package multithreading.startthread;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 18:26
 *
 * 不能两次调用start
 */
public class CantStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();

    }
}
