package multithreading.threadsafe;

/**
 * @author rookie
 * @date 2020/7/6
 *
 * 用工厂模式修复刚才的初始化问题 针对 观察者模式
 * currentHashMap 安全
 */
public class MultiThreadsFactory {
    int count;
    private EventListener listener;

    private MultiThreadsFactory(MySource source) {
        listener = new EventListener() {
            @Override
            public void onEvent(MultiThreadsObserver.Event e) {
                System.out.println("\n我得到的数字是" + count);
            }

        };
        for (int i = 0; i < 10000; i++) {
            System.out.print(i);
        }
        count = 100;
    }

    public static MultiThreadsFactory getInstance(MySource source) {
        MultiThreadsFactory safeListener = new MultiThreadsFactory(source);
        source.registerListener(safeListener.listener);
        return safeListener;
    }

    public static void main(String[] args) {
        MySource mySource = new MySource();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mySource.eventCome(new MultiThreadsObserver.Event() {
                });
            }
        }).start();
        MultiThreadsFactory multiThreadsFactory = new MultiThreadsFactory(mySource);
    }

    static class MySource {

        private EventListener listener;

        void registerListener(EventListener eventListener) {
            this.listener = eventListener;
        }

        void eventCome(MultiThreadsObserver.Event e) {
            if (listener != null) {
                listener.onEvent(e);
            } else {
                System.out.println("还未初始化完毕");
            }
        }

    }

    interface EventListener {

        void onEvent(MultiThreadsObserver.Event e);
    }

    interface Event {

    }
}
