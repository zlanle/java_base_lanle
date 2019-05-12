package com.lanle.socket.udp;

import javax.sound.sampled.Port;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LanBroadCast extends Thread {
    private int port = 9898;
    InetAddress inetAddress = null;
    MulticastSocket multicastSocket = null;
    public LanBroadCast(){
        try {
            //实例化InetAddress，指定主机所在组，组的范围是224.0.0.0·239.255.255.255
            inetAddress = InetAddress.getByName("224.255.10.0");
            //实例化多点广播套接字
            multicastSocket = new MulticastSocket(port);
            multicastSocket.setTimeToLive(1);//指定发送范围是本地网络
            multicastSocket.joinGroup(inetAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
            String broadcast = "("+simpleDateFormat.format(new Date())+")节目预报：八点有大型晚会，请收听。";
            byte[] data = broadcast.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(data,data.length,inetAddress,port);
            System.out.println(new String(data));
            try {
                multicastSocket.send(datagramPacket);
                sleep(6000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        LanBroadCast lanBroadCast = new LanBroadCast();
        lanBroadCast.start();
    }
}
