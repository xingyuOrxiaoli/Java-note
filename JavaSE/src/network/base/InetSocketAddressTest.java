package network.base;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public class InetSocketAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetSocketAddress addressSocket = new InetSocketAddress("127.0.0.1", 8080);

        InetAddress localhost = InetAddress.getLocalHost();
        InetAddress baiDu = InetAddress.getByName("www.baidu.com");
        InetAddress beiKe = InetAddress.getByName("www.ustb.edu.cn");

        InetAddress ip = localhost;
        InetSocketAddress localhost2 = new InetSocketAddress(ip, 8080);

        System.out.println(localhost);


    }
}
