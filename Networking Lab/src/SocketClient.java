import java.io.*;
import java.net.*;

public class SocketClient {
    public static void main(String[] args) {
        String ntpServer = "time.nist.gov"; // NTP server address
        int port = 13; // NTP server port (daytime protocol)

        System.out.println("Nikesh - Lab 18: Client Application with Socket Options\n");
        try {
            // Connect to the server using different socket constructors
            Socket socket = new Socket(ntpServer, port);

            // Set socket options
            socket.setTcpNoDelay(true);
            socket.setSoTimeout(5000); // Set timeout to 5 seconds

            // Retrieve and display socket information
            System.out.println("Connected to server at " + socket.getInetAddress() + ":" + socket.getPort());
            System.out.println("Local socket address: " + socket.getLocalSocketAddress());
            System.out.println("TCP_NODELAY: " + socket.getTcpNoDelay());
            System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());

            // Send request to server
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println("GET_DATE");

            // Process server response
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = in.readLine();
            System.out.println("Server response: " + serverResponse);

            // Close connections
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
