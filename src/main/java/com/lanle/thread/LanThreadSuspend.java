package com.lanle.thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * 手机摇号抽奖
 */
public class LanThreadSuspend extends JFrame {

    private JLabel label;

    private ThreadSuspend threadSuspend;

    public LanThreadSuspend(){
        setTitle("手机号码抽奖");//设置窗口标题
        setDefaultCloseOperation(EXIT_ON_CLOSE); //窗口关闭规则，窗口关闭则停止程序
        setBounds(200,200,500,350);//设置窗口坐标和大小
        label = new JLabel("0");//实例化标签初始化值为0
        label.setHorizontalAlignment(SwingConstants.CENTER);//标签文字居中
        label.setFont(new Font("宋体",Font.PLAIN,42));//标签字段为宋体42号
        getContentPane().add(label,BorderLayout.CENTER);//将标签添加到窗口容器中间区域
        final JButton button = new JButton("暂停");//实例化一个按钮
        getContentPane().add(button, BorderLayout.SOUTH);//将按钮添加到窗口容器下方
        threadSuspend = new ThreadSuspend();//实例化自定义线程类
        threadSuspend.start();//启动线程
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = button.getText();
                if ("暂停".equals(buttonText)){
                    threadSuspend.toSuspend();//自定义线程暂停
                    button.setText("继续");
                }else{
                    threadSuspend.toRun();//自定义线程继续
                    button.setText("暂停");
                }
            }
        });
        //设置窗口可见性
        setVisible(true);
    }

    public static void main(String[] args) {
        new LanThreadSuspend();
    }

    class ThreadSuspend extends Thread{
        //线程挂起状态，若suspend为false，线程会正常运行，若suspend为true，则线程会处于挂起状态
        private boolean suspend = false;
        //(线程安全的)线程暂停方法
        public synchronized void toSuspend(){
            suspend = true;
        }
        //线程恢复运行方法，除了将suspend变为false,同时使用超级父类Object类提供notify()方法唤醒线程
        public synchronized void toRun(){
            suspend = false;
            notify();
        }

        @Override
        public void run() {
            //定义抽奖池
            String[] phoneNumber = new String[]{"15236235767","16637945523","13333797121","13383879893",
                    "15837970724","15236265767","16636363523","13333798821","13383877773","15837354224"};
            //内幕抽奖池
            //String[] phoneNumber1 = new String[]{"15236235767","16637945523"};
            while (true){
                synchronized (this){
                    while (suspend){
                        try {
                            wait();//超级父类Object类提供的等待方法
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                int randomIndex = new Random().nextInt(phoneNumber.length);
                label.setText(phoneNumber[randomIndex]);
                //int randomIndex1 = new Random().nextInt(phoneNumber1.length);
                //label.setText(phoneNumber[randomIndex1]);
            }
        }
    }
}
