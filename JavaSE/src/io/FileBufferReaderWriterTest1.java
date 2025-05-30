package io;

import java.io.*;

public class FileBufferReaderWriterTest1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("io_file/FileBufferReaderWriterTest.txt");
        FileWriter fileWriter = new FileWriter("io_file/FileBufferReaderWriterTest_copy1.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        int n ;
        while((n=bufferedReader.read())!=-1){
            bufferedWriter.write(n);
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
