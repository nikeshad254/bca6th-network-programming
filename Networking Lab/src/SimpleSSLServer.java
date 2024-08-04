import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SimpleSSLServer {
    public static void main(String[] args) throws Exception {
        // Load server keystore
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        FileInputStream keyStoreStream = new FileInputStream("C:\\Windows\\System32\\server.p12");
        keyStore.load(keyStoreStream, "pass1234".toCharArray());

        // Set up key manager factory
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "pass1234".toCharArray());

        // Load truststore
        KeyStore trustStore = KeyStore.getInstance("PKCS12");
        FileInputStream trustStoreStream = new FileInputStream("C:\\Windows\\System32\\truststore.p12");
        trustStore.load(trustStoreStream, "pass1234".toCharArray());

        // Set up trust manager factory
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);

        // Set up SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

        // Create server socket
        SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
        SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(8443);

        // Configure server socket
        sslServerSocket.setEnabledProtocols(new String[] {"TLSv1.3", "TLSv1.2"});
        sslServerSocket.setEnabledCipherSuites(new String[] {
                "TLS_AES_128_GCM_SHA256",
                "TLS_AES_256_GCM_SHA384",
                "TLS_CHACHA20_POLY1305_SHA256"
        });

        System.out.println("SSL Server started...");

        while (true) {
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
            new Thread(() -> handleClient(sslSocket)).start();
        }
    }

    private static void handleClient(SSLSocket sslSocket) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
             PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true)) {

            String message = reader.readLine();
            System.out.println("Received: " + message);
            writer.println("Echo: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
