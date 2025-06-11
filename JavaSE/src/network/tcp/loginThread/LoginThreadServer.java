package network.tcp.loginThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginThreadServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        int sum = 1 ;
        while (true) {
            Socket socket = serverSocket.accept();
            new LoginThread(socket).start();
            System.out.println("这是第 "+ sum + "个请求，对方的IP地址为：" + socket.getInetAddress());
            sum ++;
        }

    }
}
