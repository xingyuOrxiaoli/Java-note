package io;

import java.io.*;
import java.sql.Date;

public class ObjectStreamTest1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        write();
        read();
    }

    public static void write() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("ObjectStreamTest.txt");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        // 八大基本数据类型 对应的包装类
        objectOutputStream.writeByte(1);
        objectOutputStream.writeChar('2');
        objectOutputStream.writeShort(3);
        objectOutputStream.writeInt(4);
        objectOutputStream.writeLong(5);
        objectOutputStream.writeFloat(6);
        objectOutputStream.writeDouble(7);
        objectOutputStream.writeBoolean(true);
        // 字符串
        objectOutputStream.writeUTF("UTF-8");

        // 存储对象
        objectOutputStream.writeObject(new Date(System.currentTimeMillis()));

        // 写自定义对象
        Student1 student1 = new Student1("student1", 10);
        Student2 student2 = new Student2("student2", 20);
        objectOutputStream.writeObject(student1);
        objectOutputStream.writeObject(student2);


        objectOutputStream.close();
    }

    public static void read() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("ObjectStreamTest.txt");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

        Byte      b = objectInputStream.readByte();
        Character c = objectInputStream.readChar();
        Short     s = objectInputStream.readShort();
        Integer   i = objectInputStream.readInt();
        Long      l = objectInputStream.readLong();
        Float     f = objectInputStream.readFloat();
        Double    d = objectInputStream.readDouble();
        Boolean b1 = objectInputStream.readBoolean();
        System.out.println("八大基本类型的包装类：");
        System.out.println("Byte         : " + b);
        System.out.println("Character    : " +c);
        System.out.println("Short        : " +s);
        System.out.println("Integer      : " +i);
        System.out.println("Long         : " +l);
        System.out.println("Float        : " +f);
        System.out.println("Double       : " +d);
        System.out.println("Boolean      : " +b1);

        System.out.println("字符串类型  ： ");
        String str1 = objectInputStream.readUTF();
        System.out.println("str1    : " + str1);

        // 去读对象
        Date date = (Date) objectInputStream.readObject();
        System.out.println(date);

        // 读自定义对象
        Student1 student1 = (Student1) objectInputStream.readObject();
        Student2 student2 = (Student2) objectInputStream.readObject();

        System.out.println(student1);
        System.out.println(student2);

        objectInputStream.close();
    }
}

class Student1 implements Serializable{
    private String name;
    private int age;

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Student2 implements Serializable{

    private String name;
    private int age;

    public Student2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}