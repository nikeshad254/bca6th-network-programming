import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SimpleSSLClient {
    public static void main(String[] args) throws Exception {
        // Load truststore
        KeyStore trustStore = KeyStore.getInstance("PKCS12");
        FileInputStream trustStoreStream = new FileInputStream("C:\\Windows\\System32\\truststore.p12");
        trustStore.load(trustStoreStream, "pass1234".toCharArray());

        // Set up trust manager factory
        TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(trustStore);

        // Set up SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(null, tmf.getTrustManagers(), null);

        // Create SSL socket
        SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
        SSLSocket sslSocket = (SSLSocket) sslSocketFactory.createSocket("localhost", 8443);

        // Configure socket
        sslSocket.setEnabledProtocols(new String[] {"TLSv1.3", "TLSv1.2"});
        sslSocket.setEnabledCipherSuites(new String[] {
                "TLS_AES_128_GCM_SHA256",
                "TLS_AES_256_GCM_SHA384",
                "TLS_CHACHA20_POLY1305_SHA256"
        });

        BufferedReader reader = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter writer = new PrintWriter(sslSocket.getOutputStream(), true);

        writer.println("Hello, server!");
        String response = reader.readLine();
        System.out.println("Server response: " + response);

        sslSocket.close();
    }
}
