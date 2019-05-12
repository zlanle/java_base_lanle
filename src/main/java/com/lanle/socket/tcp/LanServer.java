package com.lanle.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议服务端
 */
public class LanServer {

    public static void server(){
        try {
            ServerSocket serverSocket = new ServerSocket(8883);
            System.out.println("服务器启动成功，等待客户端连接...");
            Socket client = serverSocket.accept();
            System.out.println("客户端接入，客户IP："+client.getInetAddress());
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            byte[] bt= new byte[1024];
            int len = inputStream.read(bt);
            String data = new String(bt, 0, len);
            System.out.println("来自客户端的消息："+data);
            outputStream.write("我是服务器，欢迎光临".getBytes());
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LanServer.server();
    }
}
