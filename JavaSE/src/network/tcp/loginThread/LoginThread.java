package network.tcp.loginThread;

import java.io.*;
import java.net.Socket;

public class LoginThread extends Thread{
    private Socket socket;
    public LoginThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        DataInputStream dataInputStream = null;
        DataOutputStream acceptDataOutputStream = null;
        try {
        // 一次接受信息

            InputStream acceptInputStream = this.socket.getInputStream();
            dataInputStream = new DataInputStream(acceptInputStream);
            String msg = dataInputStream.readUTF();
            System.out.println(msg);

            // 发送信息
            OutputStream acceptOutputStream = this.socket.getOutputStream();
            acceptDataOutputStream = new DataOutputStream(acceptOutputStream);
            acceptDataOutputStream.writeUTF("Hello World Client 我是服务端");


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

            try {
                if(dataInputStream != null) {
                    dataInputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            assert acceptDataOutputStream != null;
            try {
                if(acceptDataOutputStream != null) {
                    acceptDataOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
