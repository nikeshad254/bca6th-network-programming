import javax.net.SocketFactory;
import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Chapter8 {
    public static void main(String[] args) {
        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        try {
            Socket socket;
//            socket = socketFactory.createSocket("www.google.com", 3400);  // host string, port
//            socket = socketFactory.createSocket(InetAddress.getByName("www.google.com"), 4200); // host intetaddress, port
            socket = socketFactory.createSocket(InetAddress.getByName("www.google.com"), 4200); // host intetaddress, port



            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(123434);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(123);


            SSLSocket sslSocket =  (SSLSocket) socketFactory.createSocket("www.google.com", 4200);
            sslSocket.addHandshakeCompletedListener(new HandshakeCompletedListener() {
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    System.out.println("Handshake completed");
                }
            });

            sslSocket.removeHandshakeCompletedListener(new HandshakeCompletedListener() {
                @Override
                public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
                    System.out.println("Handshake Removed");
                }
            });

            sslSocket.setUseClientMode(true);




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
