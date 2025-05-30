package io;

import java.io.*;

public class FileBufferReaderWriterTest2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("io_file/FileBufferReaderWriterTest.txt");
        FileWriter fileWriter = new FileWriter("io_file/FileBufferReaderWriterTest_copy2.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        char[] buf = new char[1024];
        int len ;
        while((len=bufferedReader.read(buf))!=-1){
            bufferedWriter.write(buf, 0 , len);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
