package com.lanle.thread;

/**
 * 同步方法
 * 当某个对象调用了同步方法，该对象上的其他同步方法，
 * 必须等待该同步方法执行完毕之后才能被执行。
 * 必须将每个能访问的共享资源的方法修饰为synchronized，否则就会报错
 */
public class LanSynchronizedThread implements Runnable{

    public int number = 10;

    //定义同步方法
    public synchronized void doIt(){
        if (number > 0){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"----票数："+number--);
        }
    }

    @Override
    public void run() {
        while (true){
            doIt();
        }
    }

    public static void main(String[] args) {
        LanSynchronizedThread lanSynchronizedThread = new LanSynchronizedThread();
        Thread thread11 = new Thread(lanSynchronizedThread, "线程11");
        Thread thread22 = new Thread(lanSynchronizedThread, "线程22");
        Thread thread33 = new Thread(lanSynchronizedThread, "线程33");
        thread11.start();
        thread22.start();
        thread33.start();
    }
}
