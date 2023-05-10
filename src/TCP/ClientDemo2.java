package TCP;

import java.io.*;
import java.net.Socket;

public class ClientDemo2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10001);

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.jpg"));
        OutputStream os = socket.getOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(os);
        int b;
        while ((b = bis.read()) != -1) {
            bos.write(b);
        }
        socket.shutdownOutput();

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        bis.close();
        socket.close();
    }
}
