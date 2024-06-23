import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

// Chapter 7 - Server Socket
public class Chapter7 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(13);
            Socket socket = serverSocket.accept();

            // writing from server
            OutputStream o = socket.getOutputStream();
            Writer writer = new OutputStreamWriter(o);

            Date date = new Date();
            long byteDate = (byte) date.getTime();

            // output stream can only write byte data
            o.write((int) byteDate);

            // writer is used to write data in string
            writer.write(date.toString());

            // reading from client in server and write from server too.
            InputStream i = new BufferedInputStream(socket.getInputStream());
            int c;
            while((c = i.read()) != -1){
                writer.write((char) c);
            }



            o.flush();
            socket.close();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
