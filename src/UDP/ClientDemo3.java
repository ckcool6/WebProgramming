package UDP;

import java.io.IOException;
import java.net.*;

public class ClientDemo3 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String s = "guangbo";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("255.255.255.255");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length, address, port);
        ds.send(dp);
        ds.close();
    }
}
