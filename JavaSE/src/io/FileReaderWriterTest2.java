package io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest2 {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("io_file/FileReaderWriterTest.txt");
        //append true表示追加 默认为false
        FileWriter fileWriter = new FileWriter("io_file/FileReaderWriterTest_copy2.txt",false);
//        FileWriter fileWriter = new FileWriter(new File("io_file/FileReaderWriterTest_copy2.txt"),true);

        char[] buf = new char[1024];
        int len;
        while((len=fileReader.read(buf))!=-1){
            fileWriter.write(buf,0,len);
        }

        fileReader.close();
        fileWriter.close();
    }
}
