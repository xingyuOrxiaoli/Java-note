package network.base;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("https://www.ustb.edu.cn:8080/rcpy/index.htm");

        System.out.println(url.getProtocol()); // https
        System.out.println(url.getHost()); // www.ustb.edu.cn
        System.out.println(url.getPort());
        System.out.println(url.getDefaultPort()); // https默认端口
        System.out.println(url.getPath());
    }
}
