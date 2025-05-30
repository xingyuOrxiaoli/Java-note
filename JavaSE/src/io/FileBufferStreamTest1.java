package io;

import java.io.*;

public class FileBufferStreamTest1 {
    public static void main(String[] args) throws IOException {

        File file = new File("io_file/FileBufferStreamTest.txt");
        InputStream fileInputStream = new FileInputStream(file);

        File file_copy = new File("io_file/FileBufferStreamTest_copy1.txt");
        OutputStream fileOutputStream = new FileOutputStream(file_copy);

        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        int read ;
        while ((read = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write(read);
        }


        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
