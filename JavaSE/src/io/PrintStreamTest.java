package io;

import java.io.*;

public class PrintStreamTest {
    public static void main(String[] args) throws IOException {
        PrintStream printStream = System.out; // 打印控制台
        printStream = new PrintStream(new FileOutputStream("io_file/PrintStreamTest_printSteam.txt"));
        printStream.println("Hello World");
        printStream.println("12");


        BufferedReader bufferedReader = new BufferedReader(new FileReader("io_file/PrintStreamTest_printSteam.txt"));
        PrintWriter printWriter = new PrintWriter("io_file/PrintStreamTest_printWriter_copy1.txt");

        String line = null;
        while((line = bufferedReader.readLine()) != null){
            printWriter.println(line);  // 不用再想Writer那个需要添加换行
        }


    }
}
