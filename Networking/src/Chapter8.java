import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.*;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class Chapter8 {
    public static void main(String[] args) {

        SocketFactory socketFactory = SSLSocketFactory.getDefault();
        try {
        /*
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

            */

//            ServerSocketFactory serverSocketFactory = ServerSocketFactory.getDefault();
//            SSLServerSocket sslServerSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(4200);

            SSLSocket sslSocket = (SSLSocket) socketFactory.createSocket();
            List<String> ciphers = List.of(sslSocket.getSupportedCipherSuites());
            System.out.println(ciphers);
            sslSocket.setUseClientMode(true);
            sslSocket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256"});

            System.out.println("\nEnabled cipher suites: " + Arrays.toString(sslSocket.getEnabledCipherSuites()));

            sslSocket.setEnableSessionCreation(true);
            System.out.println("Is session creatin enabled: "+ sslSocket.getEnableSessionCreation());

            sslSocket.setNeedClientAuth(true);
            System.out.println("Need client auth: " + sslSocket.getNeedClientAuth());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
