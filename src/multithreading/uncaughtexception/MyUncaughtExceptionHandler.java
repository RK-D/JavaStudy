package multithreading.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author rookie
 * @date 2020/7/6
 * 自己的MyUncaughtExceptionHanlder
 */
public class MyUncaughtExceptionHandler  implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常，终止啦" + t.getName());
        System.out.println(name + "捕获了异常" + t.getName() + "异常");
    }
}
