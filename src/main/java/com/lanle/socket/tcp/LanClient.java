package com.lanle.socket.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class LanClient {

    public static void main(String[] args) {
        try {
            Socket client = new Socket("127.0.0.1", 8883);
            System.out.println("链接服务器成功");
            InputStream inputStream = client.getInputStream();
            OutputStream outputStream = client.getOutputStream();
            outputStream.write("我是客户端，欢迎光临".getBytes());
            byte[] bytes = new byte[1024];
            int len = inputStream.read(bytes);
            String data = new String(bytes, 0, len);
            System.out.println("来自服务器端的消息："+data);
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
