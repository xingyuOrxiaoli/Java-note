package io;

import java.io.*;

public class DataStreamTest1 {
    public static void main(String[] args) throws IOException {
        write();
        read();
    }

    public static void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("DataStreamTest.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        DataOutputStream dataOutputStream = new DataOutputStream(bufferedOutputStream);


        // 八大基本数据类型
        dataOutputStream.writeByte(1);
        dataOutputStream.writeChar('2');
        dataOutputStream.writeShort(3);
        dataOutputStream.writeInt(4);
        dataOutputStream.writeLong(5);
        dataOutputStream.writeFloat(6);
        dataOutputStream.writeDouble(7);
        dataOutputStream.writeBoolean(true);

//        dataOutputStream.writeChars("chars");
//        dataOutputStream.writeBytes("bytes");
        // 字符串
        dataOutputStream.writeUTF("UTF-8");

        dataOutputStream.close();
    }

    public static void read() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("DataStreamTest.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);

        byte b = dataInputStream.readByte();
        char c = dataInputStream.readChar();
        short s = dataInputStream.readShort();
        int i = dataInputStream.readInt();
        long l = dataInputStream.readLong();
        float f = dataInputStream.readFloat();
        double d = dataInputStream.readDouble();
        boolean b1 = dataInputStream.readBoolean();
        System.out.println("八大基本类型：");
        System.out.println("byte    : " + b);
        System.out.println("char    : " +c);
        System.out.println("short   : " +s);
        System.out.println("int     : " +i);
        System.out.println("long    : " +l);
        System.out.println("float   : " +f);
        System.out.println("double  : " +d);
        System.out.println("boolean : " +b1);


//        System.out.print("读取多个char :");
//        for (int index = 0 ; index < 5 ; index ++) System.out.print(dataInputStream.readByte());
//        System.out.println();
//
//        System.out.print("读取多个byte :");
//        for (int index = 0 ; index < 5 ; index ++) System.out.print((char)dataInputStream.readByte());
//        System.out.println();

        System.out.println("字符串类型  ： ");
        String str1 = dataInputStream.readUTF();
        System.out.println("str1    : " + str1);

        dataInputStream.close();
    }
}
