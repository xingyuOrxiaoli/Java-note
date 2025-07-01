package jdkVersion.jdk12;

public class JDK12 {
    public static void main(String[] args) {

        char ch = '1';

        switch (ch){
            case '1' -> System.out.println("1");
            case '2' -> System.out.println("2");
            case '3' -> System.out.println("3");
            case '4' ,'5' -> System.out.println("4 , 5");
            default -> System.out.println("default");
        }


    }
}
