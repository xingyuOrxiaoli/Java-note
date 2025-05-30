package io;

import java.io.*;

public class FileBufferStreamTest2 {
    public static void main(String[] args) throws IOException {

        File file = new File("io_file/FileBufferStreamTest.txt");
        InputStream fileInputStream = new FileInputStream(file);

        File file_copy = new File("io_file/FileBufferStreamTest_copy2.txt");
        OutputStream fileOutputStream = new FileOutputStream(file_copy);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] buffer = new byte[1024];
        int len ;
        while ((len = bufferedInputStream.read(buffer)) != -1) {
            bufferedOutputStream.write(buffer, 0, len);
        }


        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
