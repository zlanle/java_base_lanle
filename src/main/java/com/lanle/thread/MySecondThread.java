package com.lanle.thread;

public class MySecondThread implements Runnable {
    private int i = 5;
    private static boolean isFlag = false;

    @Override
    public void run() {
        while (!isFlag){
            System.out.print(i + "\t");
            i--;
            if(i<0) isFlag = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MySecondThread mySecondThread = new MySecondThread();
        Thread thread = new Thread(mySecondThread,"我的第二个线程");
        thread.start();
    }
}
