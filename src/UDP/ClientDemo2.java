package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();
        String s = "hello,zubo";
        byte[] bytes = s.getBytes();
        InetAddress address = InetAddress.getByName("224.0.1.0");
        int port = 10000;
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length,address,port);

        ds.send(dp);
        ds.close();
    }
}
