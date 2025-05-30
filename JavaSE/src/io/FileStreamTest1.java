package io;

import java.io.*;

public class FileStreamTest1 {
    public static void main(String[] args) throws IOException {

        File file = new File("io_file/FileStreamTest.txt");
        InputStream fileInputStream = new FileInputStream(file);

        File file_copy = new File("io_file/FileStreamTest_copy1.txt");
        OutputStream fileOutputStream = new FileOutputStream(file_copy);

        int n = fileInputStream.read();
        while (n != -1) {
            fileOutputStream.write(n);
            n = fileInputStream.read();
        }


        fileInputStream.close();
        fileOutputStream.close();
    }
}
