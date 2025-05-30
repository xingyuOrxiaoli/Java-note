package io;

import java.io.*;

public class FileStreamTest2 {
    public static void main(String[] args) throws IOException {

        File file = new File("io_file/FileStreamTest.txt");
        InputStream fileInputStream = new FileInputStream(file);

        File file_copy = new File("io_file/FileStreamTest_copy2.txt");
        OutputStream fileOutputStream = new FileOutputStream(file_copy);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = fileInputStream.read(buffer)) != -1) {
            fileOutputStream.write(buffer, 0, length);
        }


        fileInputStream.close();
        fileOutputStream.close();
    }
}
