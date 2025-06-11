package network.base;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {

        InetAddress localhost = InetAddress.getLocalHost();
        InetAddress baiDu = InetAddress.getByName("www.baidu.com");
        InetAddress beiKe = InetAddress.getByName("www.ustb.edu.cn");

        InetAddress ip = beiKe;

        System.out.println(ip);
        System.out.println(ip.getHostAddress());
        System.out.println(ip.getHostName());
        System.out.println(Arrays.toString(ip.getAddress()));

    }

}
