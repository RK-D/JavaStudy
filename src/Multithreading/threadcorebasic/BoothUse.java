package Multithreading.threadcorebasic;

import sun.management.snmp.jvminstr.JvmOSImpl;

/**
 * @author rookie
 * @version 1.0
 * @date 2020/6/20 11:03
 *
 * 同时使用两种创建方式
 */
public class BoothUse {
    public static void main(String[] args) {
        new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("thread");
            }
        }.start();
    }
}
