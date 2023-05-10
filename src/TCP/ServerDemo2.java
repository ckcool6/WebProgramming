package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ServerDemo2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        while (true) {
            Socket accept = ss.accept();
            ThreadSocket ts = new ThreadSocket(accept);
            new Thread(ts).start();
        }
    }
}
