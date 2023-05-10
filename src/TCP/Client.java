package TCP;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 10001);

        OutputStream os = socket.getOutputStream();
        os.write("hello".getBytes());
        socket.shutdownOutput(); //结束标记

        /*
        InputStream is = socket.getInputStream();
        int b;
        while ((b = is.read()) != -1) {
        System.out.print((char) b);
        }
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
        os.close();
        socket.close();
    }
}
