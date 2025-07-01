package properties;

import java.io.*;
import java.util.Properties;

public class GainDataProperties {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.put("key3","value3");
        System.out.println(properties.getProperty("key3"));
//        properties.put(1,"number1");
        System.out.println(properties.get(1));


        properties.setProperty("key4","value4");
        System.out.println(properties.getProperty("key4"));


        // 写属性文件
        OutputStream os = new FileOutputStream("src/properties/writeFile.properties");
        properties.store(os,"这是一个注释 This is Head");

        // 读数据文件
        InputStream is = new FileInputStream("src/properties/file1.properties");
        properties.load(is);
        System.out.println(properties);


        // 读取当前项目中的属性文件
//        InputStream resourceAsStream = GainDataProperties.class.getResourceAsStream("/properties/file2.properties");
        InputStream resourceAsStream = GainDataProperties.class.getResourceAsStream("file2.properties");
        properties.load(resourceAsStream);
        System.out.println(properties);

    }
}
