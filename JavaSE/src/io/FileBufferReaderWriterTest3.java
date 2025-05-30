package io;

import java.io.*;

public class FileBufferReaderWriterTest3 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("io_file/FileBufferReaderWriterTest.txt");
        FileWriter fileWriter = new FileWriter("io_file/FileBufferReaderWriterTest_copy3.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);


        String line = null;
        while((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line);  // 没有换行
            bufferedWriter.newLine();   // 添加一个换行
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
