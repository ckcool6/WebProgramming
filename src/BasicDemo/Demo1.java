//ip地址，端口，协议
package BasicDemo;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Demo1 {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getByName("DESKTOP-ENGAOKK");

        String hostname = address.getHostName();
        String hostAddress = address.getHostAddress();

        System.out.println("主机名" + hostname);
        System.out.println("IP地址" + hostAddress);
    }
}
