package com.lanle.thread;

import javax.swing.*;
import java.awt.*;

/**
 * 线程中断
 */
public class LanInterruptedThread extends JFrame {

    private Thread thread;

    public LanInterruptedThread(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(500,500,300,300);
        setVisible(true);
        final JProgressBar jProgressBar = new JProgressBar();
        getContentPane().add(jProgressBar, BorderLayout.CENTER);
        jProgressBar.setStringPainted(true);
        thread = new Thread(){
            int count = 0;
            public void run(){
                while (true){
                    jProgressBar.setValue(++count);
                    if (count == 30)
                        interrupt();
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        System.out.println("当前线程被打断");
                        break;
                    }
                }
            }
        };
        thread.start();
    }

    public static void main(String[] args) {
        new LanInterruptedThread();
    }
}
