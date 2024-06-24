import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

// Chapter 7 - Server Socket
public class Chapter7 {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("request");;
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


            logger.warning("This is warning");
            logger.fine("This is good");

            o.flush();
            socket.close();
            serverSocket.close();

            // how many can be pending (backlog)
            ServerSocket serverSocket1 = new ServerSocket(80, 50);
            serverSocket1.close();

            // listens for connection on specified local interface.
            InetAddress local = InetAddress.getByName("192.168.100.23");
            ServerSocket serverSocket2 = new ServerSocket(80, 80, local);
            serverSocket2.close();

            // non argument constructor - won't understand which port to listen - thus need socket address & bind
            ServerSocket serverSocket3 = new ServerSocket();
            // thus we use bind to bind with the port
            SocketAddress http = new InetSocketAddress(80);
            serverSocket3.bind(http, 50);

            System.out.println("Local socket Address: "+serverSocket3.getLocalSocketAddress());
            System.out.println("Local port: "+serverSocket3.getLocalPort());
            System.out.println("InetAddress: "+serverSocket3.getInetAddress());

            serverSocket3.close();

        } catch (IOException e) {
            logger.severe("Critical Error Occured");
            throw new RuntimeException(e);
        }
    }
}
