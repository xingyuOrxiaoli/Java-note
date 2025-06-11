package network.udp;


import java.io.IOException;
import java.net.*;

public class ServerTest {
    public static void main(String[] args) throws IOException {

        DatagramSocket socket = new DatagramSocket(8080);

        byte[] buf = new byte[1024];
        DatagramPacket pack = new DatagramPacket(buf,buf.length);
        socket.receive(pack);

        System.out.println(pack);
        System.out.println(pack.getData());    // 数组
        System.out.println(new String(pack.getData(),0,pack.getLength()));
        System.out.println(pack.getLength());
        System.out.println(pack.getAddress()); // 对方的ip地址
        System.out.println(pack.getPort());    // 对方接受信息的端口

        String msg = "在的,我是服务端";
        buf = msg.getBytes();
        DatagramPacket packSend = new DatagramPacket(buf,buf.length,pack.getAddress(),pack.getPort());
        socket.send(packSend);


        socket.close();
    }
}
