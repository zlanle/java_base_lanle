package com.lanle.socket.udp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class LanReceive extends JFrame implements Runnable, ActionListener {

    private int port = 9898;
    private Thread thread;
    private JButton start = new JButton("开始接收");
    private JButton stop = new JButton("停止接收");
    private JTextArea showTip = new JTextArea(10,10);
    private JTextArea show = new JTextArea(10,10);
    private boolean getMessage = true;
    InetAddress group = null;
    MulticastSocket socket = null;

    public LanReceive(){
        super("广播数据包");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300,300,500,500);
        setVisible(true);
        thread = new Thread(this);
        start.addActionListener(this);
        stop.addActionListener(this);
        showTip.setForeground(Color.red);

        JPanel north = new JPanel();
        north.add(start);
        north.add(stop);
        add(north,BorderLayout.NORTH);

        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,2));
        center.add(showTip);
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(show);
        center.add(jScrollPane);
        add(center,BorderLayout.SOUTH);

        validate();//刷新组件
        try {
            //指定接收地址
            group = InetAddress.getByName("224.255.10.0");
            socket = new MulticastSocket(port);
            socket.joinGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start){
            start.setBackground(Color.red);
            stop.setBackground(Color.yellow);
            if (!thread.isAlive()){
                thread = new Thread(this);
                getMessage = true;
            }
            thread.start();
        }
        if (e.getSource() == stop){
            start.setBackground(Color.yellow);
            stop.setBackground(Color.red);
            getMessage = false;
        }
    }

    @Override
    public void run() {
        while (getMessage){
            byte[] data = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(data, data.length, group, port);
            try {
                socket.receive(datagramPacket);
                String message = new String(datagramPacket.getData(), 0, datagramPacket.getLength());
                showTip.setText("正在接收的内容：\n"+message);
                show.append(message+"\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        LanReceive receive = new LanReceive();
        receive.setSize(660,150);
    }
}
