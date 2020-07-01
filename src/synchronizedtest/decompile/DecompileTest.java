package synchronizedtest.decompile;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/7/1 13:50
 */
public class DecompileTest {
    private Object object = new Object();
    public void method(Thread thread){
        /**编写一个同步代码块
        PS: {} 括起来的就叫代码块 这里的同步是指使用了synchronized关键字*/
        synchronized (object){

        }
    }
}
