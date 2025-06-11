package network.udp;

import java.io.IOException;
import java.net.*;

public class ClientTest {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(8081);
        String msg = "Hello World 我是客户端";
        byte[] buf = msg.getBytes();
        DatagramPacket pack = new DatagramPacket(buf,buf.length, InetAddress.getLocalHost(),8080);
        socket.send(pack);

        buf = new byte[1024];
        DatagramPacket accept = new DatagramPacket(buf,buf.length);
        socket.receive(accept);

        System.out.println(accept);
        System.out.println(accept.getData());    // 数组
        System.out.println(new String(accept.getData(),0,accept.getLength()));
        System.out.println(accept.getLength());
        System.out.println(accept.getAddress()); // 对方的ip地址
        System.out.println(accept.getPort());    // 对方接受信息的端口

        socket.close();
    }
}
