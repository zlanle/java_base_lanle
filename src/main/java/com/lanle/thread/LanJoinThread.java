package com.lanle.thread;

import javax.swing.*;
import java.awt.*;

/**
 * 线程加入
 * 假如存在一个线程A，现在需要插入线程B，并要求线程B执行完成之后，
 * 在执行线程A
 */
public class LanJoinThread extends JFrame {

    private static final long serialVersionUID = 1L;
    private Thread threadA;
    private Thread threadB;
    private JProgressBar jProgressBar1 = new JProgressBar();
    private JProgressBar jProgressBar2 = new JProgressBar();
    private int count = 0;

    public LanJoinThread(){
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,500,300,300);
        setVisible(true);
        getContentPane().add(jProgressBar1, BorderLayout.NORTH);
        getContentPane().add(jProgressBar2, BorderLayout.SOUTH);
        jProgressBar1.setStringPainted(true);
        jProgressBar2.setStringPainted(true);

        threadA = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true){
                    jProgressBar1.setValue(++count);
                    try {
                        Thread.sleep(100);
                        if (count == 20){
                            threadB.join();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        threadA.start();
        threadB = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true){
                    jProgressBar2.setValue(++count);
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (count == 100) break;
                }
            }
        });
        threadB.start();
    }

    public static void main(String[] args) {
        new LanJoinThread();
    }

}
