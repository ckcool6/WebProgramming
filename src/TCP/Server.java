package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10001);

        Socket accept = ss.accept();
        InputStream is = accept.getInputStream();

        int b;
        while ((b = is.read()) != -1) {
            System.out.print((char) b);
        }

        /*
        OutputStream os = accept.getOutputStream();
        os.write("who are you?".getBytes());
        */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
        bw.write("who are you?");
        bw.newLine();
        bw.flush();

        bw.close();
        is.close();
        accept.close();
        ss.close();
    }
}
