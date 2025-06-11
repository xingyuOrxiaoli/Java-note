package network.tcp.fileUpload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TCPClientTest {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8080);

        String path = "src/network/tcp/fileUpload/此去半生.mp3";

        BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(path)));
        OutputStream socketOutputStream = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(socketOutputStream);

        byte[] buffer = new byte[1024];
        int len ;
        while ((len = bis.read(buffer))!= -1) {
            bos.write(buffer, 0, len);
        }

        bis.close();
        bos.close();
    }
}
