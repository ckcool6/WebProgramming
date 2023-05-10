package TCP;

import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class ThreadSocket implements Runnable {
    private Socket acceptSocket;

    public ThreadSocket(Socket accept) {
        this.acceptSocket = accept;
    }

    @Override
    public void run() {
        BufferedOutputStream bos = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(acceptSocket.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(UUID.randomUUID().toString() + ".jpg"));

            int b;
            while ((b = bis.read()) != -1) {
                bos.write(b);
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(acceptSocket.getOutputStream()));
            bw.write("上传成功");
            bw.newLine();
            bw.flush();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (acceptSocket != null) {
                    acceptSocket.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
