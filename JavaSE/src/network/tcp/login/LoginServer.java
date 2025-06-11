package network.tcp.login;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);

        // 一次接受信息
        Socket accept = serverSocket.accept();
        InputStream acceptInputStream = accept.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(acceptInputStream);
        String msg = dataInputStream.readUTF();
        System.out.println(msg);

        // 发送信息
        OutputStream acceptOutputStream = accept.getOutputStream();
        DataOutputStream acceptDataOutputStream = new DataOutputStream(acceptOutputStream);
        acceptDataOutputStream.writeUTF("Hello World Client 我是服务端");


        dataInputStream.close();
        acceptDataOutputStream.close();
    }
}
