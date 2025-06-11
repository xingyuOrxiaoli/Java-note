package network.tcp.fileUpload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TCPServerTest {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        Socket accept = serverSocket.accept();

        String path = "src/network/tcp/fileUpload/此去半生Server.mp3";
        BufferedInputStream bis = new BufferedInputStream(accept.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(Paths.get(path)));

        byte[] buffer = new byte[1024];
        int len ;
        while ((len = bis.read(buffer))!= -1) {
            bos.write(buffer, 0, len);
        }

        bis.close();
        bos.close();
    }
}
