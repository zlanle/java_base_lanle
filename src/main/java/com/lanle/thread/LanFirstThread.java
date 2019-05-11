package com.lanle.thread;

public class LanFirstThread extends Thread {
    private int i = 10;
    private static boolean isFlag = false;
    public void run(){
        while (!isFlag){
            System.out.print(i + "\t");
            i--;
            if(i==0) isFlag = true;
        }
    }

    public static void main(String[] args) {
        LanFirstThread lanFirstThread = new LanFirstThread();
        lanFirstThread.start();
    }
}
