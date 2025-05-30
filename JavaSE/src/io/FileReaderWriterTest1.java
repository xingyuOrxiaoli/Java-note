package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest1 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("io_file/FileReaderWriterTest.txt");
        FileWriter fileWriter = new FileWriter("io_file/FileReaderWriterTest_copy1.txt");

        int n ;
        while((n=fileReader.read())!=-1){
            fileWriter.write(n);
        }

        fileReader.close();
        fileWriter.close();
    }
}
