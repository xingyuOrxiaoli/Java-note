package network.tcp.login;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class LoginClient {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);

        // 一次发送信息
        OutputStream socketOutputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(socketOutputStream);
        dataOutputStream.writeUTF("Hello World Server 我是客户端");


        // 一次接受信息
        InputStream socketInputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(socketInputStream);
        String msg = dataInputStream.readUTF();
        System.out.println(msg);

        dataInputStream.close();
        dataOutputStream.close();
    }
}
