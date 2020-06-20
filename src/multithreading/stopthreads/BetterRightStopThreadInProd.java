package multithreading.stopthreads;

import org.omg.CORBA.INITIALIZE;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 22:46
 *
 * 好的实现方式： 传递中断
 * 在方法签名中抛出异常
 * 那么在run方法中强制try catch
 *
 * 那么问题来了
 *
 */
public class BetterRightStopThreadInProd implements Runnable{

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()){
            System.out.println("ing");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("保存日志");
                e.printStackTrace();
            }
        }
    }

    /**下面这种catch异常的方法是知己打印，但数据量一旦过大将那一排查，别的县城即使给了中断信息
     * 但是也将毫不知情的传递下去，尽管给了异常日志的打印大但是程序将会一直进行下去，错误信息会很快被掩盖
     *  e.printStackTrace(); 把中断直接给吞了，未能上报给run，这样可能害人
     *  所以修改为在run中强制try catch而非自己吞掉 因为Override 的run不支持throw exception
     * */
    private void throwInMethod() throws InterruptedException {
//        try{
//            Thread.sleep(1000);
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread( new Thread(new BetterRightStopThreadInProd()));
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
