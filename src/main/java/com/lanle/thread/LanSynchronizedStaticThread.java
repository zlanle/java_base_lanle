package com.lanle.thread;

/**
 * 同步块（有效的防止资源冲突）
 *
 */
public class LanSynchronizedStaticThread implements Runnable {

    int number = 10;
    @Override
    public void run() {
        while (true){
            //设置同步代码块
            synchronized (this){
                if (number > 0){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"----票数"+number--);
                }
            }
        }
    }

    public static void main(String[] args) {
        LanSynchronizedStaticThread lanSynchronizedStaticThread = new LanSynchronizedStaticThread();
        Thread thread1 = new Thread(lanSynchronizedStaticThread, "线程1");
        Thread thread2 = new Thread(lanSynchronizedStaticThread, "线程2");
        Thread thread3 = new Thread(lanSynchronizedStaticThread, "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
