package synchronizedtest.synchronizednature;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/25 12:08
 * 可重入其他类: 调用父类的方法测试
 */
public class SynchronizedRecursion3 {

    public synchronized void method() {
        System.out.println("source class");
    }

}

class Test extends SynchronizedRecursion3{
    @Override
    public synchronized void method(){
        System.out.println("Derived class");
        super.method();
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.method();
    }
}